package ru.asshands.softwire.bottomsheetexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.asshands.softwire.bottomsheetexample.databinding.FragmentOneModalBottomSheetBinding

class ModalBottomSheetDialogFragment : BottomSheetDialogFragment() {

    private var _bind: FragmentOneModalBottomSheetBinding? = null
    private val bind get() = _bind!!

    companion object {
        const val TAG = "CustomBottomSheetDialogFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _bind = FragmentOneModalBottomSheetBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        bind.bottomSheetPeek.setOnClickListener {
            Toast.makeText(context, "Bottom Sheet Peek", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        _bind = null
        super.onDestroyView()
    }
}