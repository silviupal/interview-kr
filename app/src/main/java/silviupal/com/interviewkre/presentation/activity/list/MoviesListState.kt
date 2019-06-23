package silviupal.com.interviewkre.presentation.activity.list

import silviupal.com.interviewkre.data.models.Movie

/**
 * Created by Silviu Pal on 6/22/2019.
 */
sealed class MoviesListState

data class DefaultState(val data: List<Movie>) : MoviesListState()
data class ErrorState(val errorMessage: String) : MoviesListState()