import "./my-style.css"



import Button from 'react-bootstrap/Button';
import React from "react";
import {Alert} from "react-bootstrap";
const {Component} = require("react");

class OneApp extends Component{
    render() {
        return(
            <>
                <h1 className="alert-primary">OneApp</h1>
                <Button variant="primary">Primary</Button>
                <div className="photo"></div>
                <Alert variant="warning">warning</Alert>
            </>
        )
    }
}

export {OneApp}