
$templateRoom = null;
var roomObject = {};

function getTemplateRoom() {
    $.get("/templates/pages/services/templateRoom.html", "html")
        .done(function(html){$templateRoom = html;})
        .fail(function(){ $templateRoom.html("failed to get:" + src); });
}

function parseRoomType(roomTypeObj) {
    for(var fieldRoomTypeObj in roomTypeObj){
        if(fieldRoomTypeObj=='id')
            roomObject[fieldRoomTypeObj + 'RoomType'] = roomTypeObj[fieldRoomTypeObj];
        else
            roomObject[fieldRoomTypeObj] = roomTypeObj[fieldRoomTypeObj];
    }
}

function generateRooms(arrayRooms) {
    var countRooms = arrayRooms.length;
    var i;
    for(i=0;i<countRooms;i++){
        for(var fieldRoomObj in arrayRooms[i]) {
                if (fieldRoomObj == 'roomType') {
                    parseRoomType(arrayRooms[i][fieldRoomObj]);
                } else {
                    roomObject[fieldRoomObj] = arrayRooms[i][fieldRoomObj];
                }
        }
        generateHtml(roomObject);
    }
}

function reservateRoom(e) {
    if (currentUser != null) {
        var idRoom = e.id.substr(6);
        var booking = document.getElementById("idBookingA");
        setTimeout(setReservationForm, 200,idRoom);
        booking.setAttribute('href', '#contentBooking');
        booking.click();
    }else
        alert("Вы не авторизованы!")
}

function generateHtml(roomObj) {
    $('#containerServices').append($templateRoom);

    var arrayComponentsListRoom = $(($('#containerServices').children().last().children())[1]).children();

    $(($('#containerServices').children().last().children())[2]).attr('id','idRoom' + roomObj['id']);
    arrayComponentsListRoom[0].innerHTML = roomObj["name"];
    arrayComponentsListRoom[1].lastElementChild.innerHTML = roomObj["floor"];
    arrayComponentsListRoom[2].lastElementChild.innerHTML = roomObj["roomsCount"];
    arrayComponentsListRoom[3].lastElementChild.innerHTML = roomObj["bedsCount"];
    arrayComponentsListRoom[4].lastElementChild.innerHTML = roomObj["size"];
    arrayComponentsListRoom[5].lastElementChild.innerHTML = roomObj["bathroomsCount"];
    arrayComponentsListRoom[6].lastElementChild.innerHTML = roomObj["costPerDay"];
}

function getRooms() {
    $.ajax({
        type: 'GET',
        url: '/servlet?tableName=room&action=GET_ALL&rights=4',
        success: function(data) {
            generateRooms(data);
        }
    });
}

function preparationGenerateRooms() {
    getTemplateRoom();
    getRooms();
}