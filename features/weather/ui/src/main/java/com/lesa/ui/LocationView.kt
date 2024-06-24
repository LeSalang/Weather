package com.lesa.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.lesa.uikit.WeatherTheme
import com.lesa.uilogic.models.LocationUi

@Composable
fun LocationView(
    locationUi: LocationUi,
    onSearchClick: (Boolean) -> Unit,
    onGetLocationClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        WeatherItem(
            text = stringResource(
                id = R.string.location,
                locationUi.name,
                locationUi.country
            ),
            style = WeatherTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
        )
        WeatherButton(
            onClick = {
                onSearchClick(true)
            },
            imageVector = Icons.Default.Search,
            contentDescription = stringResource(id = R.string.btn_search_location),
        )
        WeatherButton(
            onClick = { onGetLocationClick() },
            imageVector = Icons.Default.LocationOn,
            contentDescription = stringResource(id = R.string.btn_get_location)
        )
    }
}
