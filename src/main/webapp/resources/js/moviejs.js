function navigate(theUrl) {
    document.location.href = theUrl;
}

function serverGetBooleanAnswer(url) {
    var oRequest = new XMLHttpRequest();
    oRequest.open("GET", url, false);
    oRequest.setRequestHeader("User-Agent", navigator.userAgent);
    oRequest.send();
    if (oRequest.status === 200)
        return true;
    else
        return false;
}

function serverRequest(url) {
    var oRequest = new XMLHttpRequest();
    oRequest.open("GET", url, false);
    oRequest.setRequestHeader("User-Agent", navigator.userAgent);
    oRequest.send();
    if (oRequest.status === 200)
        return oRequest.responseText;
    else
        return false;
}

function confirmDeleteUser() {
    return confirm("Are you sure you want to delete this user?");
}


