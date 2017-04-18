/**
 * Created by SK on 28.03.2017.
 */
    function decreaseDeep() {
        deep--;
        zIndex--;
        modalStrings.pop();
        console.log(objects);
        objects.pop();
        console.log(objects);
        Data = objects[deep];
        var exStr = '';
        for(var str in modalStrings)
            exStr+=modalStrings[str];

        $('#modalWindow').html(exStr);
        document.body.removeChild(document.getElementsByClassName('modal-backdrop fade in')[document.getElementsByClassName('modal-backdrop fade in').length-1]);
    }

    function RecursionModals(data) {
        Data = data;
        var modalString = '<div id="modalWindow'+deep+'" class="modal fade in" style="z-index: '+zIndex+';display: block"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"  id="headID"><button class="close" onclick="decreaseDeep()" type="button" id="closeBtn" data-dismiss="modal">Close</button></div><div class="modal-body">custom</div><div  class="modal-footer" onclick="decreaseDeep()"><button class="btn btn-default"  id="closeBtn" type="button" data-dismiss="modal">Close</button></div></div></div></div>';
        childModal = '\'#modalWindow'+deep+'\'';
        deep++;
        parentModal = childModal;
        zIndex++;
        var headerString='';
        var table = '<table class="table table-bordered table-hover">HB</table>';
        var headers= '<thead><tr>header</tr></thead>';
        var bodyM = '<tbody><tr>bodys</tr></tbody>';
        var patternModal = /custom/;
        var patternHead = /header/;
        var patternBody = /bodys/;
        var patternTable = /HB/;

        for(var key in data) {
            headerString+='<th>'+key+'</th>';
        }
        var additionalString = '';

        for(var key in data) {

            if($.isPlainObject(data[key]))
            {
                additionalString +='<td><input type="button" style="width: 100%" value="'+data[key]+'" data-toggle="modal" data-target="#modalWindow'+deep+'" onclick="GenerateModals(this)"></td>';
            }else
                additionalString +='<td>'+data[key]+'</td>';
        }

        headers = headers.replace(patternHead,headerString);
        bodyM = bodyM.replace(patternBody,additionalString);
        table = table.replace(patternTable,headers + bodyM);
        modalString = modalString.replace(patternModal,table);
        modalStrings.push(modalString);
        var exStr = '';
        for(var str in modalStrings)
            exStr+=modalStrings[str];

        $('#modalWindow').html(exStr);

    }

    function GenerateModals(obj) {
        temporaryData = Data;
        if(deep==0 && objects.length==0)
            objects.push(temporaryData);
        var row = obj.closest("tr").rowIndex;
        var col = obj.closest("td").cellIndex;

        if(temporaryData instanceof window.Array)
            objects.push(temporaryData[row-1][Object.keys(temporaryData[row-1])[col]]);
        else
            objects.push(temporaryData[Object.keys(temporaryData)[col]]);

        RecursionModals(objects[deep+1]);
    }

    function SendUpdatesValues() {
        console.log("1");
    }

    function UpdateData(obj) {
        document.getElementById("mainForm").action =
            '/servlet?tableName='+NameTable +'&action=UPDATE';
        var editBody = document.getElementsByClassName('form-horizontal');
        var arrayValues = new Array();
        $(obj).each(function(){
            $("td",this).each(function(){
                arrayValues.push(this)
            });
        });

        arrayValues.pop();
        arrayValues.pop();

        var i = 0;
        $(editBody).each(function(){
            $("div",this).each(function(){
                if(this.className=='col-sm-8' || this.className == 'radio col-sm-8') {
                    console.log(arrayValues[i].innerHTML);
                    var sex = this.firstElementChild.getAttribute('value');

                    if (this.className == 'radio col-sm-8')
                        if(arrayValues[i].innerHTML == sex) {
                            this.childNodes[3].firstElementChild.checked = false;
                            this.firstElementChild.firstElementChild.checked = true;
                        }
                        else{
                            this.firstElementChild.firstElementChild.checked = false;
                            this.childNodes[3].firstElementChild.checked = true;
                        }
                    else
                        this.firstElementChild.setAttribute('value', arrayValues[i].innerHTML);

                    i++;
                }
            });
        });
    }

    var NameTable = "";
    var Data;
    var temporaryData;
    var zIndex = 1050;
    var modalStrings = new Array();
    var objects = new Array();
    var deep = 0;
    var parentModal = '';
    var childModal = '#modalWindow0';

    function DeleteRow(obj) {
        $.ajax({
            type: 'DELETE',
            url: '/servlet?tableName=' + NameTable + '&action=REMOVE&'+formParams(obj.closest('tr').rowIndex),
            success:function(result){
                if(result == null){
                    document.getElementById('tableHotel').deleteRow(obj.closest('tr').rowIndex);
                }else{
                    console.log(result);
                }
            }
        });
    }

    function formParams(rowIndex) {
        var resultParams='';
        var columnNames = $("#tableHotel").find("tr").first().children();
        for(var i=0; i< columnNames.length; i++){
            var currentObj = Data[rowIndex-1][columnNames[i].textContent];
            if($.isPlainObject(currentObj)){
                resultParams = resultParams.concat("id_",columnNames[i].textContent,"=",currentObj["id"],"&");
            }else{
                resultParams = resultParams.concat(columnNames[i].textContent,"=",currentObj,"&");
            }
        }
        return resultParams.slice(0,resultParams.length-1);
    }

    function setHtml(){
        var countRows = Data.length;

        var headerString = '';
        var bodyString = '';
        var j = 0;
        var countColumn = 0;
        zIndex = 1050;
        for(var key in Data[0]) {
            headerString+='<th>'+key+'</th>';
            countColumn++;
        }
        while(j!=countRows){
            var strRow = '<tr class="id'+Data[j].id+'" style="border: none">row</tr>';
            var patternRow = /row/;
            var additionalString = '';
            for(var key in Data[j]) {

                if($.isPlainObject(Data[j][key]))
                {
                    additionalString +='<td><input type="button" style="width: 100%" value="'+Data[j][key]+'" data-toggle="modal" data-target="#modalWindow'+deep+'" onclick="GenerateModals(this)"></td>';
                }else
                    additionalString +='<td>'+Data[j][key]+'</td>';
            }
            additionalString+='<td style="border: none"><input type="button" style="width: 100%" value="UPDATE" data-toggle="modal" data-target="#myModal" onclick="UpdateData((this.parentNode).parentNode)"></td>' +
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

function LoadTemplate() {
    var request = new XMLHttpRequest();
    request.open('GET', '/templates/'+NameTable+'.html');
    request.onreadystatechange = function() {
        if (request.readyState == 4) {
            if (request.status == 200) {
                $('#myModal').html(request.responseText);
            } else {
                alert('Сетевая ошибка, код: ' + request.status);
            }
        }
    };
    request.send(null);
}

$(document).ready(function() {


    $('.col-lg-3').on('click', function(event) {
        var target = event.target;

        if(!target.closest('td')) return;

        var nameTable = target.closest('td').childNodes[0].value;
        NameTable = nameTable;
        $.ajax({
            type: 'GET',
            url: '/servlet?tableName='+nameTable +'&action=GET_ALL',
            success: function(data) {
                LoadTemplate();
                objects = new Array();
                Data = data;
                setHtml();
            }
        });
    });
});