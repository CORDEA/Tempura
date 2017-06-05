package jp.cordea.tempura.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.cordea.tempura.activities.MainActivity

/**
 * Created by Yoshihiro Tanaka on 2017/06/05.
 */
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}