package com.example.provacomponenti.Login

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay

val user : String = "Lorenzo"
@Composable
fun Login(onLoginSuccess: () -> Unit) {
    Scaffold() {
        //TextFields
        var username by remember { mutableStateOf(TextFieldValue("")) }
        var password by remember { mutableStateOf(TextFieldValue("")) }
        var hasError by remember { mutableStateOf(false) }
        val navController = rememberNavController()
        var passwordVisualTransformation by remember {
            mutableStateOf<VisualTransformation>(
                PasswordVisualTransformation()
            )
        }
        val usernameInteractionState = remember { MutableInteractionSource() }
        val passwordInteractionState = remember { MutableInteractionSource() }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            item { Spacer(modifier = Modifier.height(20.dp)) }
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Welcome",
                        style = MaterialTheme.typography.h3.copy(
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(
                        text = "to",
                        style = MaterialTheme.typography.h3.copy(
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(
                        text = "MotorTracks",
                        style = MaterialTheme.typography.h3.copy(
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier.padding(top = 8.dp)
                    )

                }

            }
            item { Spacer(modifier = Modifier.height(18.dp)) }
            item {
                Card(

                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .height(300.dp),
                    elevation = 6.dp,
                    shape = MaterialTheme.shapes.small,


                    ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(6.dp)
                        ) {
                            Text(
                                text = "Login",
                                style = MaterialTheme.typography.h5,
                                modifier = Modifier.padding(
                                    bottom = 12.dp,
                                    top = 12.dp,
                                    start = 12.dp
                                )
                            )
                        }
                        OutlinedTextField(

                            value = username,
                            maxLines = 1,
                            isError = hasError,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Next
                            ),
                            label = { Text(text = "Username") },
                            placeholder = { Text("username") },
                            onValueChange = {
                                username = it
                            },
                            interactionSource = usernameInteractionState,

                            )
                        OutlinedTextField(
                            value = password,
                            maxLines = 1,
                            isError = hasError,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Password,
                                imeAction = ImeAction.Done
                            ),
                            label = { Text("Password") },
                            placeholder = { Text(text = "12334444") },
                            onValueChange = {
                                password = it
                            },
                            interactionSource = passwordInteractionState,
                            visualTransformation = passwordVisualTransformation,
                        )
                    }
                }

            }
            item {
                var loading by remember { mutableStateOf(false) }
                Button(
                    onClick = {
                        if (invalidInput(username.text, password.text)) {
                            hasError = true
                            loading = false
                        } else {
                            loading = true
                            hasError = false
                            onLoginSuccess.invoke()

                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                        .height(50.dp)
                        .clip(CircleShape),
                    enabled = true
                )
                {
                    if (loading) {
                        HorizontalDottedProgressBar()

                    } else {
                        Text(
                            text = "Ready to race",
                            style = MaterialTheme.typography.button,
                            color = MaterialTheme.colors.onPrimary
                        )
                    }
                }
            }
        }

    }

}
fun invalidInput(email: String, password: String) =
    email.isBlank() || password.isBlank() //|| email != "Lorenzo" || password != "honda"