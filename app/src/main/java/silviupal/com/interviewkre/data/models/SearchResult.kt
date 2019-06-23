package silviupal.com.interviewkre.data.models

import com.google.gson.annotations.SerializedName
import silviupal.com.interviewkre.common.MyConstants

/**
 * Created by Silviu Pal on 6/22/2019.
 */
data class SearchResult(
    @SerializedName("Search")
    val moviesList: List<Movie>,
    val totalResults: Int,
    @SerializedName("Response")
    val isSearchSuccessful: MyConstants.BooleanAsString,
    @SerializedName("Error")
    val errorMessage: String
)