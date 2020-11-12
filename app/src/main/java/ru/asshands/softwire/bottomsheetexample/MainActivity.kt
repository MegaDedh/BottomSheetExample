package ru.asshands.softwire.bottomsheetexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.asshands.softwire.bottomsheetexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        //binding.EXAMPLE_VIEW.text = "NEW_TEXT"

/*        supportFragmentManager
            .beginTransaction()
            .add(R.id.main_fragment_container, Fragment1())
            .commit()*/
    }
}