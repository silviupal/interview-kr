package silviupal.com.interviewkre.dagger.newViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

/**
 * Created by Silviu Pal on 6/23/2019.
 */
@Singleton
class MyViewModelFactory @Inject constructor(private val viewModelsMap: MutableMap<Class<out ViewModel>,
    Provider<ViewModel>>) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = viewModelsMap[modelClass]?.get() as T
}