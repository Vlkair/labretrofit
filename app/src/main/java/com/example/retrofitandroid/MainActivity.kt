package com.example.retrofitandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.retrofitandroid.ui.theme.RetrofitAndroidTheme
import com.example.retrofitandroid.ui.theme.Typography
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RetrofitAndroidTheme {

                var devices by remember{mutableStateOf(listOf<Device>())}

                getDevices {result ->
                    devices = result
                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainView(modifier = Modifier.padding(innerPadding),
                    devices)
                }
            }
        }
    }
}

private fun getDevices(onResult:(List<Device>)-> Unit){
    val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service = retrofit.create(DeviceService::class.java)
    lifecycleScope.launch{
        val devices = service.getAllDevices()
        onResult(devices)
    }
}
//si llega la ia con binding no vale rehacer
@Composable
fun MainView(modifier: Modifier,devices:List<Device>){
    Text(text="Dispositivos",
        modifier = Modifier.fillMaxWidth(),
        style= Typography.labelMedium,
        textAlign = TextAlign.Center
    )
    LazyColumn() {
        items(devices.size) { index ->
            DeviceItemView(device = devices[index])
        }
    }
}
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier.padding(2.dp)
//    )
//}

@Preview(showBackground = true)
@Composable
fun MainViewPreview() {
    RetrofitAndroidTheme {
        //MainView( modifier = Modifier.padding(5.dp))
    }
}
//el composable ver parte de la interfaz