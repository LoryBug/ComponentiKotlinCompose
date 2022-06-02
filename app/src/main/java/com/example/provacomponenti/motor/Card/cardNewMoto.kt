package com.example.provacomponenti.motor.Card

import android.Manifest
import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.provacomponenti.Database.Motor
import com.example.provacomponenti.Database.MotorEvent
import com.example.provacomponenti.Database.MotorViewModel
import com.example.provacomponenti.Database.TrackViewModel
import com.example.provacomponenti.camera.CameraPreview
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState

import com.google.gson.Gson
import java.util.*


@Composable
fun CardAddMoto(motorViewModel: MotorViewModel, navController: NavController) {
    Card(
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
        elevation = 4.dp
    ) {
        AddMoto(motorViewModel, navController )
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun AddMoto(motorViewModel: MotorViewModel, navController: NavController) {
    var id by remember { mutableStateOf(TextFieldValue("")) }
    var marca by remember { mutableStateOf(TextFieldValue("")) }
    var modello by remember { mutableStateOf(TextFieldValue("")) }
    var cilindrata by remember { mutableStateOf(TextFieldValue("")) }
    var typoOfMoto by remember { mutableStateOf(TextFieldValue("")) }
    var hp by remember { mutableStateOf(TextFieldValue("")) }
    var kg by remember { mutableStateOf(TextFieldValue("")) }
    var imgUrl by remember { mutableStateOf(TextFieldValue("")) }

    val cameraPermissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)

    //---------------------------- DATA PICKER INSURANCE --------------------------------------//
    // Initializing a Calendar
    val mYearInsurance: Int
    val mMonthInsurance: Int
    val mDayInsurance: Int
    // Fetching the Local Context
    val mContextInsurance = LocalContext.current

    val mCalendarInsurance = java.util.Calendar.getInstance()

    mYearInsurance = mCalendarInsurance.get(java.util.Calendar.YEAR)
    mMonthInsurance = mCalendarInsurance.get(java.util.Calendar.MONTH)
    mDayInsurance = mCalendarInsurance.get(java.util.Calendar.DAY_OF_MONTH)

    mCalendarInsurance.time = Date()
    // Declaring a string value to
    // store date in string format
    val mDateInsurance = remember { mutableStateOf("") }

    // Declaring DatePickerDialog and setting
    val mDatePickerDialogInsurance = DatePickerDialog(
        mContextInsurance,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            mDateInsurance.value = "$mDayOfMonth/${mMonth + 1}/$mYear"
        }, mYearInsurance, mMonthInsurance, mDayInsurance
    )
    //---------------------------- DATA PICKER BOLLO --------------------------------------//

    // Initializing a Calendar
    val mYearTax: Int
    val mMonthTax: Int
    val mDayTax: Int
    // Fetching the Local Context
    val mContextTax = LocalContext.current

    val mCalendarTax = java.util.Calendar.getInstance()

    mYearTax = mCalendarTax.get(java.util.Calendar.YEAR)
    mMonthTax = mCalendarTax.get(java.util.Calendar.MONTH)
    mDayTax = mCalendarTax.get(java.util.Calendar.DAY_OF_MONTH)

    mCalendarTax.time = Date()
    // Declaring a string value to
    // store date in string format
    val mDateTax = remember { mutableStateOf("") }

    // Declaring DatePickerDialog and setting
    // initial values as current values (present year, month and day)
    val mDatePickerDialogTax = DatePickerDialog(
        mContextTax,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            mDateTax.value = "$mDayOfMonth/${mMonth + 1}/$mYear"
        }, mYearTax, mMonthTax, mDayTax
    )


    //------------------------------------------------//
    var expanded by rememberSaveable { (mutableStateOf(false)) }
    val extraPadding by animateDpAsState(
        if (expanded) 48.dp else 0.dp
    )
    var actMotor = Motor(
        id.text, marca.text, modello.text,
        cilindrata.text,
        typoOfMoto.text,
        hp.text,
        kg.text, mDateInsurance.value, mDateTax.value, imgUrl.text
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = extraPadding.coerceAtLeast(0.dp))
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessVeryLow
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            "Nuova Moto",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(12.dp))
        if (expanded) {
            OutlinedTextField(
                value = id,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(0.8f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                label = { Text("Id") },
                placeholder = { Text(text = "Id") },
                onValueChange = {
                    id = it
                },
            )
            OutlinedTextField(
                value = marca,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(0.8f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                label = { Text("Marca") },
                placeholder = { Text("Marca") },
                onValueChange = {
                    marca = it
                },

                )
            OutlinedTextField(
                value = modello,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(0.8f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                label = { Text("Modello") },
                placeholder = { Text("Modello") },
                onValueChange = {
                    modello = it
                },

                )
            OutlinedTextField(
                value = cilindrata,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(0.8f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                label = { Text("Cilindrata") },
                placeholder = { Text("Cilindrata") },
                onValueChange = {
                    cilindrata = it

                },

                )
            OutlinedTextField(
                value = typoOfMoto,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(0.8f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                label = { Text("Tipo") },
                placeholder = { Text("Tipo") },
                onValueChange = {
                    typoOfMoto = it
                },
            )

            OutlinedTextField(
                value = hp,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(0.8f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                label = { Text("Cavalli") },
                placeholder = { Text("Cavalli") },
                onValueChange = {
                    hp = it
                },
            )
            OutlinedTextField(
                value = kg,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(0.8f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                label = { Text("Kg") },
                placeholder = { Text("Kg") },
                onValueChange = {
                    kg = it
                },

                )
            Button(onClick = {
                cameraPermissionState.launchPermissionRequest()
                if(cameraPermissionState.hasPermission){
                    navController.navigate("camera")
                }

            }) {
                Text("camera permessi")
            }


            /*
            OutlinedTextField(
                value = imgUrl,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(0.8f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                label = { Text("Link") },
                placeholder = { Text("Link") },
                onValueChange = {
                    imgUrl = it
                },
            )*/

            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = {
                    mDatePickerDialogInsurance.show()
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)
            ) {
                Text(text = "Assicurazione", color = Color.White)
                Text(
                    text = " ${mDateInsurance.value}",
                    color = Color.White,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = {
                mDatePickerDialogTax.show()
            }, colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary))
            {
                Text(text = "Bollo:")
                Text(text = "${mDateTax.value}", fontSize = 24.sp, textAlign = TextAlign.Center)
            }
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = {
                    addNewMotor(motorViewModel, actMotor)
                },
            ) {
                Text("Aggiungi")
            }
            Spacer(modifier = Modifier.height(12.dp))
        }
        OutlinedButton(
            onClick = { expanded = !expanded }
        ) {
            Text(if (expanded) "-" else "+")
        }
        Spacer(modifier = Modifier.height(12.dp))
    }

}

fun addNewMotor(motorViewModel: MotorViewModel, motor: Motor) {

    motorViewModel.onTriggerEvent(MotorEvent.AddMoto(motor))
}
/*
fun addMoto(id:Int, brand:String, model:String, disp:String,typeOfMoto:String,
hp:Int,kg:Int,tax:String,insurance:String, imageUrl:String){
    var motor = Motor(id,brand,model,disp,typeOfMoto,hp,kg,tax,insurance,imageUrl)
    motorette.add(motor)
}*/



