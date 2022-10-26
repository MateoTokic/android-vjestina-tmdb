package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.ui.theme.MovieAppTheme
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserScoreProgressBar(
    progress: Float,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(42.dp)
            .padding(2.dp)
    ) {
        Canvas(modifier = Modifier.size(42.dp)) {
            drawArc(
                Color(red = 198,
                    green = 255,
                    blue = 202),
                startAngle = -90F,
                sweepAngle = 360F,
                style = Stroke(
                    cap = StrokeCap.Round,
                    width = 7F
                ),
                useCenter = false,
            )
            drawArc(
                Color(
                    red = 0,
                    green = 255,
                    blue = 0
                ),
                startAngle = -90F,
                sweepAngle = progress * 360,
                style = Stroke(
                    cap = StrokeCap.Round,
                    width = 7F,
                ),
                useCenter = false,
            )
        }
        Text(
            text = (progress * 10).toString(),
            modifier = modifier.align(Alignment.Center),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 14.sp
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun UserScoreProgressBarPreview(){
    MovieAppTheme {
        UserScoreProgressBar(
            progress = 0.75F
        )

    }

}