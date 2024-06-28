package br.com.fiap.ComposerProject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.ComposerProject.ui.theme.ComposerProjectTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposerProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Box (modifier = Modifier
        .fillMaxWidth().background(Color(0xFFF0F0F0))) {
        MyComponent()
    }
}

@Composable
fun MyComponent() {

    val age: MutableState<Int> = remember {
        mutableIntStateOf(0)
    }

    val text = remember {
        mutableStateOf("anos")
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight().fillMaxWidth().padding(32.dp)
    ) {
        Text(
            text = "Qual a sua idade?",
            color = Color(0xFF06B8FF),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
//            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Pressione os botões para informar sua idade",
            fontSize = 12.sp,
            color = Color(0xFF1C1C1C),
//            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "${age.value} ${text.value}",
            fontSize = 48.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1C1C1C)
        )
        Spacer(modifier = Modifier.height(25.dp))
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if (age.value > 0) {
                        age.value--
                        if (age.value > 1  || age.value == 0) {
                            text.value = "anos"
                        } else {
                            text.value = "ano"
                        }
                    }
                },
                modifier =  Modifier.size(84.dp),
                shape = AbsoluteRoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF06B8FF)
                )
            ) {
                Text(text = "-")
            }
            Spacer(modifier = Modifier.width(25.dp))
            Button(
                onClick = {
                    age.value++
                    if (age.value > 1  || age.value == 0) {
                        text.value = "anos"
                    } else {
                        text.value = "ano"
                    }
                },
                modifier =  Modifier.size(84.dp),
                shape = AbsoluteRoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF06B8FF)
                )
            ) {
                Text(text = "+")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyComponentPreview() {
    MyComponent()
}