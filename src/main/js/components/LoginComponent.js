import React from 'react';
import LoginService from '../services/LoginService';
import {history} from '../helpers/history';
import {Link} from "react-router-dom";
class LoginComponent extends React.Component{
    constructor(){
        super();
        this.loginService = LoginService.instance;
        this.passwordChanged = this.passwordChanged.bind(this);
        this.usernameChanged = this.usernameChanged.bind(this);
        this.login = this.login.bind(this);
        this.state = {
            credential:{
                username:'',
                password:'',
                roles:["user"]
            }
        }
    }

    passwordChanged(event){
        let newState = Object.assign({}, this.state);
        newState.credential.password = event.target.value;
        this.setState(newState);
    }

    usernameChanged(event){
        let newState = Object.assign({}, this.state);
        newState.credential.username = event.target.value;
        this.setState(newState);
    }

    login(){
        this.loginService.login(this.state.credential)
            .then(user => {
                localStorage.setItem('user', user);
                history.push("/home")
            });
    }

    render(){
        return (
            <div className="container-fluid">
                <h1>Login</h1>
                <input placeholder="username" className="form-control" onChange={this.usernameChanged}/>
                <input type="password" placeholder="password" className="form-control" onChange={this.passwordChanged}/>
                 <button  onClick={this.login} className="btn btn-primary btn-block" >
                    Login
                 </button>
                <Link to="/sign-up">SignUp</Link>
            </div>
        );
    }
}

export default LoginComponent;