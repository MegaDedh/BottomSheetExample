package ru.asshands.softwire.bottomsheetexample

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import ru.asshands.softwire.bottomsheetexample.databinding.FragmentOneBinding

class FragmentOne : Fragment(R.layout.fragment_one) {

    private var _bind: FragmentOneBinding? = null
    private val bind get() = _bind!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _bind = FragmentOneBinding.bind(view)


        bind.fragmentOneShow.setOnClickListener {
            Toast.makeText(context,"Click Show",Toast.LENGTH_SHORT).show()
        }

        bind.fragmentOneCollapse.setOnClickListener {
            Toast.makeText(context,"Click Collapse",Toast.LENGTH_SHORT).show()
        }

        bind.fragmentOneHide.setOnClickListener {
            Toast.makeText(context,"Click Hide",Toast.LENGTH_SHORT).show()
        }


        bind.fragmentOneAddCount.setOnClickListener {
            Toast.makeText(context,"AddCount",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        _bind = null
        super.onDestroyView()
    }
}