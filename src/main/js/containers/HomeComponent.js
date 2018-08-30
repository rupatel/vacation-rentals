import React from 'react';
import ListingCard from '../components/ListingCard';
class HomeComponent extends React.Component{

    render(){
        return (
            <div className="container-fluid">
                <h1>Home</h1>
                <ListingCard/>
            </div>
        );
    }
}

export default HomeComponent;