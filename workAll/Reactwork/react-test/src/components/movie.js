import {Link} from "react-router-dom";

function MovieCon(getMovie) {
    const movie = getMovie.movie

    return <div>
        <div key={movie.id} className="my-5">
            <img src={movie.medium_cover_image} alt=""/><br/>
            <Link to={`/movie/${movie.id}`}>{movie.title}</Link>
        </div>
    </div>
}


export default MovieCon;