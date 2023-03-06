package com.example.bottomsheet

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottomsheet.databinding.ActivityMainBinding
import com.example.bottomsheet.databinding.BottomSheetRecyclerViewBinding
import com.google.android.material.R.style
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val bottomSheetView by lazy { binding.bottomSheet }
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<View>

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetView.bottomSheet)

        bottomSheetView.bottomSheetRecyclerView.apply {
            adapter = NumberAdapter()
            layoutManager = LinearLayoutManager(context)
        }

        bottomSheetView.bottomSheetRecyclerView.setOnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    bottomSheetBehavior.isDraggable = false
                }
                MotionEvent.ACTION_UP -> {
                    bottomSheetBehavior.isDraggable = true
                }
            }
            false
        }

    }
}