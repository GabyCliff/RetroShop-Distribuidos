import { createContext, useState } from "react";
import { fetchWithoutToken } from "../../helpers/fetch";
import { getSession, removeSession, saveSession } from "../../utils/session";

export const SessionContext = createContext();

const SessionProvider = ({children}) => {
    const [error, setError] = useState(null);
    const [userSession, setUserSession] = useState(null);
    
    const isLogged = () => getSession().data !== null ? true : false; 
    const getRole = (role) => role && userSession?.rol === role;

    const loginUser = async (username,password) => {
        try{
            const loginData = await fetchWithoutToken(
                'findCurrentUser', 
                { username, password }, 
                'POST'
            );

            const { user } = loginData;
            
            if(user['id'] !== undefined){
                saveSession(null, user);
                setUserSession(user);
                setError(null);
            }
            else{
                setError({ 
                    status : 'error',
                    msg: 'Datos invalidos.' 
                });
            }
        }catch(catchedError){
            setError(`${catchedError}`);
        }
    }

    const logoutUser = () => {
        removeSession();
        setUserSession(null);
    }
    const sessionValues = {
		loginUser,
        logoutUser,
        error,
        isLogged,
        getRole
	};

    return (
        <SessionContext.Provider value={sessionValues}>
            {children}
        </SessionContext.Provider>
      );
}

export default SessionProvider;