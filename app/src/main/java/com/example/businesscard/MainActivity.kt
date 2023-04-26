package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.Icon
import androidx.compose.material.icons.filled.AlternateEmail
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF0a3b54)
                ) {
                    BusinessCardLayout()
                }
            }
        }
    }
}

@Composable
fun BusinessCardLayout () {
    Column {
        IntroducingBlock(
            image = painterResource(id = R.drawable.android_logo),
            fullName = "Yulia Dronova",
            title = "Software Developer",
            modifier = Modifier.weight(3f)
        )

        ContactInformationBlock(modifier = Modifier.weight(1f))
    }

}

@Composable
fun IntroducingBlock(
    image: Painter,
    fullName: String,
    title: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(150.dp)
        )
        Text(
            text = fullName,
            fontSize = 36.sp,
            color = Color(0xFFFFFFFF),
        )
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3DDC84),
        )
    }
}

@Composable
fun ContactInformationBlock(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Divider(color = Color.White, thickness = 1.dp)
        Spacer(Modifier.weight(0.1f))

        ContactInformationCard(
            icon = Icons.Default.Mail,
            data = "jtyutereva@gmail.com"
        )

        Spacer(Modifier.weight(0.1f))
        Divider(color = Color.White, thickness = 1.dp)
        Spacer(Modifier.weight(0.1f))

        ContactInformationCard(
            icon = Icons.Default.Phone,
            data = "+31 6 XX XX XX"
        )

        Spacer(Modifier.weight(0.1f))
        Divider(color = Color.White, thickness = 1.dp)
        Spacer(Modifier.weight(0.1f))

        ContactInformationCard(
            icon = Icons.Default.AlternateEmail,
            data = "someSocialMediaAccount"
        )
    }
}

@Composable
private fun ContactInformationCard(
    icon: ImageVector,
    data: String,
    modifier: Modifier = Modifier,
) {
    Row() {
        Icon(
            icon,
            contentDescription = null,
            modifier = Modifier.weight(1f),
            Color(0xFF3DDC84)
        )
        Text(
            text = data,
            modifier = Modifier.weight(4f),
            Color(0xFFFFFFFF)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardLayout()
    }
}