package ru.asshands.softwire.bottomsheetexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.asshands.softwire.bottomsheetexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.button.setOnClickListener {
            it.visibility = View.INVISIBLE
            supportFragmentManager
                .beginTransaction()
                .add(R.id.main_frame, FragmentOne())
                .commit()
        }
    }
}