package silviupal.com.interviewkre.domain.interfaces

import io.reactivex.Single
import silviupal.com.interviewkre.data.models.MovieDetails

/**
 * Created by Silviu Pal on 6/22/2019.
 */
interface IGetMovieDetailsUseCase {
    fun getMovieDetails(movieId: String): Single<MovieDetails>
}