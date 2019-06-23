package silviupal.com.interviewkre.common

import com.google.gson.annotations.SerializedName

/**
 * Created by Silviu Pal on 6/21/2019.
 */
object MyConstants {
    const val KEY_MOVIE_ID = "KEY_MOVIE_ID"

    enum class BooleanAsString {
        @SerializedName("True")
        TRUE,
        @SerializedName("False")
        FALSE
    }
}