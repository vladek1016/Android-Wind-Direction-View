package com.radiance.customview.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import com.radiance.winddirections.WindDirections
import com.radiance.winddirections.petal.Petal

import com.radiance.customview.R
import com.radiance.customview.windDirections.petal.toBottomStyle
import com.radiance.customview.windDirections.petal.toTopStyle
import kotlinx.android.synthetic.main.fragment_petal_1_8.*

class Petal_1_8 : Fragment() {
    private var topStyle = Petal.TopStyle.Sector
    private var bottomStyle = Petal.BottomStyle.Sector
    private var bottomRadius = 0
    private var margin = 0
    private var border = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_petal_1_8, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        topStyleTitle.text = "${getString(R.string.topstyle)} (${styleString(topStyle)})"
        topStyleSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                topStyle = progress.toTopStyle()
                setStyle()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        bottomStyleTitle.text = "${getString(R.string.bottomstyle)} (${styleString(bottomStyle)})"
        bottomStyleSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                bottomStyle = progress.toBottomStyle()
                setStyle()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        bottomRadiusTitle.text = "${getString(R.string.bottomradius)} (${bottomRadius})"
        bottomRadiusSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                bottomRadius = progress
                setStyle()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        marginTitle.text = "${getString(R.string.margin)} (${margin})"
        marginSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                margin = progress
                setStyle()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        borderTitle.text = "${getString(R.string.border)} (${border})"
        borderSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                border = progress
                setStyle()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        setStyle()

        val windPower = WindDirections.WindPower().apply {
            N = 7234
            NE = 6214
            E = 762
            SE = 3456
            S = 3462
            SW = 7756
            W = 2222
            NW = 222
        }

        eight.windPower = windPower

        eight.setOnClickListener {
            eight.startAnimation()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setStyle() {
        topStyleTitle.text = "${getString(R.string.topstyle)} (${styleString(topStyle)})"
        bottomStyleTitle.text = "${getString(R.string.bottomstyle)} (${styleString(bottomStyle)})"
        bottomRadiusTitle.text = "${getString(R.string.bottomradius)} (${bottomRadius})"
        marginTitle.text = "${getString(R.string.margin)} (${margin})"
        borderTitle.text = "${getString(R.string.border)} (${border})"

        eight.petalMargin = margin.toFloat()
        eight.petalBorder = border.toFloat()
        eight.topStyle = topStyle
        eight.bottomStyle = bottomStyle
        eight.bottomRadius = bottomRadius.toFloat()
    }

    private fun styleString(style: Petal.TopStyle): String {
        return when(style) {
            Petal.TopStyle.Flat -> getString(R.string.flat)
            Petal.TopStyle.Sector -> getString(R.string.sector)
        }
    }

    private fun styleString(style: Petal.BottomStyle): String {
        return when(style) {
            Petal.BottomStyle.Flat -> getString(R.string.flat)
            Petal.BottomStyle.Sector -> getString(R.string.sector)
        }
    }
}
