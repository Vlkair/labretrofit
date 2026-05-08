package com.example.retrofitandroid
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.retrofitandroid.ui.theme.RetrofitAndroidTheme
import com.example.retrofitandroid.ui.theme.Typography

@Composable
fun DeviceItemView(device: Device){
    Row{
        Icon(imageVector = Icons.Default.Phone,
            contentDescription = null)
        Column{
            Text(device.name)
            if (device.data?.color != null){
                Text(device.data.color,
                style = Typography.bodySmall)
            }
            if (device.data?.capacity != null){
                Text(device.data.capacity,
                    style = Typography.bodySmall)
            }
            if (device.data?.price != null){
                Text("$${device.data.price}",
                    style = Typography.bodySmall)
            }
            if (device.data?.year != null){
                Text("$${device.data.year}",
                    style = Typography.bodySmall)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DeviceItemPreview(){
    RetrofitAndroidTheme {
        DeviceItemView(Device(id=2, name="iphone 15",
            Specs(color="blanco", capacity = "256 GB",150.99,2026),
        null))
    }
}