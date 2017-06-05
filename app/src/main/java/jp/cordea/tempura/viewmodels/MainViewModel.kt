package jp.cordea.tempura.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.view.View
import jp.cordea.tempura.repositories.MainRepository
import javax.inject.Inject

/**
 * Created by Yoshihiro Tanaka on 2017/06/05.
 */
class MainViewModel @Inject constructor(repository: MainRepository) : ViewModel() {

    private val text = MutableLiveData<String>()

    fun getText(): LiveData<String> {
        return text
    }

    val onClick = View.OnClickListener {
        repository.inc()
        text.value = repository.countString
    }

    init {
        text.value = repository.countString
    }
}
