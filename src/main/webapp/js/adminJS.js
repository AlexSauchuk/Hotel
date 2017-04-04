/**
 * Created by SK on 28.03.2017.
 */
function UpdateData() {
    console.log("1");
}
$(document).ready(function() {
    
    function setHtml(data){
        var countRows = data[Object.keys(data)[0]].length;
        console.log(data);
        var headerString = '';
        var bodyString = '';
        var j = 0;
        for(var key in data) {
            headerString+='<th>'+key+'</th>';
        }
        headerString+='<th>UPDATE</th><th>DELETE</th>';

        while(j!=countRows){
            var strRow = '<tr>row</tr>';
            var patternRow = /row/;
            var additionalString = '';
            for(var key in data) {
                additionalString +='<td><input type="text" style="width: 100%" value='+data[key][j]+'></td>';
            }
            additionalString+='<td><input type="button" style="width: 100%" value="UPDATE" onclick="UpdateData()"></td>' +
                '<td><input type="button" style="width: 100%" value="DELETE"></td>';
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

        $.ajax({
            type: 'GET',
            url: 'admin?table='+nameTable,
            success: function(data) {
                setHtml(data);
            }
        });
    });
});