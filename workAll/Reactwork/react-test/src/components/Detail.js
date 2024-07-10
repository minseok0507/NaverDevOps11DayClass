import {useParams} from "react-router-dom";
import {useEffect, useState} from "react";

function Detail() {
    const params = useParams();

    const [loading, setLoading] = useState(true);
    const [movie, setMovie] = useState([]);
    const getMovies = async () => {
        const response = await fetch("https://yts.mx/api/v2/movie_details.json?movie_id=" + params.id);
        const json = await response.json();
        console.log(json);
        // setMovie(json.data.movies);
        setLoading(false)
    }

    useEffect(() => {
        getMovies();
    }, []);


    return <div>
        {loading ? <h3>LOADING...</h3> : null}

    </div>
}


export default Detail;