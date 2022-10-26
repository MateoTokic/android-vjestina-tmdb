package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.ui.theme.*
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest

data class ActorCardViewState(
    val imageUrl: String,
    val name: String,
    val character: String,
)

@Composable
fun ActorCard(
    actorCardViewState: ActorCardViewState,
    modifier: Modifier = Modifier,
) {
        Card (
            shape = RoundedCornerShape(15),
            modifier = modifier.width(125.dp)
                ){
            Column {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(actorCardViewState.imageUrl)
                        .build(),
                    contentDescription = "${actorCardViewState.name} profile image",
                    modifier = modifier
                        .fillMaxWidth()
                        .height(135.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = actorCardViewState.name,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = modifier
                        .padding(start = 10.dp, top = 6.dp, end = 28.dp, bottom = 2.dp),
                    fontSize = 13.sp
                )
                Text(
                    text = actorCardViewState.character,
                    color = if (isSystemInDarkTheme()) Gray300 else Gray600,
                    modifier = modifier
                        .padding(start = 10.dp, end = 10.dp, bottom = 10.dp),
                    fontSize = 11.sp
                )
            }
        }



}


@Preview(showBackground = true)
@Composable
private fun ActorCardPreview() {
    MovieAppTheme {
        ActorCard(
            actorCardViewState = ActorCardViewState(
                imageUrl = "https://www.pngall.com/wp-content/uploads/12/Robert-Downey-Jr-PNG-File.png",
                name = "Robert Downey Jr.",
                character = "Tony Stark/Iron Man"
            )
        )
    }
}
