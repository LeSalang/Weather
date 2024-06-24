package com.lesa.weather

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.lesa.ui.MainScreen
import com.lesa.uikit.WeatherTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // private lateinit var fusedLocationClient: FusedLocationProviderClient

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherTheme {
                // val context = LocalContext.current
/*

                // Remembering the state for internet connection and location permission
                val hasInternetConnection by remember { mutableStateOf(checkInternetConnection(context)) }
                var locationPermissionGranted by remember { mutableStateOf(false) }

                val locationPermissionRequest = rememberLauncherForActivityResult(
                    ActivityResultContracts.RequestMultiplePermissions()
                ) { permissions ->
                    when {
                        permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                            // Precise location access granted.
                            locationPermissionGranted = true
                        }
                        permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                            // Only approximate location access granted.
                            locationPermissionGranted = true
                        }
                        else -> {
                            // No location access granted.
                            locationPermissionGranted = false
                            Toast.makeText(context, "Location permission denied", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

                LaunchedEffect(Unit) {
                    if (!locationPermissionGranted) {
                        locationPermissionRequest.launch(
                            arrayOf(
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION
                            )
                        )
                    }
                }
*/

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = WeatherTheme.colorScheme.surface
                ) { innerPadding ->
                    //  if (hasInternetConnection) {
                    MainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                /*    } else {
                        Toast.makeText(context, "No internet connection", Toast.LENGTH_LONG).show()
                    }*/
                }
            }
        }
    }
   /* private fun checkInternetConnection(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
        return when {
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }*/
}
