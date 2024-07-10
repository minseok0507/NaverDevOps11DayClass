import React, {useState} from 'react';
import {Alert} from "react-bootstrap";
import Button from "react-bootstrap/Button";

function FourApp(props) {
    const [show, setShow] = useState(true);
    return (
        <div>
            <Alert variant="danger">글꼴변경</Alert>
            <Button variant="info" onClick={() => setShow(!show)}>{!show ? "show" : "hide"}</Button>
        </div>
    );
}

export default FourApp;