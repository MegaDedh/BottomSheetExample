package ru.asshands.softwire.bottomsheetexample

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.asshands.softwire.bottomsheetexample.databinding.FragmentOneBinding

class FragmentOne : Fragment(R.layout.fragment_one),
    ModalBottomSheetDialogFragment.ItemClickListener {

    private var _bind: FragmentOneBinding? = null
    private val bind get() = _bind!!
    private lateinit var bottomSheet: ModalBottomSheetDialogFragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _bind = FragmentOneBinding.bind(view)

        bind.fragmentOneShow.setOnClickListener {
            bottomSheet = ModalBottomSheetDialogFragment()
            bottomSheet.show(
                childFragmentManager,
                ModalBottomSheetDialogFragment.TAG
            )
        }
    }

    override fun onItemClick(itemText: String) {
        when (itemText) {
            "dismiss" -> bottomSheet.dismissAllowingStateLoss()
            "increment" -> incrementCount()
        }
    }

    private fun incrementCount() {
        val countValue = bind.fragmentOneCount.text.toString()
            .toIntOrNull()
        bind.fragmentOneCount.text =
            countValue?.inc().toString()
    }

    override fun onDestroyView() {
        _bind = null
        super.onDestroyView()
    }
}