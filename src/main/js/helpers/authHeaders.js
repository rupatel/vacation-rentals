import {AUTHORIZATION} from '../constants/AppConstants';

export function authHeaders(){
    let user = JSON.parse(localStorage.getItem('user'));
    if(user && user.token){
        return {AUTHORIZATION:  BEARER + user.token.val};
    } else {
        return {};
    }
}