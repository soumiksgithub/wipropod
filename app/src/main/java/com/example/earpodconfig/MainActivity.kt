package com.example.earpodconfig

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bluetooth
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.TouchApp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                EarPodConfigurationScreen()
            }
        }
    }
}

@Composable
fun EarPodConfigurationScreen() {
    var ancEnabled by remember { mutableStateOf(true) }
    var transparencyEnabled by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF4F5F7)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Text("My Ear Pods", fontSize = 30.sp, fontWeight = FontWeight.Bold)
            Text("Connected", fontSize = 14.sp, color = Color(0xFF2E8B57))
            Spacer(modifier = Modifier.height(18.dp))

            EarPodDeviceCard()

            Spacer(modifier = Modifier.height(22.dp))
            Text("Noise Control", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(10.dp))

            SettingToggle(
                title = "Active Noise Cancellation",
                description = "Reduce background and environmental noise",
                checked = ancEnabled,
                onCheckedChange = {
                    ancEnabled = it
                    if (it) transparencyEnabled = false
                }
            )

            Spacer(modifier = Modifier.height(10.dp))

            SettingToggle(
                title = "Transparency",
                description = "Hear sounds from your surroundings",
                checked = transparencyEnabled,
                onCheckedChange = {
                    transparencyEnabled = it
                    if (it) ancEnabled = false
                }
            )

            Spacer(modifier = Modifier.height(24.dp))
            Text("Device Settings", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(10.dp))

            SettingsItem(Icons.Default.LocationOn, "Find My Device", "Locate your Ear Pods")
            Spacer(modifier = Modifier.height(10.dp))
            SettingsItem(Icons.Default.TouchApp, "Touch Gestures", "Configure tap and press actions")
            Spacer(modifier = Modifier.height(10.dp))
            SettingsItem(Icons.Default.Bluetooth, "Bluetooth Settings", "Connected")
        }
    }
}

@Composable
fun EarPodDeviceCard() {
    Card(
        modifier = Modifier.fillMaxWidth().height(220.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(35.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                EarBud()
                EarBud()
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text("Nova Pods Pro", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                BatteryInfo("L", "88%")
                BatteryInfo("R", "91%")
                BatteryInfo("Case", "75%")
            }
        }
    }
}

@Composable
fun EarBud() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(55.dp)
                .clip(CircleShape)
                .background(Color(0xFFE3E5E8))
        )
        Box(
            modifier = Modifier
                .width(17.dp)
                .height(65.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFE3E5E8))
        )
    }
}

@Composable
fun BatteryInfo(name: String, battery: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text("$name ", fontSize = 13.sp, color = Color.Gray)
        Text(battery, fontSize = 13.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun SettingToggle(
    title: String,
    description: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(title, fontSize = 16.sp, fontWeight = FontWeight.Medium)
                Spacer(modifier = Modifier.height(4.dp))
                Text(description, fontSize = 12.sp, color = Color.Gray)
            }
            Switch(checked = checked, onCheckedChange = onCheckedChange)
        }
    }
}

@Composable
fun SettingsItem(icon: ImageVector, title: String, subtitle: String) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable { },
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFF0F1F4)),
                contentAlignment = Alignment.Center
            ) {
                Icon(icon, contentDescription = title, tint = Color.DarkGray)
            }
            Spacer(modifier = Modifier.width(15.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(title, fontSize = 16.sp, fontWeight = FontWeight.Medium)
                Text(subtitle, fontSize = 12.sp, color = Color.Gray)
            }
            Icon(Icons.Default.ChevronRight, contentDescription = null, tint = Color.Gray)
        }
    }
}
