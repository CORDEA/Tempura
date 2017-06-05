package jp.cordea.tempura.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import jp.cordea.tempura.viewmodels.MainViewModel

/**
 * Created by Yoshihiro Tanaka on 2017/06/05.
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ClassKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}