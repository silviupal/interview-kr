package silviupal.com.interviewkre.domain

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import silviupal.com.interviewkre.data.models.SearchResult
import silviupal.com.interviewkre.domain.interfaces.ISearchForMoviesUseCase
import silviupal.com.interviewkre.domain.repository.IMoviesRepository
import javax.inject.Inject

/**
 * Created by Silviu Pal on 6/21/2019.
 */
class SearchForMoviesUseCase @Inject constructor(private val moviesRepo: IMoviesRepository) : ISearchForMoviesUseCase {

    override fun getSearchResult(query: String): Single<SearchResult> =
        moviesRepo.getMoviesBySearch(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}