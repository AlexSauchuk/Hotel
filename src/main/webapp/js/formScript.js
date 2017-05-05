
function setEventListener() {
    ($('#idAcceptUpdatePersonalInfo')[0]).addEventListener("click", updatePersonalInfo);
}

function loadTemplate() {
    var request = new XMLHttpRequest();
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

function getSexValue(sex){
    var sexValue = "";
    $(sex).each(function() {
        $("input",this).each(function(){
            if(this.checked){
                sexValue =  this.value;
            }
        });
    });
    return sexValue;
}

function updatePersonalInfo() {
    var name = document.getElementById("name");
    var surname = document.getElementById("surname");
    var mobilePhone = document.getElementById("mobilePhone");
    var login = document.getElementById("login");
    var passportNumber = document.getElementById("passportNumber");
    var sex = document.getElementById("sex");
    var pass = document.getElementById("pass");

    if(!validName(name.value) || !validName(surname.value) || !validPhone(mobilePhone.value) ||
        !validLogin(login.value) || !validPassport(passportNumber.value) || !validSex(getSexValue(sex))
        || !validPassword(pass.value))
    {
        alert ("Данные заполнены неверно!");
        return  false;
    }

    $.ajax({
        type: 'POST',
        url: '/servlet?action=UPDATE' + getUpdateDataUser(),
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

function sendUserDataRegistration(login,email,pass,phone,sex,name,surname,passport) {
    $.ajax({
        type: 'POST',
        url: '/servlet?action=REGISTRATION',
        data:{"login":login,"email":email,"password":pass,"phone":phone,"sex":sex,"name":name,"surname":surname,"passport":passport},
        success: function(data) {
            currentUser.name = data["name"];
            currentUser.id = parseInt(data["id"]);
            loadTemplate();
            setNewValueEntryDiv();
        }
    });
}
function sendUserDataLogin(email,pass){
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

function getSexValueCB(sex) {
    if(sex.checked)
        return "M";
    return "W";
}

function validateUpForm (){
    var name = document.getElementById("name");
    var surname = document.getElementById("surname");
    var passport = document.getElementById("passport");

    var login = document.getElementById("login");
    var email = document.getElementById("emailUp");
    var password = document.getElementById("passUp");
    var phone = document.getElementById("phone");
    var sex = document.getElementById("sex");

    if (!validEmail(email.value) || !validPassword(password.value) || !validLogin(login.value)
        || !validPhone(phone.value) || !validSex(getSexValueCB(sex)) || !validName(name.value)
        || !validName(surname.value) || !validPassport(passport.value)){
        alert ("Данные заполнены неверно!");
        return false;
    }
    alert ("Данные успешно отправлены на сервер!");
    sendUserDataRegistration(login.value,email.value,password.value,phone.value,getSexValueCB(sex),name.value,surname.value,passport.value);
}

function validateInForm (){
    var email = document.getElementById("emailIn");
    var passw = document.getElementById("passIn");
    console.log(email.value);
    console.log(passw.value);

    if (!validEmail(email.value) || !validPassword(passw.value)){
        alert ("Данные заполнены неверно!");
        return  false;
    }
    alert ("Данные успешно отправлены на сервер!");
    sendUserDataLogin(email.value,passw.value);
}

function validSex(sex) {
    return(/(?=^[mwMWмжМЖ]$)/).test(sex);
}
function validPassport(passport) {
    return (/(?=[a-zA-Z]{2}[0-9]{7})/).test(passport);
}
function validPhone(phone) {
    return (/(?=^\d[\d\(\)\ -]{4,14}\d$)/).test(phone);
}
function validName(name) {
    return (/(?=^[A-ZЁА-Я][a-zёа-я-_\.]{3,20}$)/).test(name);
}
function validLogin	(login) { //с ограничением 2-20 символов, которыми могут быть буквы и цифры, первый символ обязательно буква
    return (/^[a-zA-z]{1}[a-zA-Z1-9]{3,20}$/).test(login);
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

