package silviupal.com.interviewkre.presentation.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import silviupal.com.interviewkre.common.MyConstants
import silviupal.com.interviewkre.domain.interfaces.ISearchForMoviesUseCase
import silviupal.com.interviewkre.presentation.activity.list.DefaultState
import silviupal.com.interviewkre.presentation.activity.list.ErrorState
import silviupal.com.interviewkre.presentation.activity.list.MoviesListState
import javax.inject.Inject

/**
 * Created by Silviu Pal on 6/22/2019.
 */
class MoviesListVM @Inject constructor(private val useCase: ISearchForMoviesUseCase) : ViewModel() {
    private val stateLiveData = MutableLiveData<MoviesListState>()

    init {
        stateLiveData.value = DefaultState(emptyList())
    }

    @SuppressLint("CheckResult")
    fun getSearchResult(query: String): MutableLiveData<MoviesListState> {
        useCase.getSearchResult(query)
            .subscribe({ searchResult ->
                when (searchResult.isSearchSuccessful) {
                    MyConstants.BooleanAsString.TRUE -> {
                        stateLiveData.value = DefaultState(searchResult.moviesList)
                    }
                    MyConstants.BooleanAsString.FALSE -> {
                        stateLiveData.value = ErrorState(searchResult.errorMessage)
                    }
                }
            }, { errorThrowable ->
                stateLiveData.value = ErrorState(errorThrowable.message ?: "Error")
            })
        return stateLiveData
    }
}