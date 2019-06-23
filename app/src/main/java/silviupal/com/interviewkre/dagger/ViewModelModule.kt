package silviupal.com.interviewkre.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import silviupal.com.interviewkre.dagger.newViewModelFactory.MyViewModelFactory
import silviupal.com.interviewkre.dagger.newViewModelFactory.ViewModelKey
import silviupal.com.interviewkre.presentation.viewmodel.MovieDetailsVM
import silviupal.com.interviewkre.presentation.viewmodel.MoviesListVM

/**
 * Created by Silviu Pal on 6/23/2019.
 */
@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: MyViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MoviesListVM::class)
    abstract fun bindMoviesListVM(viewModel: MoviesListVM): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailsVM::class)
    abstract fun bindMovieDetailsVM(viewModel: MovieDetailsVM): ViewModel
}