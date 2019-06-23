package silviupal.com.interviewkre.data.networking

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import silviupal.com.interviewkre.data.models.MovieDetails
import silviupal.com.interviewkre.data.models.SearchResult

/**
 * Created by Silviu Pal on 6/21/2019.
 */
interface Api {
    @GET(".")
    fun getMovies(@Query("s") query: String, @Query("y") year: String = "2018"): Single<SearchResult>

    @GET(".")
    fun getMovieDetails(@Query("i") imdbID: String): Single<MovieDetails>
}