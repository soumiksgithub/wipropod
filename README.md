# PulsePods / EarPod Control Demo App

A small Android application built specifically as a QASuite demo target.

## Functional scope to actually validate

The real behavior is intentionally limited to the **Noise Control** selector:

- ANC
- Transparency
- Off

Only one mode can be active at a time. The current mode is displayed under the selector.

## Dummy features

The application exposes additional UI so QASuite can discover features and generate a much broader set of candidate test cases.

Home screen:
- Find My Device
- Touch Gestures
- Equalizer
- Spatial Audio
- Automatic Ear Detection

Settings:
- Ear Pod Firmware Update
- App Software Update
- Manage Permissions
- User Info
- Device Information
- Notifications
- Privacy & Diagnostics
- Help & Support
- About

These are currently demo-only and show a Toast message.

## Automation-friendly locators

Important resource IDs:

- `btn_anc`
- `btn_transparency`
- `btn_off`
- `current_mode`
- `btn_settings`
- `setting_firmware_update`
- `setting_app_update`
- `setting_permissions`
- `setting_user_info`
- `setting_about`

The important controls also have `contentDescription` values so Appium/UIAutomator/vision-assisted automation can locate them using accessibility attributes.

## Android Studio

1. Extract the ZIP.
2. Open the extracted folder in Android Studio.
3. Allow Gradle sync to complete.
4. Use a device/emulator running Android 7.0/API 24 or later.
5. Run the `app` configuration.

## Instrumented tests

Example Espresso tests are included in:

`app/src/androidTest/java/com/qasuite/earpod/NoiseControlInstrumentedTest.kt`

They cover ANC, Transparency, Off and mutual exclusivity.

## Suggested QASuite demo story

Let QASuite inspect the app and generate tests for all visible capabilities, then apply scope/priority/confidence filtering so the execution focuses on the three actual Noise Control modes. This makes the demo useful for showing that AI can distinguish discovered functionality from the intended regression scope.
