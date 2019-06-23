package silviupal.com.interviewkre.dagger

import dagger.Module
import dagger.Provides
import silviupal.com.interviewkre.domain.GetMovieDetailsUseCase
import silviupal.com.interviewkre.domain.SearchForMoviesUseCase
import silviupal.com.interviewkre.domain.interfaces.IGetMovieDetailsUseCase
import silviupal.com.interviewkre.domain.interfaces.ISearchForMoviesUseCase
import silviupal.com.interviewkre.domain.repository.IMoviesRepository
import javax.inject.Singleton

/**
 * Created by Silviu Pal on 6/22/2019.
 */
@Module
class UseCaseModule {
    @Provides
    @Singleton
    fun providesSearchForMoviesUseCase(repository: IMoviesRepository):
        ISearchForMoviesUseCase = SearchForMoviesUseCase(repository)

    @Provides
    @Singleton
    fun providesGetMovieDetailsUseCase(repository: IMoviesRepository):
        IGetMovieDetailsUseCase = GetMovieDetailsUseCase(repository)
}