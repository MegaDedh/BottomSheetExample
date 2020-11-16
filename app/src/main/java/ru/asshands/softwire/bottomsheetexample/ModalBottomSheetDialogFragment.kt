package ru.asshands.softwire.bottomsheetexample

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.asshands.softwire.bottomsheetexample.databinding.FragmentOneModalBottomSheetBinding

class ModalBottomSheetDialogFragment : BottomSheetDialogFragment() {

    interface ItemClickListener {
        fun onItemClick(itemText: String)
    }

    private var _bind: FragmentOneModalBottomSheetBinding? = null
    private val bind get() = _bind!!
    private var clickListener: ItemClickListener? = null

    companion object {
        const val TAG = "ModalBottomSheetDialogFragment"
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

        bind.dismissInternal.setOnClickListener {
            dismissAllowingStateLoss()
        }

        bind.dismissParent.setOnClickListener {
            if (clickListener == null) clickListener = getClickListener()
            clickListener?.onItemClick("dismiss")
        }

        bind.addCount.setOnClickListener {
            if (clickListener == null) clickListener = getClickListener()
            clickListener?.onItemClick("increment")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bind = null
        clickListener = null
    }

    private fun getClickListener(): ItemClickListener {
        return try {
            //Code smell?
            //All Fragment-to-Fragment communication is done either through a shared
            // ViewModel or through the associated Activity.
            //Two Fragments should never communicate directly.(!)
            //https://developer.android.com/training/basics/fragments/communicating
            requireActivity().supportFragmentManager
                .findFragmentById(R.id.main_fragment) as ItemClickListener
        } catch (e: ClassCastException) {
            throw ClassCastException("Parent fragment must implement ItemClickListener")
        }
    }
}