/**
 * Created by SK on 08.05.2017.
 */
$templateReservation = null;

function setReservationForm(idRoom) {
    getTemplateReservation(idRoom);
}

function getTemplateReservation(id) {
    $.get("/templates/pages/booking/templateReservation.html", "html")
        .done(function(html){
            $templateReservation = html;
            $('#idContentReservation').append($templateReservation);
            $(document.getElementById('mainFormReservationInfo').firstElementChild).children().last().children().last().val(id);
        })
        .fail(function(){ $templateRoom.html("failed to get:" + src); });
}

function getReservationData(editBody) {
    var result = '';
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
    $.ajax({
        type: 'POST',
        url: '/servlet?action=ADD' + getReservationData(editBodyUpdate[0])+'&tableName=RESERVATION',
        success: function () {
        }});
}

function acceptReservationRoom() {
    sendReservation();

    var services = document.getElementById("idServicesA");
    services.click();
}