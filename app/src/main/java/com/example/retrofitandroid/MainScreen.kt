package com.example.retrofitandroid

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.retrofitandroid.ui.theme.Typography

@Composable
fun MainView(modifier: Modifier, devices: List<Device>){
    Column() {
        Text(text = "Dispositivos",
            modifier = modifier.fillMaxWidth(),
            style = Typography.displayMedium,
            textAlign = TextAlign.Center
        )

        LazyColumn() {
            items(devices.size) { index ->
                DeviceItemView(device = devices[index])
            }
        }
    }
}