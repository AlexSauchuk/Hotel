
$templateReservation = null;
var flag = true;

function setReservationForm(idRoom) {
    getTemplateReservation(idRoom);
}

function getTemplateReservation(id) {
    $.get("/templates/pages/booking/templateReservation.html", "html")
        .done(function(html){
            $templateReservation = html;
            $('#idContentReservation').html($templateReservation);
            $(document.getElementById('mainFormReservationInfo').firstElementChild).children().last().children().last().val(id);
        })
        .fail(function(){ $templateRoom.html("failed to get:" + src); });
}

function getReservationData(editBody) {
    var result = '';
    flag = true;
    $(editBody).each(function(){
        $("div",this).each(function() {
            if(this.className=='col-sm-9') {
                var key = $(this.firstElementChild).attr('name');
                var value = $(this.firstElementChild).val();
                if(key == 'id' && value == ''){
                    value ="0";
                }else{
                    if($(this.firstElementChild).get(0).tagName == 'SELECT'){
                        value = value.substr(0,value.indexOf(' '))
                    }
                }
                if(value==''){
                    alert("Заполните дату!");
                    flag = false;
                    return false;
                }
                result = result.concat('&',key,'=', value);
            }
        });
    });
    if(currentUser!=null)
        result = result.concat('&','id_user','=', currentUser['id']);
    else
        result = result.concat('&','id_user','=', '0');

    result = result.concat('&','cost_additional_services','=', '0');
    result = result.concat('&','id_discount','=', '1');

    return result;
}

function sendReservation() {
    var editBodyUpdate = $('#mainFormReservationInfo');
    var data = getReservationData(editBodyUpdate[0]);
    if(flag)
    $.ajax({
        type: 'POST',
        url: '/servlet?action=ADD' + data +'&tableName=RESERVATION&rights='+generatePermissionsUser(),
        success: function () {
        }});
}

function acceptReservationRoom() {
    sendReservation();
    if(flag) {
        var services = document.getElementById("idServicesA");
        services.click();
    }
}