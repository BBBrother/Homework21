package com.example.homework21

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ColorFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.color_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.colorView).background = arguments?.getString(KEY_COLOR)
            ?.let { getColor(it) }
    }

    fun getColor(color: String): Drawable {
        return when (color){
            "Чёрный" -> resources.getDrawable(R.color.black)
            "Белый" -> resources.getDrawable(R.color.white)
            "Красный" -> resources.getDrawable(R.color.red)
            "Зелёный" -> resources.getDrawable(R.color.green)
            "Жёлтый" -> resources.getDrawable(R.color.yellow)
            "Синий" -> resources.getDrawable(R.color.blue)
            else -> resources.getDrawable(R.color.white)
        }
    }

    companion object {
        private const val KEY_COLOR = "color"

        fun newInstance(color: String): ColorFragment{
            val fragment = ColorFragment()
            val args = Bundle()
            args.putString(KEY_COLOR, color)
            fragment.arguments = args
            return fragment
        }
    }

}