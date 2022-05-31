package com.example.provacomponenti.motor.Card

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
import com.example.provacomponenti.Database.Motor

import com.google.gson.Gson
import java.util.*


@Composable
fun CardAddMoto() {
    Card(
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
        elevation = 4.dp
    ) {
        AddMoto()
    }
}

@Composable
fun AddMoto() {
    var id by remember{ mutableStateOf(TextFieldValue("")) }
    var marca by remember { mutableStateOf(TextFieldValue("")) }
    var modello by remember { mutableStateOf(TextFieldValue("")) }
    var cilindrata by remember { mutableStateOf(TextFieldValue("")) }
    var typoOfMoto by remember { mutableStateOf(TextFieldValue("")) }
    var hp by remember { mutableStateOf(TextFieldValue("")) }
    var kg by remember { mutableStateOf(TextFieldValue("")) }
    var imgUrl by remember { mutableStateOf(TextFieldValue(""))}


    //---------------------------- DATA PICKER INSURANCE --------------------------------------//
    // gurdare https://www.geeksforgeeks.org/date-picker-in-android-using-jetpack-compose/

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
                label = { Text("Id", color = Color.LightGray) },
                placeholder = { Text(text = "Id") },
                onValueChange = {
                    id = it

                },
                //interactionSource = usernameInteractionState,
            )
            OutlinedTextField(
                value = marca,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(0.8f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                label = { Text("Marca", color = Color.LightGray) },
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
                label = { Text("Modello", color = Color.LightGray) },
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
                label = { Text("Cilindrata", color = Color.LightGray) },
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
                label = { Text("Tipo", color = Color.LightGray) },
                placeholder = { Text("Tipo") },
                onValueChange = {
                    typoOfMoto = it
                },
                //interactionSource = usernameInteractionState,
            )

            OutlinedTextField(
            value = hp,
            maxLines = 1,
            modifier = Modifier.fillMaxWidth(0.8f),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            label = { Text("Cavalli", color = Color.LightGray) },
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
            label = { Text("Kg", color = Color.LightGray) },
            placeholder = { Text("Kg") },
            onValueChange = {
                kg = it
            },

        )
            OutlinedTextField(
                value = imgUrl,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(0.8f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                label = { Text("Link", color = Color.LightGray) },
                placeholder = { Text("Link") },
                onValueChange = {
                    imgUrl = it
                },
            )

            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = {
                mDatePickerDialogInsurance.show()
            }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58))) {
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
            }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58))) {
                Text(text = "Bollo:", color = Color.White)
                Text(text = "${mDateTax.value}", color = Color.White,fontSize = 24.sp, textAlign = TextAlign.Center)
            }
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = { /*aggiungiMoto(
                    id.text.toInt(),marca.text,modello.text, cilindrata.text,typoOfMoto.text,hp.text.toInt(),
                    kg.text.toInt(),mDateTax.value,mDateInsurance.value, imgUrl.text
                )*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58))
            ) {
                Text("Aggiungi", color = Color.White)
            }
            Spacer(modifier = Modifier.height(12.dp))
        }
        OutlinedButton(
            onClick = { expanded = !expanded  }
        ) {
            Text(if (expanded) "-" else "+")
        }
        Spacer(modifier = Modifier.height(12.dp))
    }


}

/*
fun addMoto(id:Int, brand:String, model:String, disp:String,typeOfMoto:String,
hp:Int,kg:Int,tax:String,insurance:String, imageUrl:String){
    var motor = Motor(id,brand,model,disp,typeOfMoto,hp,kg,tax,insurance,imageUrl)
    motorette.add(motor)
}*/



