package com.example.esports

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val composeView = ComposeView(this)

        composeView.setContent {
            PantallaEquipo()
        }

        setContentView(composeView)
    }
}

@Composable
fun PantallaEquipo() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .statusBarsPadding()
            .padding(16.dp)
    ) {

        Text(
            text = "TEAM TITANS",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 15.dp, bottom = 20.dp),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        )

        Jugador(
            "AlexPro",
            "Atacante",
            21,
            87,
            R.drawable.jugador1
        )

        Separador()

        Jugador(
            "ShadowX",
            "Defensor",
            24,
            91,
            R.drawable.jugador2
        )

        Separador()

        Jugador(
            "MartaGG",
            "Soporte",
            20,
            84,
            R.drawable.jugador3
        )

        Separador()

        Jugador(
            "Destroyer",
            "Atacante",
            23,
            89,
            R.drawable.jugador4
        )
    }
}

@Composable
fun Jugador(
    nombre: String,
    rol: String,
    edad: Int,
    nivel: Int,
    @DrawableRes imagen: Int
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier.size(80.dp)
        ) {

            Image(
                painter = painterResource(imagen),
                contentDescription = nombre,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(
            modifier = Modifier.width(15.dp)
        )

        Column {

            Text(
                text = nombre,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue
            )

            Text(
                text = "Rol: $rol",
                fontSize = 16.sp,
                color = Color.Black
            )

            Text(
                text = "Edad: $edad años",
                fontSize = 16.sp,
                color = Color.Black
            )

            Text(
                text = "Nivel: $nivel",
                fontSize = 16.sp,
                color = Color.Black
            )
        }
    }
}

@Composable
fun Separador() {

    HorizontalDivider(
        modifier = Modifier.padding(horizontal = 10.dp),
        thickness = 1.dp,
        color = Color.Gray
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewJugador() {

    Jugador(
        "AlexPro",
        "Atacante",
        21,
        87,
        R.drawable.jugador1
    )
}