/**
 * Created by SK on 28.03.2017.
 */
function UpdateData() {
    console.log("1");
}

var NameTable = "";

function DeleteRow(obj) {
    document.getElementById('tableHotel').deleteRow(obj.closest("tr").rowIndex);
    $.ajax({
        type: 'DELETE',
        url: '/servlet?tableName='+NameTable +'&action=REMOVE',
        data:{'id':obj.closest("tr").firstChild.textContent}
    });
}

$(document).ready(function() {

    function setHtml(data){
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
            additionalString+='<td style="border: none"><input type="button" style="width: 100%" value="UPDATE" onclick="UpdateData((this.parentNode).parentNode)"></td>' +
                '<td style="border: none"><input type="button" style="width: 100%" value="DELETE" onclick="DeleteRow(this)"></td>';
            bodyString += strRow.replace(patternRow,additionalString);
            j++;
        }


        var headers= '<thead><tr>header</tr></thead>';
        var body = '<tbody>body</tbody>';
        var patternHead = /header/;
        var patternBody = /body/;
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
            url: '/servlet?tableName='+nameTable +'&action=GET_ALL',
            success: function(data) {
                console.log(data);
                setHtml(data);
            }
        });
    });
});