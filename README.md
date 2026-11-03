# Tawasoli Android Project

Android source project based on the supplied archive.

## Build
GitHub Actions builds a debug APK on pushes to `main` or `master` and when manually started.

The project uses Android Gradle Plugin 8.2.2 and Gradle 8.2. CI downloads Gradle 8.2 directly because the original archive did not include wrapper scripts/JAR.

## APK output
`app/build/outputs/apk/debug/app-debug.apk`

No Firebase credentials or private secrets are included.
