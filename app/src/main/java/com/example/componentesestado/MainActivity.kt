package com.example.componentesestado

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentesestado.ui.theme.ComponentesEstadoTheme
import com.example.componentesestado.ui.theme.Hunin
import kotlin.math.log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentesEstadoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BasicComponentsScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BasicComponentsScreen(modifier: Modifier = Modifier) {
    // Guarda o valor digitado no campo de texto
    val textFieldValue = remember {
        // Cria uma variavel mutável iniciando vazia
        mutableStateOf("")
    }

    // Organiza os componentes um abaixo do outro
    Column(modifier = modifier
        // Ocupa todo o espaço disponivel
        .fillMaxSize()
        // Define a cor de fundo da tela
        .background(Color(239, 247, 207))
    ){
        // Exibe um texto na tela
        Text(text = "Aulas Android",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3DDC84),
            fontFamily = FontFamily.Serif,
            modifier = Modifier
                .background(Color.Magenta)
                .fillMaxWidth(),
            // Alinha o texto no final
            textAlign = TextAlign.End,
            // Define o espacamento entre as letras
            letterSpacing = 4.sp
        )
        // Exibe o subtitulo na tela
        Text(text = "Com Jetpack Compose",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(66, 133, 244),
            fontFamily = Hunin,
            modifier = Modifier
                // Centraliza o componente horizontalmente
                .align(Alignment.CenterHorizontally)
        )

        // Cria um campo para entrada de texto
        TextField(

            //Pega o valor atual da variavel que é mutável
            value = textFieldValue.value,
            // Atualiza o valor quando o usuario digita, sendo mutável
            onValueChange =  { novoValor ->
                // Atribui o novo valor digitado
                 textFieldValue.value = novoValor
                //Ve o log em tempo real da mensagem que chega
                Log.i("teste", novoValor)
                             },
            modifier = Modifier.fillMaxWidth(),
            // Define as configuracoes do teclado
            keyboardOptions = KeyboardOptions(
                // Define o teclado numerico
                keyboardType = KeyboardType.Email
            )
        )

        AndroidEnemy(
            color =    Color.Yellow,
            // Define o tamanho do inimigo
            modifier = Modifier.size(100.dp)
        )
        AndroidEnemy(
            modifier = Modifier.size(100.dp)
                .size(100.dp)
                .padding(4.dp),
            color = Color.Red
        )
    }
}
// Cria um componente reutilizavel
@Composable
fun AndroidEnemy(
    color: Color,
    // Recebe as configuracoes do componente
    modifier: Modifier = Modifier
) {
    // Exibe uma imagem na tela
    Image(
        modifier = modifier,
        // Carrega a imagem dos recursos
        painter = painterResource(R.drawable.ic_launcher_foreground),
        // Aplica a cor recebida na imagem
        colorFilter = ColorFilter.tint(color = color),
        // Define a descricao da imagem
        contentDescription = "Android Enemy"
    )
}