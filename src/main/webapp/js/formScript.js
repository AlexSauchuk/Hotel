
function validateForm (){
    var login = document.getElementById("login");
    var email = document.getElementById("email");
    var passw = document.getElementById("password");

    if (!validLogin(login.value) | !validEmail(email.value) | !validPassword(passw.value)){
        alert ("Данные заполнены неверно!");
        return  false;
    }
    alert ("Данные успешно отправлены на сервер!");
    return  true;
}

function validLogin	(login) { //с ограничением 2-20 символов, которыми могут быть буквы и цифры, первый символ обязательно буква
    return (/(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/).test(login);
}
function validEmail(email) {
    return (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/).test(email);
}
function validPassword(passw) {//Строчные и прописные латинские буквы, цифры, спецсимволы. Минимум 8 символов):
    return (/(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/).test(passw);
}
function validCountry(country) {
    if (country.length < 3 | country.length > 50) {
        return false;
    }
    return true;
}