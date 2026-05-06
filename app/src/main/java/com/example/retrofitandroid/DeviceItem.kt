package com.example.retrofitandroid
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.retrofitandroid.ui.theme.RetrofitAndroidTheme

@Composable
fun DeviceItemView(device: Device){
    Row(){
        Icon(painterResource(id = R.drawable.ic_launcher_foreground),
        Column() {

            Text(device.name)
            Text(device.data?.color?:"-"
                style = Typography.bodySmall)
            Text(device.data?.capacity?:"-"
                style = Typography.bodySmall)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DeviceItemPreview(){
    RetrofitAndroidTheme() {
        DeviceItemView(Device(id=2, name="iphone 15",
            Specs(color="blanco", capacity = "256 GB")))
    }
}