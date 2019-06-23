package silviupal.com.interviewkre.domain

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import silviupal.com.interviewkre.data.models.MovieDetails
import silviupal.com.interviewkre.domain.interfaces.IGetMovieDetailsUseCase
import silviupal.com.interviewkre.domain.repository.IMoviesRepository
import javax.inject.Inject

/**
 * Created by Silviu Pal on 6/21/2019.
 */
class GetMovieDetailsUseCase @Inject constructor(private val moviesRepo: IMoviesRepository) : IGetMovieDetailsUseCase {

    override fun getMovieDetails(movieId: String): Single<MovieDetails> =
        moviesRepo.getMovieDetails(movieId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}