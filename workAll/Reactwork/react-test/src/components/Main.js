import {OneApp} from "./OneApp";
import TwoApp from "./TwoApp";
import ThreeApp from "./ThreeApp";
import FourApp from "./FourApp";
import React, {useState} from "react";
import Day0708 from "./Day0708";
import {Form} from "react-bootstrap";

const main = ()=> {
    // eslint-disable-next-line react-hooks/rules-of-hooks
    const [show, setShow] = useState(0);

    return (
        <div>
            <Form.Select style={{width: "50%"}} aria-label="Default select example"
                         onChange={(e) => setShow(e.target.selectedIndex)}
                         className="my-4">
                <option>oneApp</option>
                <option>twoApp</option>
                <option>ThreeApp</option>
                <option>FourApp</option>
                <option>DayClass</option>
            </Form.Select>
            {show === 0 ? <OneApp/> : null}
            {show === 1 ? <TwoApp/> : null}
            {show === 2 ? <ThreeApp/> : null}
            {show === 3 ? <FourApp/> : null}
            {show === 4 ? <Day0708/> : null}



        </div>
    )
}

export default main;