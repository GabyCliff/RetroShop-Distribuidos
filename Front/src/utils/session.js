export function checkSession(){
    return localStorage.getItem('session-token') != null;
}

export function saveSession(token, data){
    localStorage.setItem("session-token", JSON.stringify(token));
    localStorage.setItem("session-data", JSON.stringify(data));
}

export function getSession(){
    return {
        token: JSON.parse(localStorage.getItem("session-token")),
        data: JSON.parse(localStorage.getItem("session-data"))
    }
}

export function removeSession(){
    localStorage.removeItem('session-token');
    localStorage.removeItem('session-data');
}