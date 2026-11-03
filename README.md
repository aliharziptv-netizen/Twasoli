# Tawasoli Android

This repository is prepared to build the Android APK using GitHub Actions.

## Build
1. Add the Android project source at the repository root (the folder containing `gradlew` and `settings.gradle`).
2. Open **Actions**.
3. Run **Build Android APK**.
4. Download the artifact named **Tawasoli-debug-apk** from the completed workflow.

The workflow expects a Gradle Android project with a Gradle wrapper and a debug APK output.
