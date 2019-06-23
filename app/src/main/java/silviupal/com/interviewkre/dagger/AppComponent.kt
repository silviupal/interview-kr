package silviupal.com.interviewkre.dagger

import dagger.Component
import silviupal.com.interviewkre.presentation.activity.details.DetailsActivity
import silviupal.com.interviewkre.presentation.activity.list.MainActivity
import javax.inject.Singleton

/**
 * Created by Silviu Pal on 6/22/2019.
 */
@Singleton
@Component(modules = [NetworkModule::class,
    RepositoryModule::class,
    UseCaseModule::class,
    ViewModelModule::class])
interface AppComponent {
    fun poke(mainActivity: MainActivity)
    fun poke(detailsActivity: DetailsActivity)
}
