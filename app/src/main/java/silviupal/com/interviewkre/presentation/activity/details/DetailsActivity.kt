package silviupal.com.interviewkre.presentation.activity.details

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*
import silviupal.com.interviewkre.MyApp
import silviupal.com.interviewkre.R
import silviupal.com.interviewkre.common.MyConstants
import silviupal.com.interviewkre.dagger.newViewModelFactory.MyViewModelFactory
import silviupal.com.interviewkre.data.models.MovieDetails
import silviupal.com.interviewkre.presentation.viewmodel.MovieDetailsVM
import javax.inject.Inject

/**
 * Created by Silviu Pal on 6/21/2019.
 */
class DetailsActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModeFactory: MyViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        MyApp.appComponent.poke(this)
        intent?.let {
            val movieId = intent.getStringExtra(MyConstants.KEY_MOVIE_ID)
            getMovieDetails(movieId)
        } ?: onBackPressed()
    }

    private fun getMovieDetails(movieId: String?) {
        movieId?.let {
            val model = ViewModelProviders.of(this, this.viewModeFactory).get(MovieDetailsVM::class.java)
            model.getMovieDetails(it).observe(this, Observer<MovieDetailsState> { state ->
                when (state) {
                    is DefaultState -> {
                        infoLayout.visibility = View.VISIBLE
                        errorView.visibility = View.INVISIBLE
                        bindDataToViews(state.data)
                    }
                    is ErrorState -> {
                        infoLayout.visibility = View.INVISIBLE
                        errorView.visibility = View.VISIBLE
                        errorView.text = state.errorMessage
                    }
                }
            })
        }
    }

    private fun bindDataToViews(data: MovieDetails) {
        titleView.text = data.title
        genreView.text = getString(R.string.movie_genre_format, data.genre)
        releaseDateView.text = getString(R.string.movie_release_date_format, data.releaseDate)
        directorView.text = getString(R.string.movie_director_format, data.director)
        writerView.text = data.writer
        actorsView.text = data.actors
        plotView.text = data.plot
        awardsView.text = data.awards

        if (data.posterUrl.isNotEmpty()) {
            Picasso.get().load(data.posterUrl).into(moviePosterView)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}