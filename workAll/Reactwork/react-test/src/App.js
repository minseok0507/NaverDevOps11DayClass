import {Route, Routes} from 'react-router-dom';
import Detail from "./components/Detail";
import Home from "./routes/Home";

function App() {
    return (
        <Routes>
            <Route path="/" element={<Home/>}/>
            <Route path="/movie/:id" element={<Detail/>}/>
        </Routes>
    );
}

export default App;
