package com.example.componentesestado

import android.R
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentesestado.ui.theme.ComponentesEstadoTheme
import com.example.componentesestado.ui.theme.Hunin

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ComponentesEstadoTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

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
    var textFieldValue by remember {
        // Cria uma variavel mutável iniciando vazia
        mutableStateOf("")
    }

    val quantidade = remember {
        // Cria uma variavel mutável iniciando vazia
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var kotlin by remember {
        mutableStateOf(false)
    }

    var jetComposable by remember {
        mutableStateOf(false)
    }

    var android by remember {
        mutableStateOf(false)
    }

    var sistemaSelecionado by remember {
        mutableStateOf(0)
    }

    var corFundo by remember {
        mutableStateOf(Color(239, 247,209))
    }

    // Organiza os componentes um abaixo do outro
    Column(
        modifier = modifier
            // Ocupa todo o espaço disponivel
            .fillMaxSize()
            // Define a cor de fundo da tela
            .background(corFundo)
    )
    {

        // Exibe um texto na tela
        Text(
            text = "Aulas Android",
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
        ) // Texto "Aulas Android"

        // Exibe o subtitulo na tela
        Text(
            text = "Com Jetpack Compose",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(66, 133, 244),
            fontFamily = Hunin,
            modifier = Modifier
                // Centraliza o componente horizontalmente
                .align(Alignment.CenterHorizontally)
        ) // Texto "Com Jetpack Compose"

        // Cria um campo para entrada de texto
        TextField(
            // Pega o valor atual da variavel que é mutável
            value = textFieldValue,

            // Atualiza o valor quando o usuario digita, sendo mutável
            onValueChange = { novoValor ->

                // Atribui o novo valor digitado
                textFieldValue = novoValor

                // Ve o log em tempo real da mensagem que chega
                Log.i("teste", novoValor)
            },

            modifier = Modifier.fillMaxWidth(),

            // Define as configuracoes do teclado
            keyboardOptions = KeyboardOptions(
                // Deixando a primeira linha em Maiusculo
                capitalization = KeyboardCapitalization.Words
            ),

            // Texto informativo que fica em cima do que digita
            label = {
                Text("Nome e sobrenome")
            },

            // Adiciona o icone no comeco
            leadingIcon = {

                // Configuracoes do icone
                Icon(
                    // Import da imagem do icone
                    imageVector = Icons.Default.Person,

                    // Descricao
                    contentDescription = "Icone pessoa",

                    // Coloracao do icone
                    tint = Color(66, 133, 244)
                )
            },

            // Adiciona o icone no final
            trailingIcon = {

                // Configuracoes do icone
                Icon(
                    // Import da imagem do icone
                    imageVector = Icons.Default.Person,

                    // Descricao
                    contentDescription = "Icone pessoa",

                    // Coloracao do icone
                    tint = Color(66, 133, 244)
                )
            }
        ) // Nome e sobrenome

        // Cria um campo para informar a quantidade
        TextField(
            value = quantidade.value,

            onValueChange = { novoValor ->
                quantidade.value = novoValor
            },

            // Define as configuracoes do teclado
            keyboardOptions = KeyboardOptions(
                // Define o teclado numerico
                keyboardType = KeyboardType.Number
            ),

            // Texto exibido enquanto o campo estiver vazio
            placeholder = {
                Text(text = "Qual sua dúvida?")
            },

            // Define as cores do campo de texto
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Blue,
                unfocusedTextColor = Color.Red,
                unfocusedPlaceholderColor = Color.Magenta
            )
        ) // Quantidade

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        // Campo de email
        OutlinedTextField(
            // Pega o valor atual do campo de email
            value = email,

            // Funcao callback que passa um único parametro
            onValueChange = { email = it },

            singleLine = true,

            modifier = Modifier
                .fillMaxWidth(),

            label = {
                Text(text = "Email")
            },

            placeholder = {
                Text(text = "Digite seu email...")
            },

            // Muda o formato do campo da caixa de texto
            shape = RoundedCornerShape(
                topStart = 32.dp,
                bottomEnd = 32.dp
            ),

            colors = OutlinedTextFieldDefaults.colors(
                // Muda a cor da borda
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Red
            )
        ) // Email

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = kotlin,
                onCheckedChange = { kotlin = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red
                )
            )
            Text("kotlin")

        }// Kotlin checkbox

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = jetComposable,
                onCheckedChange = { jetComposable = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red
                )
            )
            Text("Jetpack composable")
        }//Jetpack composable checkbox

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = android,
                onCheckedChange = { android = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red
                )
            )
            Text("Android")
        }//Android checkbox

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = sistemaSelecionado == 0,
                onClick = { sistemaSelecionado = 0 }
            )
            Text("MacOS")
        }//MacOS RadioButton

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = sistemaSelecionado == 1,
                onClick = { sistemaSelecionado = 1 }
            )
            Text("Windows")
        }//Windows RadioButton

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = sistemaSelecionado == 2,
                onClick = { sistemaSelecionado = 2}
            )
            Text("Linux")
        }//Linux RadioButton

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {
                    corFundo = Color.Red
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.Green
                ),
                border = BorderStroke(4.dp, Color.Red),
                shape = RoundedCornerShape(topEnd = 12.dp, bottomStart = 12.dp)
            ) {
                Row( verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.Star,
                        contentDescription = "Estrela")
                    Text( text = "Clique aqui")

                }//Texto "Cique aqui"

            }//Botao

            OutlinedButton(
                onClick = {
                    corFundo = Color.Cyan
                }
            ) {
                Text(text = "Clique aqui")
            }

        }//Coluna horizontal do botao

    } // Coluna

} // Tela principal