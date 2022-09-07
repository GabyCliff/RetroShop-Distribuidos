export function checkSession(){
    return localStorage.getItem('session-token') != null;
}

export function saveSession(token, data){
    localStorage.setItem("session-token", token);
    localStorage.setItem("session-data", data);
}

export function getSession(){
    return {
        token: localStorage.getItem("session-token"),
        data: localStorage.getItem("session-data")
    }
}

export function removeSession(){
    localStorage.removeItem('session-token');
    localStorage.removeItem('session-data');
}