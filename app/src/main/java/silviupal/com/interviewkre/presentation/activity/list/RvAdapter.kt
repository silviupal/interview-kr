package silviupal.com.interviewkre.presentation.activity.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item.view.*
import silviupal.com.interviewkre.R
import silviupal.com.interviewkre.data.models.Movie

/**
 * Created by Silviu Pal on 6/22/2019.
 */
class RvAdapter(private val clickListener: (Movie) -> Unit) : RecyclerView.Adapter<ViewHolder>() {
    private var list: List<Movie> = emptyList()
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        this.context = parent.context
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position], clickListener, context)
    }

    fun setData(list: List<Movie>) {
        this.list = list
        notifyDataSetChanged()
    }

    fun getData(): List<Movie> = list
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(movie: Movie,
        clickListener: (Movie) -> Unit,
        context: Context) {
        itemView.movieTitle.text = movie.title
        itemView.movieYear.text = context.getString(R.string.movie_year_format, movie.year)
        itemView.movieType.text = movie.type
        Picasso.get().load(movie.posterUrl).into(itemView.moviePosterView)
        itemView.setOnClickListener { clickListener(movie) }
    }
}