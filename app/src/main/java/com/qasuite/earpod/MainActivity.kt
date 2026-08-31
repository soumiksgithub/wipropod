package com.qasuite.earpod

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.qasuite.earpod.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    enum class NoiseMode(val label: String) {
        ANC("ANC"),
        TRANSPARENCY("Transparency")
    }

    private var currentMode: NoiseMode = NoiseMode.ANC

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateMode(NoiseMode.ANC)

        binding.switchAnc.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) updateMode(NoiseMode.ANC)
        }
        binding.switchTransparency.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) updateMode(NoiseMode.TRANSPARENCY)
        }

        binding.btnFindDevice.setOnClickListener { dummy("Find My Device") }
        binding.btnTouchGestures.setOnClickListener { dummy("Touch Gestures") }
        binding.btnEqualizer.setOnClickListener { dummy("Equalizer") }
        binding.btnSpatialAudio.setOnClickListener { dummy("Spatial Audio") }

        binding.btnSettings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }

    private fun updateMode(mode: NoiseMode) {
        currentMode = mode
        binding.currentMode.text = getString(R.string.current_mode_format, mode.label)
        binding.currentMode.contentDescription = "Current noise control mode ${mode.label}"

        binding.switchAnc.isChecked = mode == NoiseMode.ANC
        binding.switchTransparency.isChecked = mode == NoiseMode.TRANSPARENCY
    }

    private fun dummy(feature: String) {
        Toast.makeText(this, "$feature is a demo feature", Toast.LENGTH_SHORT).show()
    }
}
