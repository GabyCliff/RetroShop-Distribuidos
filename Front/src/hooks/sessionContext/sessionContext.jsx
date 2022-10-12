import { ConstructionOutlined } from "@mui/icons-material";
import { createContext, useState } from "react";
import { useNavigate } from "react-router-dom";
import { fetchWithoutToken } from "../../helpers/fetch";
import { getSession, removeSession, saveSession } from "../../utils/session";

export const SessionContext = createContext();

const SessionProvider = ({children}) => {
    const [error, setError] = useState(null);
    const [userSession, setUserSession] = useState(null);

    let navigate = useNavigate();

    const isLogged = () => getSession().data !== null ? true : false; 
    const getRole = (role) => role && userSession?.rol === role;
    const getUserId = () => getSession().data.id;
    const getUserName = () => getSession().data.username;
    const getWalletValues = () => { 
        const { data } = getSession();
        return { wallet : data.wallet, walletId : data.walletId}
    }

    const validateWallet = async ( user ) => {
        const userValidateWallet = await fetchWithoutToken(
            'vw/findByIdUser', 
            { idUser : parseInt(user.id) }, 
            'POST'
        );
        user.wallet = userValidateWallet.description.message === 'Ok';
        if(!user.wallet){
            const { virtualWalletResponse } = await fetchWithoutToken(
                'vw/create', 
                { balance : 0, idUser : parseInt(user.id) }, 
                'POST'
            );
            user.wallet = true;
            user.walletId = virtualWalletResponse.id;
        }else{
            user.walletId = userValidateWallet.virtualWalletResponse.id
        }     
        
        return user;
    }
    const loginUser = async (username,password) => {
        try{
            const loginData = await fetchWithoutToken(
                'findCurrentUser', 
                { username, password }, 
                'POST'
            );

            const { user } = loginData;
            
            if(user['id'] !== undefined){
                const userValidated = await validateWallet(user);
                saveSession(null, userValidated);
                setUserSession(userValidated);
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
        navigate('/');
    }
    const sessionValues = {
		loginUser,
        logoutUser,
        error,
        isLogged,
        getRole,
        getUserId,
        getWalletValues,
        getUserName
	};

    return (
        <SessionContext.Provider value={sessionValues}>
            {children}
        </SessionContext.Provider>
      );
}

export default SessionProvider;