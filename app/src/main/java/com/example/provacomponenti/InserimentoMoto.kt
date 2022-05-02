package com.example.provacomponenti

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.provacomponenti.Model.insertNewMoto
import java.util.*


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CardNewMoto() {
    var id by remember { mutableStateOf(TextFieldValue("")) }
    var marca by remember { mutableStateOf(TextFieldValue("")) }
    var modello by remember { mutableStateOf(TextFieldValue("")) }
    var cilindrata by remember { mutableStateOf(TextFieldValue("")) }
    var typoOfMoto by remember { mutableStateOf(TextFieldValue("")) }
    var hp by remember { mutableStateOf(TextFieldValue("")) }
    var kg by remember { mutableStateOf(TextFieldValue("")) }


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


    Card(
        elevation = 6.dp,
        shape = MaterialTheme.shapes.small,
        backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxWidth(0.8f),
        //on click si espande e compare tutta la lista di info
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Nuova Moto",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(12.dp))
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
                label = { Text("", color = Color.LightGray) },
                placeholder = { Text("Marca") },
                onValueChange = {
                    marca = it
                },
                //interactionSource = usernameInteractionState,
            )
            OutlinedTextField(
                value = modello,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(0.8f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                label = { Text("", color = Color.LightGray) },
                placeholder = { Text("Modello") },
                onValueChange = {
                    modello = it
                },
                //interactionSource = usernameInteractionState,
            )
            OutlinedTextField(
                value = cilindrata,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(0.8f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                label = { Text("", color = Color.LightGray) },
                placeholder = { Text("Cilindrata") },
                onValueChange = {
                    cilindrata = it
                },
                //interactionSource = usernameInteractionState,
            )
            OutlinedTextField(
                value = typoOfMoto,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(0.8f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                label = { Text("", color = Color.LightGray) },
                placeholder = { Text("Tipo") },
                onValueChange = {
                    cilindrata = it
                },
                //interactionSource = usernameInteractionState,
            )

            /*OutlinedTextField(
                value = hp,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(0.8f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                label = { Text(Resources.getSystem().getString(R.string.pot), color = Color.LightGray) },
                placeholder = { Text(Resources.getSystem().getString(R.string.typeMoto)) },
                onValueChange = {
                    cilindrata = it
                },
                //interactionSource = usernameInteractionState,
            )
            OutlinedTextField(
                value = kg,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(0.8f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                label = { Text(Resources.getSystem().getString(R.string.weight), color = Color.LightGray) },
                placeholder = { Text(Resources.getSystem().getString(R.string.typeMoto)) },
                onValueChange = {
                    kg = it
                },
                //interactionSource = usernameInteractionState,
            )*/

            Spacer(modifier = Modifier.height(12.dp))

            Button(onClick = {
                mDatePickerDialogInsurance.show()
            }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58))) {
                Text(text = "Assicurazione", color = Color.White)
                Text(
                    text = " ${mDateInsurance.value}",
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(onClick = {
                mDatePickerDialogTax.show()
            }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58))) {
                Text(text = "Bollo:", color = Color.White)
                Text(text = "${mDateTax.value}", fontSize = 30.sp, textAlign = TextAlign.Center)
            }
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58))
            ) {
                Text("Aggiungi", color = Color.White)
            }
            Spacer(modifier = Modifier.height(12.dp))


        }
        //insertNewMoto(id.text, marca.text,modello.text, cilindrata.text, typoOfMoto.text,kg.text,mDateTax, mDateInsurance)

    }

}


@Preview(widthDp = 350)
@Composable
fun CardNewMotoPrev() {
    CardNewMoto()
}