package com.example.projetolimonada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projetolimonada.ui.theme.ProjetoLimonadaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjetoLimonadaTheme {
                ProjetoLimonada()

            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ProjetoLimonada() {
    var fazerLimonada by remember { mutableStateOf(1) }
    var idImage = 1
    var idString = 1
    var onClickImagem: () -> Unit = {}
    var qtdClick by remember { mutableStateOf(0) }



    when (fazerLimonada) {
        1 -> {
            idImage = R.drawable.limoeiro
            idString = R.string.Limoeiro
            onClickImagem = {
                fazerLimonada = 2
                qtdClick = (2..4).random()
            }
        }

        2 -> {
            idImage = R.drawable.sucodelimao
            idString = R.string.sucodelimao
            onClickImagem = {
                if (qtdClick > 1 && qtdClick < 5)
                    qtdClick--
                else
                    fazerLimonada = 3

            }
        }

        3 -> {
            idImage = R.drawable.limonada
            idString = R.string.limonada
            onClickImagem = {
                fazerLimonada = 4
            }
        }

        4 -> {
            idImage = R.drawable.copovazio
            idString = R.string.copovazio
            onClickImagem = {
                fazerLimonada = 1
            }
        }


    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {


        Image(
            painter = painterResource(idImage),
            contentDescription = null,
            modifier = Modifier.clickable(onClick = onClickImagem)

        )
        Text(
            text = stringResource(idString) + qtdClick,
            fontSize = 15.sp

        )
    }
}

