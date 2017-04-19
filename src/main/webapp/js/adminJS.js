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
        var modalString = '<div id="modalWindow'+deep+'" class="modal fade in" style="z-index: '+zIndex+';display: block"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"  id="headID"><button class="close" onclick="decreaseDeep()" type="button" data-dismiss="modal">Close</button></div><div class="modal-body">custom</div><div  class="modal-footer" onclick="decreaseDeep()"><button class="btn btn-default"  id="closeBtn" type="button" data-dismiss="modal">Close</button></div></div></div></div>';
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
                additionalString +='<td><input type="button" style="width: 100%" value="'+(data[key])['id']+'" data-toggle="modal" data-target="#modalWindow'+deep+'" onclick="GenerateModals(this)"></td>';
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
        console.log(document.getElementById("closeBtn"));
        document.getElementById("closeBtn").focus();

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

    function UpdateData(obj) {
        var elem = $('#myModalUpdate').find('#mainForm');
        elem[0].action =
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

        console.log(arrayValues);
        if(Object.keys(arrayObj).length>0){
            var inputs = obj.getElementsByTagName('input');
            var i = 0;
            for(var arrayType in arrayObj){
                $('select[name=id'+arrayType+']').val(inputs[i].value);
                i++;
            }
        }
    }

    var NameTable = "";
    var Data;
    var futureQueryForID = {};
    var temporaryData;
    var zIndex = 1050;
    var modalStrings = new Array();
    var objects = new Array();
    var deep = 0;
    var parentModal = '';
    var childModal = '#modalWindow0';
    var arrayObj = {};
    var oldTarget;
    var mapStringsTables = {
        "roomType":"room_type",
        "user":"user",
        "reservation":"reservation"
    };

    function DeleteRow(obj) {
        $.ajax({
            type: 'POST',
            url: '/servlet?tableName=' + NameTable + '&action=REMOVE',
            data:{'entityParams': formParams(obj.closest('tr').rowIndex)},
            success:function(){
                document.getElementById('tableHotel').deleteRow(obj.closest('tr').rowIndex);
            }
        });
    }

    function formParams(rowIndex) {
        var resultParams='';
        var columnNames = $("#tableHotel").find("tr").first().children();
        for(var i=0; i< columnNames.length; i++){
            var currentObj = Data[rowIndex-1][columnNames[i].textContent];
            if($.isPlainObject(currentObj)){
                resultParams = resultParams.concat("id_",columnNames[i].textContent,":",currentObj["id"],"&");
            }else{
                resultParams = resultParams.concat(columnNames[i].textContent,":",currentObj,"&");
            }
        }
        return resultParams.slice(0,resultParams.length-1);
    }

    function GenerateChilds(arrayObj) {
        for(var arrayType in arrayObj) {
            var selectList = document.getElementById('id'+arrayType);

            if(selectList.childElementCount==0)
            for(var value in arrayObj[arrayType]) {
                var option = document.createElement("option");
                option.value = arrayObj[arrayType][value];
                option.text = arrayObj[arrayType][value];
                selectList.appendChild(option);
            }
        }
    }

    function GenerateSelectChilds() {
        for(var value in futureQueryForID) {
            $.ajax({
                type: 'GET',
                url: '/servlet?tableName=' + mapStringsTables[value] + '&action=GET_ALL_ID',
                success: function (data) {
                    arrayObj[value] = data;
                    GenerateChilds(arrayObj);
                }});
        }
    }

    function AddData(obj) {
        var elem = $('#myModalAdd').find('#mainForm');
        elem[0].action =
            '/servlet?tableName='+NameTable +'&action=ADD';
        $('#myModalAdd').find('select[name=idrole]').val(1);
    }

    function setHtml(){
        var countRows = Data.length;
        var newItem = "";
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
                    futureQueryForID[key] = key;
                    additionalString +='<td><input type="button" style="width: 100%" value="'+(Data[j][key])['id']+'" data-toggle="modal" data-target="#modalWindow'+deep+'" onclick="GenerateModals(this)"></td>';
                    GenerateSelectChilds();
                }else
                    additionalString +='<td>'+Data[j][key]+'</td>';

                if(j==countRows-1){
                    newItem += '<td></td>';
                }
            }
            additionalString+='<td style="border: none"><input type="button" style="width: 100%" value="UPDATE" data-toggle="modal" data-target="#myModalUpdate" onclick="UpdateData((this.parentNode).parentNode)"></td>' +
                '<td style="border: none"><input type="button" style="width: 100%" value="DELETE" onclick="DeleteRow(this)"></td>';
            bodyString += strRow.replace(patternRow,additionalString);

            if(j==countRows-1){
                newItem+='<td style="border: none"><input type="button" style="width: 100%" value="ADD" data-toggle="modal" data-target="#myModalAdd" onclick="AddData((this.parentNode).parentNode)"></td>';
                bodyString += strRow.replace(patternRow,newItem);
            }
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
    var table = NameTable;
    if(NameTable=="room")
        table="rooms";
    request.open('GET', '/templates/'+table+'.html');
    request.onreadystatechange = function() {
        if (request.readyState == 4) {
            if (request.status == 200) {
                $('#myModalUpdate').html(request.responseText);
                $('#myModalAdd').html(request.responseText);
            } else {
                alert('Network error, code: ' + request.status);
            }
        }
    };
    request.send(null);
}

$(document).ready(function() {

    $('.col-lg-3').on('click', function(event) {
        var target = event.target;

        if(oldTarget!=null)
            oldTarget.style.backgroundColor = "rgb(235, 235, 228)";
        oldTarget = target.closest('td').childNodes[0];

        target.closest('td').childNodes[0].classList.add("animationColor");
        if(!target.closest('td')) return;

        var nameTable = target.closest('td').childNodes[0].value;
        NameTable = nameTable;
        $.ajax({
            type: 'GET',
            url: '/servlet?tableName='+nameTable +'&action=GET_ALL',
            success: function(data) {
                console.log(data);
                futureQueryForID = {};
                LoadTemplate();
                arrayObj = {};
                objects = new Array();
                Data = data;
                setHtml();
            }
        });
    });
});