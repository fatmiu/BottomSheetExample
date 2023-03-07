package com.example.bottomsheet

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottomsheet.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val bottomSheetView by lazy { binding.bottomSheet }
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<View>

    private val handler by lazy { Handler(Looper.getMainLooper()) }

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

        handler.postDelayed({
            val itemView: View? =
                bottomSheetView.bottomSheetRecyclerView.layoutManager?.findViewByPosition(0)
            val itemHeight: Int = itemView?.height ?: 0
            bottomSheetBehavior.peekHeight = itemHeight + bottomSheetView.viewHandler.height
        }, 100)

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