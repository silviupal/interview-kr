package silviupal.com.interviewkre.domain.repository

import io.reactivex.Single
import silviupal.com.interviewkre.data.models.MovieDetails
import silviupal.com.interviewkre.data.models.SearchResult

/**
 * Created by Silviu Pal on 6/21/2019.
 */
interface IMoviesRepository {
    fun getMoviesBySearch(query: String): Single<SearchResult>

    fun getMovieDetails(movieId: String): Single<MovieDetails>
}