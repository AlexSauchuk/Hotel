/**
 * Created by SK on 25.04.2017.
 */

var currentUser = null;


$( document ).ready(function() {
    if(sessionStorage.length!=0) {
        currentUser = {};
        for (var fieldUser in sessionStorage) {
            if (typeof sessionStorage[fieldUser] == 'role')
                currentUser['role']['id'] = sessionStorage['role'];
            else
                currentUser[fieldUser] = sessionStorage[fieldUser];
        }
        
        loadTemplate('/templates/pages/signin/personalInfo.html');
        setNewValueEntryDiv(currentUser.name);
    }
});
function Hi() {
    console.log("Hi");
}
