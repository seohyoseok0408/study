import { useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { useState } from 'react';

function Detail() {
  const [loading, setLoading] = useState(true);
  const [movie, setMovie] = useState(null);
  const { id } = useParams();
  const getMovie = async () => {
    const json = await (
      await fetch(`https://yts.mx/api/v2/movie_details.json?movie_id=${id}`)
    ).json();
    setMovie(json.data.movie);
    setLoading(false);
    console.log(json);
  };
  useEffect(() => {
    getMovie();

  }, []);
  return (
    <div>
      {loading ? <h1>Loading...</h1> : (
        <div>
          <h1>{movie.title_long}</h1>
          <strong>
            Genre : {movie.genres.map((genre, index) =>
              <span key={index}>{genre}
                {index < (movie.genres.length - 1) ? `${genre}, `
                  : `${genre}`}
              </span>
            )}
          </strong>
          <p>rating : {movie.rating}</p>
          <p>{movie.description_full}</p>
          <img src={movie.medium_cover_image} alt={movie.title} />
        </div>
      )}
    </div>
  );
}
export default Detail;