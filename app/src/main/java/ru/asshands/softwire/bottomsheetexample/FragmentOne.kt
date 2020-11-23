package ru.asshands.softwire.bottomsheetexample

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import ru.asshands.softwire.bottomsheetexample.databinding.FragmentOneBinding

class FragmentOne : Fragment(R.layout.fragment_one) {

    private var _bind: FragmentOneBinding? = null
    private val bind get() = _bind!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _bind = FragmentOneBinding.bind(view)

        // Kotlin synthetic-style (deprecated):
        // val bottomSheet = view.fragment_one_bottom_sheet_id

        // findViewById-style:
        // val bottomSheet = view.findViewById<View>(R.id.fragment_one_bottom_sheet_id)

        val bottomSheet = bind.fragmentOneBottomSheetId.bottomSheetRootElement
        val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)

        // настройка максимальной высоты в пикселях, НЕ dp (!!!)
        // bottomSheetBehavior.peekHeight = 340
        // настройка возможности скрыть элемент при свайпе вниз
        bottomSheetBehavior.isHideable = true

        // настройка колбэков при изменениях
        val bottomSheetCallback = object : BottomSheetBehavior.BottomSheetCallback() {

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                // You may do something for new state
/*                when (newState) {
                    BottomSheetBehavior.STATE_EXPANDED ->
                        Toast.makeText(requireContext(), "STATE_EXPANDED", Toast.LENGTH_SHORT)
                            .show()
                    BottomSheetBehavior.STATE_COLLAPSED -> Toast.makeText(
                        requireContext(),
                        "STATE_COLLAPSED",
                        Toast.LENGTH_SHORT
                    ).show()
                    else -> Toast.makeText(requireContext(), "onStateChanged", Toast.LENGTH_SHORT)
                        .show()
                }*/
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                // Do something for slide offset
                //Toast.makeText(requireContext(),"onSlide", Toast.LENGTH_SHORT).show()
            }
        }
        // добавляем созданный callback
        bottomSheetBehavior.addBottomSheetCallback(bottomSheetCallback)


        // настройка состояний нижнего экрана
        // BottomSheetBehavior.STATE_COLLAPSED// свернуть
        // BottomSheetBehavior.STATE_EXPANDED // растянутое
        // BottomSheetBehavior.STATE_HIDDEN   // скрытое isHideable = true (!!!)
        bind.fragmentOneContentId.fragmentOneContentShow.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }

        bind.fragmentOneContentId.fragmentOneContentCollapse.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        bind.fragmentOneContentId.fragmentOneContentHide.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        }


        bind.fragmentOneContentId.fragmentOneContentAddCount.setOnClickListener {
            val countValue = bind.fragmentOneBottomSheetId.fragmentOneBottomSheetCount.text.toString()
                .toIntOrNull()
            bind.fragmentOneBottomSheetId.fragmentOneBottomSheetCount.text =
                countValue?.inc().toString()
        }
    }

    override fun onDestroyView() {
        _bind = null
        super.onDestroyView()
    }
}