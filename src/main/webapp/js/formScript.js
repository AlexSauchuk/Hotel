
function setEventListener() {
    ($('#idAcceptUpdatePersonalInfo')[0]).addEventListener("click", updatePersonalInfo);
}

function loadTemplate() {
    var request = new XMLHttpRequest();
    Hi();
    request.open('GET', '/templates/pages/signin/personalInfo.html');
    request.onreadystatechange = function() {
        if (request.readyState == 4) {
            if (request.status == 200) {
                $('#content').html(request.responseText);
                setEventListener();
            } else {
                alert('Network error, code: ' + request.status);
            }
        }
    };
    request.send(null);
}

function getUpdateDataUser() {
    var editBodyAdd = $('#mainForm');
    var result = '';
    
    $(editBodyAdd).each(function(){
        $("div",this).each(function() {
            if(this.className=='col-sm-9' || this.className == 'radio col-sm-9') {
                var key = $(this.firstElementChild).attr('name');
                var value = $(this.firstElementChild).val();
                if(key == 'id' && value == ''){
                    value ="0";
                }else{
                    if($(this.firstElementChild).get(0).tagName == 'SELECT'){
                        value = value.substr(0,value.indexOf(' '))
                    }
                    if(this.className == 'radio col-sm-9'){
                        key = this.id;
                        value = $("input[type='radio']:checked").val();
                    }
                }
                result = result.concat('&',key,'=', value);
            }
        });
    });
    return result;
}

function updatePersonalInfo() {
    var name = document.getElementById("name");
    var surname = document.getElementById("surname");
    var mobilePhone = document.getElementById("mobilePhone");
    var login = document.getElementById("login");
    var passportNumber = document.getElementById("passportNumber");
    var sex = document.getElementById("sex");
    var passOld = document.getElementById("passOld");
    var passNew = document.getElementById("passNew");
    console.log(validName(name.value));
    if(!validName(name.value) || !validPassword(surname.value)|| !validPassword(mobilePhone.value)|| !validPassword(login.value)
        || !validPassword(passportNumber.value)|| !validPassword(sex.value)|| !validPassword(passOld.value) || !validPassword(passNew.value))
    $.ajax({
        type: 'POST',
        url: '/servlet?action=UPDATE_USER_DATA' + getUpdateDataUser(),
        data:{},
        success: function(data) {
            
        }
    });
}

function setNewValueEntryDiv() {
    var entry = document.getElementById("idEntryA");
    entry.innerHTML = "Кабинет";
    entry.href = "";    
}

function sendUserData(email,pass){
    loadTemplate();
    setNewValueEntryDiv();
    $.ajax({
        type: 'POST',
        url: '/servlet?action=LOGIN',
        data:{"email":email,"password":pass},
        success: function(data) {
            currentUser.name = data["name"];
            currentUser.id  = parseInt(data["id"]);
        }
    });
}

function validateForm (){
    var email = document.getElementById("emailIn");
    var passw = document.getElementById("passIn");

    if (!validEmail(email.value) || !validPassword(passw.value)){
        alert ("Данные заполнены неверно!");
        return  false;
    }
    alert ("Данные успешно отправлены на сервер!");
    sendUserData();
    return  true;
}

function validName(name) {
    return (/(?=^[A-ZЁА-Я][a-zёа-я-_\.]{3,20}$)/).test(name);
}

function validLogin	(login) { //с ограничением 2-20 символов, которыми могут быть буквы и цифры, первый символ обязательно буква
    return (/(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/).test(login);
}
function validEmail(email) {
    return (/^(?:[-a-z\d\+\*\/\?!{}`~_%&'=^$#]+(?:\.[-a-z\d\+\*\/\?!{}`~_%&'=^$#]+)*)@(?:[-a-z\d_]+\.){1,60}[a-z]{2,6}$/).test(email);
}
function validPassword(passw) {//Строчные и прописные латинские буквы, цифры, спецсимволы. Минимум 8 символов):
    return (/(?=^.{8,}$)/).test(passw);
}
function validCountry(country) {
    if (country.length < 3 | country.length > 50) {
        return false;
    }
    return true;
}

