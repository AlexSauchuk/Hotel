var NameTable = "";
var CountColumn = 0;

function UpdateData(obj) {
    var params = new Array();
    var nameColumns = new Array();
    $("th",$("#id"+NameTable+"")).each(function() {
        nameColumns.push(this.innerHTML);
    });
    $("td",obj).each(function(){
        params.push(this.innerHTML);
    });

    nameColumns.pop();
    nameColumns.pop();

    params.pop();
    params.pop();
    var jsonData = JSON.stringify(params);
    var jsonColumns = JSON.stringify(nameColumns);

    $.ajax({
        type: 'POST',
        url: 'admin?table=' + NameTable+'&action=MODIFY',
        data: {"json":jsonData,"columns":jsonColumns},
        success: function(data) {
// setHtml(data);
        },
        dataType : "json",
        timeout : 30000,
        async: true
    });
}

$(document).ready(function() {

    function setHtml(data){
        console.log(data)
        var countRows = data.length;

        var headerString = '';
        var bodyString = '';
        var j = 0;
        var countColumn = 0;
        for(var key in data[0]) {
            headerString+='<th>'+key+'</th>';
            countColumn++;
        }
        while(j!=countRows){
            var strRow = '<tr class="id'+data[j].id+'" style="border: none">row</tr>';
            var patternRow = /row/;
            var additionalString = '';
            var flagId = true;
            for(var key in data[j]) {
                if(flagId) {
                    additionalString += '<td>'+data[j][key]+'</td>';
                    flagId = false;
                }
                else
                    additionalString +='<td>'+data[j][key]+'</td>';
            }
            additionalString+='<td style="border: none"><input type="button" style="width: 100%" value="UPDATE" href="/servlet?page= onclick="UpdateData( (this.parentNode).parentNode)"></td>' +
                '<td style="border: none"><input type="button" style="width: 100%" value="DELETE"></td>';
            bodyString += strRow.replace(patternRow,additionalString);
            j++;
        }

        CountColumn = countColumn;
        var headers= '<thead id="id'+NameTable+'"><tr>header</tr></thead>';
        var body = '<tbody>bodyTable</tbody>';
        var patternHead = /header/;
        var patternBody = /bodyTable/;
        headers = headers.replace(patternHead,headerString);
        body = body.replace(patternBody,bodyString);

        $('#tableHotel').html(headers + body);
    }

    $('.col-lg-3').on('click', function(event) {
        var target = event.target;

        if(!target.closest('td')) return;

        var nameTable = target.closest('td').childNodes[0].value;
        NameTable = nameTable;
        $.ajax({
            type: 'GET',
            url: '/servlet?tableName='+nameTable+'&action=GET_ALL',
            success: function(data) {
                setHtml(data);
            }
        });
    });
});