package com.example.retrofitandroid

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.text.style.TextAlign
import com.example.retrofitandroid.ui.theme.Typography

@Composable
fun MainView(modifier: Modifier){
    Column() {
        Text(text="Dispositivos",
            modifier= Modifier,
            textAlign = TextAlign.Center,
            style= Typography.labelMedium
        )

    }

}