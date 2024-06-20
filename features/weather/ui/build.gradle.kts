plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.kapt)
}

android {
    namespace = "com.lesa.ui"
    compileSdk = libs.versions.androidSdk.compile.get().toInt()

    defaultConfig {
        minSdk = libs.versions.androidSdk.min.get().toInt()
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.kotlinCompilerExtensionVersion.get()
    }
}

dependencies {
    // Core
    implementation(libs.androidx.core.ktx)

    // DI
    implementation(libs.hilt.android)
    implementation(libs.javax.inject)
    kapt(libs.hilt.compiler)

    // UI
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.lottie.compose)

    // Modules
    implementation(project(":core:uikit"))
    implementation(project(":features:weather:uilogic"))
}
