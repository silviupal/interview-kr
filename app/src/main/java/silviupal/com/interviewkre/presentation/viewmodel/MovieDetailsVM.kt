package silviupal.com.interviewkre.presentation.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import silviupal.com.interviewkre.domain.interfaces.IGetMovieDetailsUseCase
import silviupal.com.interviewkre.presentation.activity.details.DefaultState
import silviupal.com.interviewkre.presentation.activity.details.ErrorState
import silviupal.com.interviewkre.presentation.activity.details.MovieDetailsState
import javax.inject.Inject

/**
 * Created by Silviu Pal on 6/21/2019.
 */
class MovieDetailsVM @Inject constructor(private val useCase: IGetMovieDetailsUseCase) : ViewModel() {
    private val stateLiveData = MutableLiveData<MovieDetailsState>()

    @SuppressLint("CheckResult")
    fun getMovieDetails(movieId: String): MutableLiveData<MovieDetailsState> {
        useCase.getMovieDetails(movieId)
            .subscribe({ movieDetails ->
                stateLiveData.value = DefaultState(movieDetails)
            }, { errorThrowable ->
                stateLiveData.value = ErrorState(errorThrowable.message ?: "Error")
            })
        return stateLiveData
    }
}