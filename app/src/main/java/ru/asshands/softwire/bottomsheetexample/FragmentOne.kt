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

        val llBottomSheet = bind.fragmentOneBottomSheet.bottomSheetRootElement
        val bottomSheetBehavior = BottomSheetBehavior.from(llBottomSheet)

        // настройка максимальной высоты в пикселях, НЕ dp (!!!)
        // bottomSheetBehavior.peekHeight = 340
        // настройка возможности скрыть элемент при свайпе вниз
        bottomSheetBehavior.isHideable = true

        // настройка колбэков при изменениях
        val bottomSheetCallback = object : BottomSheetBehavior.BottomSheetCallback() {

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                // Do something for new state
                when (newState) {
                    BottomSheetBehavior.STATE_EXPANDED -> Toast.makeText(
                        requireContext(),
                        "STATE_EXPANDED",
                        Toast.LENGTH_SHORT
                    ).show()
                    BottomSheetBehavior.STATE_COLLAPSED -> Toast.makeText(
                        requireContext(),
                        "STATE_COLLAPSED",
                        Toast.LENGTH_SHORT
                    ).show()
                    else -> Toast.makeText(requireContext(), "onStateChanged", Toast.LENGTH_SHORT)
                        .show()
                }

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
        bind.fragmentOneContent.fragmentOneContentShow.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }

        bind.fragmentOneContent.fragmentOneContentCollapse.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        bind.fragmentOneContent.fragmentOneContentHide.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        }


        bind.fragmentOneContent.fragmentOneContentAddCount.setOnClickListener {
            val countValue = bind.fragmentOneBottomSheet.fragmentOneBottomSheetCount.text.toString()
                .toIntOrNull()
            bind.fragmentOneBottomSheet.fragmentOneBottomSheetCount.text =
                countValue?.inc().toString()
        }
    }

    override fun onDestroyView() {
        _bind = null
        super.onDestroyView()
    }
}