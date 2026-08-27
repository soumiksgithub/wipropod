package com.qasuite.earpod

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.qasuite.earpod.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dummyActions = mapOf(
            binding.settingFirmwareUpdate to "Ear Pod Firmware Update",
            binding.settingAppUpdate to "App Software Update",
            binding.settingPermissions to "Manage Permissions",
            binding.settingUserInfo to "User Info",
            binding.settingDeviceInfo to "Device Information",
            binding.settingNotifications to "Notifications",
            binding.settingPrivacy to "Privacy & Diagnostics",
            binding.settingHelp to "Help & Support",
            binding.settingAbout to "About",
        )

        dummyActions.forEach { (view, name) ->
            view.setOnClickListener {
                Toast.makeText(this, "$name is a demo-only feature", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnBackHome.setOnClickListener { finish() }
    }
}
