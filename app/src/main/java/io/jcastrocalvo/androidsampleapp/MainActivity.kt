package io.jcastrocalvo.androidsampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import io.jcastrocalvo.androidsampleapp.AndroidSampleApp.Companion.coreComponent
import io.jcastrocalvo.androidsampleapp.databinding.ActivityMainBinding
import io.jcastrocalvo.androidsampleapp.di.DaggerMainActivityComponent
import io.jcastrocalvo.androidsampleapp.viewModels.MainActivityViewModel
import io.jcastrocalvo.core.CoreComponent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerMainActivityComponent
            .builder()
            .coreComponent(coreComponent(this))
            .build()
            .inject(this)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        setContentView(binding.root)

        update_text.setOnClickListener {
            viewModel.inputText.postValue(textInputEditText.text.toString())
        }
        toggle_input.setOnClickListener {
            viewModel.toggleShowInput()
        }
    }
}
