package jp.cordea.tempura.repositories

import javax.inject.Inject

/**
 * Created by Yoshihiro Tanaka on 2017/06/05.
 */
class MainRepository @Inject constructor() {

    private var count = 0

    val countString: String
        get() {
            return count.toString()
        }

    fun inc() {
        count = count.inc()
    }
}
