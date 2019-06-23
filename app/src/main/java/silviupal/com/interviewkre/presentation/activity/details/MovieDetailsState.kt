package silviupal.com.interviewkre.presentation.activity.details

import silviupal.com.interviewkre.data.models.MovieDetails

/**
 * Created by Silviu Pal on 6/22/2019.
 */
sealed class MovieDetailsState

data class DefaultState(val data: MovieDetails) : MovieDetailsState()
data class ErrorState(val errorMessage: String) : MovieDetailsState()