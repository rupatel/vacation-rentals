let _singleton = Symbol;
import {RENTAL_SERVICE_URL,AUTHORIZATION,TOKEN_EXPIRY} from '../constants/AppConstants';
const LOGIN_URL = RENTAL_SERVICE_URL + '/login';
class LoginService{
    constructor(singleToken){
        if(_singleton != _singleton)
            throw Error("instantiate directly");
    }
    static get instance(){
        if(!this[_singleton])
            this[_singleton] = new LoginService(_singleton);
        return this[_singleton];
    }

    login(credentials){
        return fetch(LOGIN_URL,{
            body: JSON.stringify(credentials),
            method: 'POST'
        }).then(res => res.json().then(user => {
            user.token = {
                AUTHORIZATION:res.headers.get(AUTHORIZATION),
                TOKEN_EXPIRY:res.headers.get(TOKEN_EXPIRY)
            }
            return user;
        }));
    }
}
export default LoginService;