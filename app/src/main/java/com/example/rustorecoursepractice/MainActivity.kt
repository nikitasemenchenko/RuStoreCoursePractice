package com.example.rustorecoursepractice

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rustorecoursepractice.ui.theme.RuStoreCoursePracticeTheme
import androidx.core.net.toUri

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RuStoreCoursePracticeTheme {
                Main(
                    onClick1 = { text ->
                        Intent(applicationContext, SecondActivity::class.java).apply {
                            putExtra("text", text)
                            startActivity(this)
                        }
                    },
                    onClick2 = {text ->
                        var isValid = text.isNotBlank()
                        for(i in text){
                            if(!i.isDigit()) isValid = false
                        }
                        if(isValid ){
                            val num = "tel:$text"
                            Intent(Intent.ACTION_DIAL).apply {
                                data = num.toUri()
                                startActivity(this)
                            }
                        }
                    },
                    onClick3 = { text ->
                        val sendIntent = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(Intent.EXTRA_TEXT, text)
                        }
                        val shareIntent = Intent.createChooser(sendIntent, null)
                        if(text.isNotBlank()){
                            startActivity(shareIntent)
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun Main(onClick1: (String) -> Unit,
         onClick2: (String) -> Unit,
         onClick3: (String) -> Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        var text by remember { mutableStateOf("") }
        TextField(
            value = text,
            onValueChange = {text = it}
        )
        Button(
            onClick = { onClick1(text) }
        ) {
            Text( "Открыть вторую Activity")
        }
        Button(
            onClick = { onClick2(text) }
        ) {
            Text( "Позвонить другу")
        }
        Button(
            onClick = { onClick3(text) }
        ) {
            Text("Поделиться текстом")
        }
    }
}