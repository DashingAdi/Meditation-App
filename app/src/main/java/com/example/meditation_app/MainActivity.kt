package com.example.meditation_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.meditation_app.ui.theme.MeditationAppTheme
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.meditation_app.ui.theme.FILTER_CONTENT_LIST
import com.example.meditation_app.ui.theme.FilterContent
import com.example.meditation_app.ui.theme.MEDITATION_TYPE_LIST
import com.example.meditation_app.ui.theme.MeditationType
import com.example.meditation_app.ui.theme.PurpleGrey80
import com.example.meditation_app.ui.theme.theme.Black


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeditationAppTheme {
                Column(modifier = Modifier
                    .background(PurpleGrey80)
                    .fillMaxSize()
                ) {
                    HeaderProfileComponent()
                    SearchInputComponent()
                    FilterOptionsComponent()
                    MeditationTypesComponent()
                }
            }
        }
    }

    val myMediumFont = Font(R.font.quicksand_medium)
    val myBoldFont = Font(R.font.quicksand_bold, FontWeight.Bold)

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun HeaderProfileComponent() {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp, top = 15.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pfp),
                    contentDescription = "Profile Picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                )
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Text(
                        text = "Welcome Back",
                        fontFamily = FontFamily(myMediumFont),
                        fontSize = 14.sp,
                        textAlign = TextAlign.Start,
                    )
                    Text(
                        text = "Eren Yeager",
                        fontFamily = FontFamily(myBoldFont),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Start,
                    )
                }
            }

            BadgedBox(badge = { Badge( containerColor = Color.Green ) }) {
                Icon(
                    Icons.Default.Notifications,
                    contentDescription = "Notification Icon",
                )
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SearchInputComponent() {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            shape = RoundedCornerShape(8.dp),
            placeholder = { Text(
                text = "Search",
                fontFamily = FontFamily(myMediumFont) ) },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.filter),
                        contentDescription = "Filter Icon",
                        modifier = Modifier.size(24.dp)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, start = 15.dp, end = 15.dp)
                    .background(Color.White, RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.LightGray,
                    unfocusedBorderColor = Color.White,
                    cursorColor = Color.LightGray,
                )
            )
    }

    @Composable
    fun FilterOptionsComponent() {
        val filterOptions = FILTER_CONTENT_LIST
        LazyRow(
            Modifier.padding(top = 15.dp, start = 15.dp, end = 15.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(filterOptions.size) {
                ChipComponent(filter = filterOptions[it])
            }
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun ChipComponent(filter: FilterContent) {
        val contentColor = filter.contentColor
        val backgroundColor = filter.backgroundColor
        val filterText = filter.filterText

        Chip(
            onClick = { /*TODO*/ },
            colors = ChipDefaults.chipColors(
                backgroundColor = backgroundColor,
                contentColor = contentColor
            ),
            shape = RoundedCornerShape(8.dp),
        ) {
            Text(text = filterText, fontFamily = FontFamily(myMediumFont))
        }
    }

    @Composable
    fun MeditationTypesComponent() {
        val meditationOptions = MEDITATION_TYPE_LIST
        LazyColumn(
            Modifier.padding(top = 15.dp, start = 15.dp, end = 15.dp, bottom = 15.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(meditationOptions.size) {
                MeditationOptionComponent(meditationTypes = meditationOptions[it])
                }

            }
        }


    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun MeditationOptionComponent(meditationTypes: MeditationType) {

        Card(
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier.fillMaxSize(),
            colors = CardDefaults.cardColors(
                containerColor = meditationTypes.backgroundColor

            )
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(20.dp)
            )
            {
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    Chip(
                        onClick = { /*TODO*/ },
                        colors = ChipDefaults.chipColors(
                            backgroundColor = meditationTypes.timeBackgroundColor,
                            contentColor = Black
                        ),
                        shape = RoundedCornerShape(8.dp),
                    ) {
                        Text(text = meditationTypes.duration, fontFamily = FontFamily(myMediumFont))
                    }
                    Chip(
                        onClick = { /*TODO*/ },
                        colors = ChipDefaults.chipColors(
                            backgroundColor = Color.White,
                            contentColor = Black
                        ),
                        shape = RoundedCornerShape(8.dp),
                    ) {
                        Text(text = meditationTypes.teacher, fontFamily = FontFamily(myMediumFont))
                    }
                }
                Text(
                    text = meditationTypes.title,
                    fontFamily = FontFamily(myBoldFont),
                    fontSize = 18.sp,
                    textAlign = TextAlign.Start,
                    color = meditationTypes.contentColor
                )
                Text(
                    text = meditationTypes.description,
                    fontFamily = FontFamily(myMediumFont),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start,
                    color = meditationTypes.contentColor
                )

            }
        }
    }

    }


