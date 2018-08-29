import React from 'react';
export default class ListingCard extends React.Component{
    render(){
        return(
            <div className="card">
                <img className="card-img-left"
                     src="https://picsum.photos/300/200" alt="Card"/>
                <div className="card-body">
                    <h5 className="card-title">Card title</h5>
                    <p className="card-text">This is a longer card with supporting text below as a natural lead-in
                        to additional content. This content is a little bit longer.</p>
                    <p className="card-text">
                        <small className="text-muted">Last updated 3 mins ago</small>
                    </p>
                </div>
            </div>
        )
    }
}