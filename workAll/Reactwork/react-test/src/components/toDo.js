import {useState} from "react";

function ToDo() {
    const [toDo, setToDo] = useState("");
    const [toDos, setTosDo] = useState([]);

    const onChange = (e) => setToDo(e.target.value)
    const onClick = (e) => {
        e.preventDefault();
        if (toDo === "") {
            return;
        }
        setTosDo((currentArray) => {
            const newArray = [...currentArray, toDo];
            console.log(newArray); // 새로운 배열을 콘솔에 출력
            return newArray;
        });
        setToDo("");
    };


    const deleteToDo = (item) => {
        const newArray = [...toDos];
        setTosDo(newArray.filter((element) => element !== item))
    }

    return (
        <div>
            <h1>To Dos ( {toDos.length} )</h1>
            <form onSubmit={onClick}>
                <input onChange={onChange}
                       value={toDo}
                       type="text"
                       placeholder='Write your to do...'/>
                <button>Add To Do</button>
                <hr/>
                {toDos.map((item) => (
                    <li onClick={() => deleteToDo(item)}>{item}</li>
                ))}

            </form>
        </div>
    );
}

export default ToDo;