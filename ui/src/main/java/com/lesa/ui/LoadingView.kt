package com.lesa.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun LoadingView(
    modifier: Modifier = Modifier,
) {
    val weatherLoadingLottieComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(
            R.raw.sun_loading
        )
    )

    val loadingProgress by animateLottieCompositionAsState(
        weatherLoadingLottieComposition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true
    )

    LottieAnimation(
        composition = weatherLoadingLottieComposition,
        progress = loadingProgress,
        modifier = modifier.fillMaxSize()
    )
}
