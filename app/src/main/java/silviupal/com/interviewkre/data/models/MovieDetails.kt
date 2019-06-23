package silviupal.com.interviewkre.data.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Silviu Pal on 6/21/2019.
 */
data class MovieDetails(
    @SerializedName("Title")
    val title: String = "",
    @SerializedName("Director")
    var director: String = "",
    @SerializedName("Writer")
    var writer: String = "",
    @SerializedName("Released")
    var releaseDate: String = "",
    @SerializedName("Actors")
    val actors: String = "",
    @SerializedName("Genre")
    val genre: String = "",
    @SerializedName("Plot")
    var plot: String = "",
    @SerializedName("Awards")
    var awards: String = "",
    @SerializedName("Poster")
    var posterUrl: String = ""
)