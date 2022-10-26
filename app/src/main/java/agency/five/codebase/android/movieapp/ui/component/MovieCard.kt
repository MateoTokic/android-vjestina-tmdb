package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.ui.theme.MovieAppTheme
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

data class MovieCardViewState(
    val imageUrl : String,
    val isFavorite : Boolean
)


@Composable
fun MovieCard(
    movieCardViewState : MovieCardViewState,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(15),
        elevation = 10.dp,
        modifier = modifier.size(120.dp,180.dp)
    ) {
        Box{
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(movieCardViewState.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                modifier = modifier
                    .clickable { }
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            FavoriteButton(
                isFavorite = movieCardViewState.isFavorite,
                modifier = modifier
                    .padding(start = 8.dp, top = 9.dp)
                    .align(Alignment.TopStart)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun MovieCardPreview(){
    MovieAppTheme {
        MovieCard(
            movieCardViewState = MovieCardViewState(
                imageUrl =  "https://m.media-amazon.com/images/M/MV5BMTczNTI2ODUwOF5BMl5BanBnXkFtZTcwMTU0NTIzMw@@._V1_FMjpg_UX1000_.jpg",
                isFavorite = false
            )
        )

    }
}