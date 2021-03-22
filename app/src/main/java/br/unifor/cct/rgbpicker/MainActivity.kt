package br.unifor.cct.rgbpicker

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {
    private lateinit var mColorView: View
    private lateinit var mColorPickerR : SeekBar
    private lateinit var mColorPickerG : SeekBar
    private lateinit var mColorPickerB : SeekBar
    private lateinit var mColorDisplay: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mColorView = findViewById(R.id.main_view_colorview)
        mColorPickerR = findViewById(R.id.main_seekBar_R)
        mColorPickerG = findViewById(R.id.main_seekBar_G)
        mColorPickerB = findViewById(R.id.main_seekBar_B)
        mColorDisplay = findViewById(R.id.main_textView_colorDisplay)

        mColorPickerR.setOnSeekBarChangeListener(this)
        mColorPickerG.setOnSeekBarChangeListener(this)
        mColorPickerB.setOnSeekBarChangeListener(this)
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        if(fromUser){
            mColorView.setBackgroundColor(Color.rgb(mColorPickerR.progress, mColorPickerG.progress, mColorPickerB.progress))
            mColorDisplay.text = "#" + String.format("%02X", mColorPickerR.progress) + String.format("%02X", mColorPickerG.progress) + String.format("%02X", mColorPickerB.progress)
        }
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }
}