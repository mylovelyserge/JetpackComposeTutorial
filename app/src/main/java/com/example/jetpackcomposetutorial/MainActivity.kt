package com.example.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTutorialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TutorialScreen(
                        stringResource(R.string.tutorial_title),
                        firstText = stringResource(R.string.tutorial_first_text),
                        secondText = stringResource(R.string.tutorial_second_text)
                    )
                }
            }
        }
    }
}

@Composable
fun TutorialTitle(message: String, modifier: Modifier = Modifier) {
    Text(
        text = message,
        fontSize = 24.sp,
        modifier = modifier,
        textAlign = TextAlign.Left
    )
}

@Composable
fun TutorialFirstText(message: String, modifier: Modifier = Modifier) {
    Text(
        text = message,
        modifier = modifier,
        textAlign = TextAlign.Justify
    )
}

@Composable
fun TutorialSecondText(message: String, modifier: Modifier = Modifier) {
    Text(
        text = message,
        modifier = modifier,
        textAlign = TextAlign.Justify
    )
}

@Composable
fun TutorialScreen(title: String, firstText: String, secondText: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.head_image)
    Column(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
        TutorialTitle(
            message = title,
            modifier = modifier.padding(16.dp),
        )
        TutorialFirstText(
            message = firstText,
            modifier = modifier.padding(start = 16.dp, end = 16.dp)
        )
        TutorialSecondText(
            message = secondText,
            modifier = modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTutorialTheme {
        TutorialScreen(
            title = stringResource(R.string.tutorial_title),
            firstText = stringResource(R.string.tutorial_first_text),
            secondText = stringResource(R.string.tutorial_second_text)
        )
    }
}