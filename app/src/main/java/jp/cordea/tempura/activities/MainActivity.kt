package jp.cordea.tempura.activities

import android.arch.lifecycle.*
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import dagger.android.AndroidInjection
import jp.cordea.tempura.R
import jp.cordea.tempura.databinding.ActivityMainBinding
import jp.cordea.tempura.viewmodels.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity(), LifecycleRegistryOwner {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel by lazy {
        ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
    }

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    private val lifecycle = LifecycleRegistry(this)

    override fun getLifecycle(): LifecycleRegistry {
        return lifecycle
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding.vm = viewModel

        setSupportActionBar(binding.toolbar)

        subscribe()
    }

    private fun subscribe() {
        viewModel.getText().observe(this, Observer<String> {
            it?.let {
                binding.content.textView.text = it
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
