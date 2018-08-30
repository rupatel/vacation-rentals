import React from 'react';
export default class ListingCard extends React.Component{
    render(){
        return(
            <ul className="list-unstyled">
                <div className="container-fluid m-0 m-b-5 m-lg-1 p-0">
                    <div className="row">
                        <img className="col-md-4 col-lg-3 m-0 p-0" src="https://picsum.photos/300/200" alt="Generic placeholder image"/>
                        <div className="col-md-8 col-lg-9 card m-0 p-0">
                            <div className="container-fluid ml-3">
                                <h5 className="mt-0">Exclusive apartments in the heart of the Zillertal -
                                    Appartement Edelweiss für 3 bis 8 Personen in Hippach </h5>
                                <ul className="mt-3 mb-5 list-inline">
                                    <li className="list-inline-item">Apartment</li>
                                    <li className="list-inline-item">2BR</li>
                                    <li className="list-inline-item">2BA</li>
                                    <li className="list-inline-item">Sleeps 8</li>
                                    <li className="list-inline-item">850 Sq.Ft.</li>
                                </ul>
                            </div>
                            <div className="card-footer">
                                <h1 className="card-title pricing-card-title">$120 <small className="text-muted">per
                                    night</small>
                                    <span className="fa fa-star checked"></span>
                                    <span className="fa fa-star checked"></span>
                                    <span className="fa fa-star checked"></span>
                                    <span className="fa fa-star"></span>
                                    <span className="fa fa-star"></span>
                                </h1>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="container-fluid m-0 m-b-5 m-lg-1 p-0">
                    <div className="row">
                        <img className="col-md-4 col-lg-3 m-0 p-0" src="https://picsum.photos/300/200" alt="Generic placeholder image"/>
                        <div className="col-md-8 col-lg-9 card m-0 p-0">
                            <div className="container-fluid ml-3">
                                <h5 className="mt-0">Exclusive apartments in the heart of the Zillertal -
                                    Appartement Edelweiss für 3 bis 8 Personen in Hippach </h5>
                                <ul className="mt-3 mb-5 list-inline">
                                    <li className="list-inline-item">Apartment</li>
                                    <li className="list-inline-item">2BR</li>
                                    <li className="list-inline-item">2BA</li>
                                    <li className="list-inline-item">Sleeps 8</li>
                                    <li className="list-inline-item">850 Sq.Ft.</li>
                                </ul>
                            </div>
                            <div className="card-footer">
                                <h1 className="card-title pricing-card-title">$120 <small className="text-muted">per
                                    night</small>
                                </h1>
                            </div>
                        </div>
                    </div>
                </div>
            </ul>
        )
    }
}