import React from 'react';
import {Router, Route, Switch} from 'react-router-dom'
import RegisterComponent from "../components/RegisterComponent";
import HomeComponent from "./HomeComponent";
import LoginComponent from "../components/LoginComponent";
import {history} from '../helpers/history';

class App extends React.Component{
    render() {
        return (
            <Router history={history}>
                <Switch>
                    <Route path="/home" component={HomeComponent}/>
                    <Route path="/signUp" component={RegisterComponent}/>
                    <Route path="/" component={LoginComponent}/>
                </Switch>
            </Router>
        );
    }
}
export default App;

