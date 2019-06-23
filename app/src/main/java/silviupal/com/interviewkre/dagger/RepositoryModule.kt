package silviupal.com.interviewkre.dagger

import dagger.Module
import dagger.Provides
import silviupal.com.interviewkre.data.networking.Api
import silviupal.com.interviewkre.data.repository.MoviesRepositoryImpl
import silviupal.com.interviewkre.domain.repository.IMoviesRepository
import javax.inject.Singleton

/**
 * Created by Silviu Pal on 6/22/2019.
 */
@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun providesMoviesRepositoryInterface(api: Api): IMoviesRepository = MoviesRepositoryImpl(api)
}