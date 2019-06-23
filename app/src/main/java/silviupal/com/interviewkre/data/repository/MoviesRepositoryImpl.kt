package silviupal.com.interviewkre.data.repository

import io.reactivex.Single
import silviupal.com.interviewkre.data.models.MovieDetails
import silviupal.com.interviewkre.data.models.SearchResult
import silviupal.com.interviewkre.data.networking.Api
import silviupal.com.interviewkre.domain.repository.IMoviesRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Silviu Pal on 6/21/2019.
 */
@Singleton
class MoviesRepositoryImpl @Inject constructor(private val remoteSource: Api) : IMoviesRepository {
    override fun getMoviesBySearch(query: String): Single<SearchResult> = remoteSource.getMovies(query)

    override fun getMovieDetails(movieId: String): Single<MovieDetails> = remoteSource.getMovieDetails(movieId)
}