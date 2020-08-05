package gst.trainingcourse.sampleproject.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import gst.trainingcourse.sampleproject.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val imageCatAdapter = CatImageAdapter()
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initAdapter()
    }

    private fun initAdapter() {
        rcv_list_cat_image.adapter = imageCatAdapter
        lifecycleScope.launch {
            viewModel.getCatImages().collectLatest {
                Log.d("MyLogTag", "class: MainActivity func: onCreate: (19) $it")
                imageCatAdapter.submitData(it)
            }
        }
    }

}