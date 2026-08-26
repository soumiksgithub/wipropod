# EarPodConfig

A simple single-screen Android demo application for ear pod configuration.

## Features
- Active Noise Cancellation (ANC) toggle
- Transparency toggle
- ANC and Transparency are mutually exclusive
- Ear pod visual
- Left/right/case battery indicators
- Find My Device
- Touch Gestures
- Bluetooth Settings

## Tech Stack
- Kotlin
- Jetpack Compose
- Material 3

## Run
1. Open this folder in Android Studio.
2. Allow Gradle sync to complete.
3. Select an Android emulator or connected Android device.
4. Click **Run**.

Recommended minimum SDK: Android 8.0 / API 26.

## Build APK
From the project root:

Windows:
`gradlew.bat assembleDebug`

macOS/Linux:
`./gradlew assembleDebug`

The debug APK will be generated under:
`app/build/outputs/apk/debug/app-debug.apk`
