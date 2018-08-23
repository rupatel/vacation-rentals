import React from 'react';
import {BrowserRouter as Router, Route} from 'react-router-dom'
import RegisterComponent from "../components/RegisterComponent";
import HomeComponent from "./HomeComponent";
import LoginComponent from "../components/LoginComponent";
class App extends React.Component{
    render() {
        return (
            <Router>
                <div className="container-fluid">
                    <LoginComponent/>
                    <Route path="/home" component={HomeComponent}/>
                    <Route path="/sign-up" component={RegisterComponent}/>
                </div>
            </Router>
        );
    }
}
export default App;

