import { useState } from "react";
import Button from "react-bootstrap/Button";

const ThreeApp = () => {
    const [num, setNum] = useState(0);

    const numstyle = {
        fontSize: '14px',
        fontWeight: 'bold',
        color: 'green',
        textShadow: '1px 2px 5px #000'
    };

    return (
        <>
            <h1>Three App</h1>
            <div style={numstyle}>num : {num}</div>
            <Button onClick={() => setNum(setNum => setNum + 1)}>더하기</Button>
            <Button onClick={() => setNum(setNum => setNum - 1)}>빼기</Button>
        </>
    );
}


export default ThreeApp;

