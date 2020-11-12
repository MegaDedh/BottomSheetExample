package ru.asshands.softwire.bottomsheetexample

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.asshands.softwire.bottomsheetexample.databinding.FragmentOneBinding

class FragmentOne : Fragment(R.layout.fragment_one) {

    private var _bind: FragmentOneBinding? = null
    private val bind get() = _bind!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _bind = FragmentOneBinding.bind(view)

        bind.fragmentOneShow.setOnClickListener {
            ModalBottomSheetDialogFragment().show(
                childFragmentManager,
                ModalBottomSheetDialogFragment.TAG
            )
        }
    }

    override fun onDestroyView() {
        _bind = null
        super.onDestroyView()
    }
}