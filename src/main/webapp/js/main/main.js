
var currentUser = null;


function setRoleAttributes(roleObj) {
    for(var fieldRole in roleObj)
        currentUser['role'][fieldRole] = roleObj[fieldRole];
}

$( document ).ready(function() {
    if(sessionStorage.length!=0) {
        document.getElementById('idAdminRef').style.display = 'block';
        document.getElementById('idDocsRef').style.display = 'block';
        currentUser = {
            'role':{}
        };
        for (var fieldUser in sessionStorage) {
            if (fieldUser == 'role')
                setRoleAttributes(JSON.parse(sessionStorage['role']));
            else
                currentUser[fieldUser] = sessionStorage[fieldUser];
        }
        loadTemplate('/templates/pages/signin/personalInfo.html');
        setNewValueEntryDiv(currentUser.name);
        generatePermissionsUser();
    }else{
        document.getElementById('idAdminRef').style.display = 'none';
        document.getElementById('idDocsRef').style.display = 'none';
    }
});

function generatePermissionsUser() {
    var objRole = currentUser['role'];
    var stringPermissions ='';

    for(var permission in objRole)
        if(permission!='id') {
            stringPermissions += objRole[permission];
        }
}