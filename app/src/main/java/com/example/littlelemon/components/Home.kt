package com.example.littlelemon.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.littlelemon.MenuItem
import com.example.littlelemon.R
import com.example.littlelemon.ui.theme.GreenLittleLemon
import com.example.littlelemon.ui.theme.YellowLittleLemon

@Composable
fun Home(modifier: Modifier = Modifier, items: List<MenuItem>, onNavigateProfile: () -> Unit) {


    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.15f),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier.size(200.dp)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.4f)
                    .background(GreenLittleLemon)
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Little Lemon",
                        color = YellowLittleLemon,
                        fontSize = 40.sp
                    )
                    Text(
                        text = "Chicago",
                        color = Color.White,
                        fontSize = 30.sp
                    )
                    Spacer(Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Somos un restaurante mediterráneo familiar, centrado en recetas tradicionales servidas con un toque moderno",
                            color = Color.White,
                            modifier = Modifier
                                .weight(0.5f)
                                .padding(end = 10.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.hero),
                            contentDescription = "Hero",
                            modifier = Modifier.size(100.dp)
                        )
                    }
                    Spacer(Modifier.height(36.dp))
                    TextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("Enter search phrase") }
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.6f)
                    .padding(16.dp)
            ) {
                MenuItems(items)
            }
        }

        Box(
            modifier = Modifier.align(alignment = Alignment.TopEnd)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile",
                modifier = Modifier
                    .padding(top = 30.dp, end = 15.dp)
                    .size(65.dp)
                    .clickable(onClick = { onNavigateProfile() })
            )
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MenuItems(items: List<MenuItem>) {
    LazyColumn {
        items(items) { item ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(0.6f)
                ) {
                    Text(item.title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(10.dp))
                    Text(item.description, color = Color.Gray)
                    Spacer(Modifier.height(10.dp))
                    Text(text = " $ ${item.price}", color = Color.Gray)
                }
                GlideImage(
                    model = item.image,
                    contentDescription = "Image",
                    modifier = Modifier
                        .weight(0.2f)
                        .size(100.dp)
                        .padding(16.dp)
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomePreview(modifier: Modifier = Modifier) {
    Home(items = listOf()) {}
}