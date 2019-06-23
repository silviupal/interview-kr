package silviupal.com.interviewkre.presentation.activity.list

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import silviupal.com.interviewkre.MyApp
import silviupal.com.interviewkre.R
import silviupal.com.interviewkre.common.MyConstants
import silviupal.com.interviewkre.dagger.newViewModelFactory.MyViewModelFactory
import silviupal.com.interviewkre.data.models.Movie
import silviupal.com.interviewkre.presentation.activity.details.DetailsActivity
import silviupal.com.interviewkre.presentation.viewmodel.MoviesListVM
import javax.inject.Inject

/**
 * Created by Silviu Pal on 6/21/2019.
 */
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModeFactory: MyViewModelFactory

    private var adapter: RvAdapter? = null
    private var mHandler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyApp.appComponent.poke(this)
        adapter = RvAdapter(this::openDetailsPage)
        recyclerView.adapter = adapter
    }

    private fun openDetailsPage(movie: Movie) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(MyConstants.KEY_MOVIE_ID, movie.id)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        val searchItem: MenuItem = menu.findItem(R.id.search)
        val searchView: SearchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(query: String?): Boolean {
                search(query)
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                search(query)
                return false
            }
        })

        return true
    }

    private fun search(query: String?) {
        query?.let { queryText ->
            if (queryText.length > 2) {
                getDataWithDelay(queryText)
            } else {
                showDefaultState()
            }
        }
    }

    private fun getDataWithDelay(queryText: String) {
        if (mHandler == null) {
            mHandler = Handler()
        }
        mHandler?.removeCallbacksAndMessages(null)
        mHandler?.postDelayed({
            getSearchResults(queryText)
        }, 500)
    }

    private fun getSearchResults(query: String) {
        val model = ViewModelProviders.of(this, this.viewModeFactory).get(MoviesListVM::class.java)
        model.getSearchResult(query).observe(this, Observer<MoviesListState> { state ->
            when (state) {
                is DefaultState -> {
                    recyclerView.visibility = View.VISIBLE
                    informationView.visibility = View.INVISIBLE
                    adapter?.setData(state.data)
                }
                is ErrorState -> {
                    recyclerView.visibility = View.INVISIBLE
                    informationView.visibility = View.VISIBLE
                    informationView.text = state.errorMessage
                }
            }
        })
    }

    private fun showDefaultState() {
        adapter?.let {
            if (it.getData().isNotEmpty()) {
                it.setData(emptyList())
            }
        }
        recyclerView.visibility = View.INVISIBLE
        informationView.visibility = View.VISIBLE
        informationView.text = getString(R.string.default_list_information)
    }

    override fun onDestroy() {
        super.onDestroy()
        mHandler?.removeCallbacksAndMessages(null)
        mHandler = null
    }
}