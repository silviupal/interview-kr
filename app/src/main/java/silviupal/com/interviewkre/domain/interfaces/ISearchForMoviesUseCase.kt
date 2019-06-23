package silviupal.com.interviewkre.domain.interfaces

import io.reactivex.Single
import silviupal.com.interviewkre.data.models.SearchResult

/**
 * Created by Silviu Pal on 6/22/2019.
 */
interface ISearchForMoviesUseCase {
    fun getSearchResult(query: String): Single<SearchResult>
}