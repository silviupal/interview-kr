package silviupal.com.interviewkre

import android.app.Application
import silviupal.com.interviewkre.dagger.AppComponent
import silviupal.com.interviewkre.dagger.DaggerAppComponent

/**
 * Created by Silviu Pal on 6/21/2019.
 */
class MyApp : Application() {
    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }

    companion object {
        lateinit var instance: MyApp
        lateinit var appComponent: AppComponent
    }
}