package silviupal.com.interviewkre.data.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Silviu Pal on 6/21/2019.
 */
data class Movie(
    @SerializedName("Title")
    val title: String,
    @SerializedName("Year")
    val year: String,
    @SerializedName("imdbID")
    val id: String,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Poster")
    val posterUrl: String
)