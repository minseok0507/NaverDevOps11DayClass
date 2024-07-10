import React, {useState} from 'react';
import Button from "react-bootstrap/Button";
import {Form} from "react-bootstrap";

function Day0708() {
    const [show, setShow] = useState(false);
    const [display, setDisplay] = useState("block");
    const [title, setTitle] = React.useState("리엑트 어쩌고");
    const [color, setColor] = React.useState("red");
    const [border, setBorder] = React.useState("solid");
    const [height, setHeight] = React.useState(150);

    function photoSmall() {
        setHeight(height - 10);
    }


    function photoBig() {
        setHeight(height + 10);
    }

    function photoShow() {
        setShow(!show)
        if (show) {
            setDisplay("block")
        } else {
            setDisplay("none")
        }
    }

    return (
        <div>
            <h1>오늘의 문제</h1>
            <hr/>
            <div>
                <input type="checkbox" id="photo" checked={show} onChange={photoShow}/> <label htmlFor="photo">사진
                숨김</label>
                <Button variant="outline-danger" onClick={photoSmall}>점점작게</Button>
                <Button variant="outline-danger" onClick={photoBig}>점점크게</Button>
            </div>
            <div>
                <Form.Control
                    placeholder="title"
                    type="text"
                    onChange={(e) => {
                        setTitle(e.target.value);
                    }}
                    value={title}
                    className="my-4"
                />
                <div style={{
                    display: display
                }}
                >
                    <div style={{
                        width: height + 'px',
                        height: height + 'px',
                        backgroundColor: color,
                        border: '10px ' + border + ' black', float: "right",
                    }}>
                        사진
                    </div>

                    <Form.Select style={{width: "50%"}} aria-label="Default select example"
                                 onChange={(e) => setColor(e.target.value)}
                                 className="my-4">
                        <option>red</option>
                        <option>blue</option>
                        <option>green</option>
                        <option>그뭐냐</option>
                    </Form.Select>

                    <Form.Select style={{width: "50%"}} aria-label="Default select example"
                                 onChange={(e) => setBorder(e.target.value)}
                                 className="my-4">
                        <option>solid</option>
                        <option>dotted</option>
                        <option>dashed</option>
                        <option>double</option>
                    </Form.Select>
                    <div style={{clear:"both"}}></div>
                </div>
            </div>
            <div style={{width: "100%", padding: "10px", background: "lightpink"}}>{title}</div>
        </div>

    );
}

export default Day0708;