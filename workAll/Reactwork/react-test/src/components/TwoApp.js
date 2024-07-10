import {Form, InputGroup, Table} from "react-bootstrap";
import {useState} from "react";


const TwoApp = () => {
    let [name, setName] = useState('민석잉');
    let [age, setAge] = useState(12);
    let [ageStyle, setAgeStyle] = useState("");
    let [addr, setAddr] = useState('일산');
    //
    // const setterName = e => {
    //     setName = e.target.value;
    // };

    return (
        <div>
            <h1>TwoApp</h1>
            <Table striped bordered hover>
                <tbody>
                <tr>
                    <td>이름</td>
                    <td>
                        {name}
                    </td>
                </tr>
                <tr>
                    <td>나이</td>
                    <td style={{background:ageStyle}}>
                        {age}
                    </td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td>
                        {addr}
                    </td>
                </tr>

                </tbody>
            </Table>
            <Form.Control
                placeholder="name"
                onChange={(e) => {
                    setName(e.target.value)
                } }
            />
            <Form.Control
                placeholder="age"
                type="number"
                onChange={(e) => {
                    setAge(e.target.value);
                    if (e.target.value < 20) {
                        setAgeStyle("red")
                    }else if (e.target.value < 50) {
                        setAgeStyle("blue")
                    }else {
                        setAgeStyle("green")
                    }
                }}
            />
            <Form.Control
                placeholder="addr"
                onChange={(e) => setAddr(e.target.value)}
            />
        </div>
    )
}

export default TwoApp;
