const axios = require("axios");

const RESPONSES = {
    "EMPTY_FIELDS": {
        "status":"warning",
        "msg": "Campos incompletos"
    },
    "USER_EMAIL_NOT_VALIDATED": {
        "status":"warning",
        "msg": "Cuenta no validada. Revisa tu casilla de email de spam para validar tu cuenta"
    },
    "USER_NOT_EXISTS": {
        "status":"error",
        "msg": "Email/Password incorrecto"
    },
    "ERROR_CHECKING_USER": {
        "status":"warning",
        "msg": "Error en el servidor. Intenta de nuevo mas tarde"
    }
}

export function loginAPI(email, pwd){
    return new Promise((res, rej) => {
        console.log(process.env.API_URL);
        axios.get(process.env.API_URL).then(resp => {res({resp})});
        /* axios.post(process.env.API_URL+"/findCurrentUser", {
            username: email,
            password: pwd
        })
        .then((resp) => {
            console.log(resp);
            resolve({
                token: resp.headers["auth-token"],
                user: resp.data.user
            })
        })
        .catch((error) => {
            reject(RESPONSES[error.response.data]);
        }); */
    })

}
