plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.jetbrains.kotlin.serialization)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    api(libs.kotlinx.serialization.json)
    api(libs.okhttp)
    api(libs.okhttp.logging.interceptor) // TODO remove to app module?
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.kotlinx.serialization)
}

//implementation(libs.kotlinx.coroutines.core)
//implementation(libs.androidx.annotation)
//implementation(libs.retrofit.adapters.result)
//kapt(libs.retrofit.responseTypeKeeper)
