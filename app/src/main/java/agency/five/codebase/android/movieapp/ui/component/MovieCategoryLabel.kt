package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.ui.theme.Blue
import agency.five.codebase.android.movieapp.ui.theme.Gray300
import agency.five.codebase.android.movieapp.ui.theme.Gray600
import agency.five.codebase.android.movieapp.ui.theme.MovieAppTheme
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class MovieCategoryLabelViewState(
    val itemId: Int,
    val isSelected: Boolean,
    val categoryText: MovieCategoryLabelTextViewState
)

sealed class MovieCategoryLabelTextViewState

class MovieCategoryLabelTextViewStateDirect(val text : String): MovieCategoryLabelTextViewState()

class MovieCategoryLabelTextViewStateReference(@StringRes val stringResId: Int): MovieCategoryLabelTextViewState()

@Composable
fun MovieCategoryLabel(
    movieCategoryLabelViewState: MovieCategoryLabelViewState,
    modifier: Modifier = Modifier
) {
    var isSelected by remember { mutableStateOf(movieCategoryLabelViewState.isSelected) }
    Column(
        modifier = modifier.width(IntrinsicSize.Min)
    ) {
        Text(
            text = when(movieCategoryLabelViewState.categoryText) {
                is MovieCategoryLabelTextViewStateReference -> stringResource(id = movieCategoryLabelViewState.categoryText.stringResId)
                is MovieCategoryLabelTextViewStateDirect -> movieCategoryLabelViewState.categoryText.text
            },
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            color = if (isSelected) MaterialTheme.colors.onBackground else if (isSystemInDarkTheme()) Gray300 else Gray600,
            fontSize = 16.sp,
            modifier = modifier.clickable { isSelected = true }
        )
        if (isSelected) {
            Divider(
                color = if(isSystemInDarkTheme()) Color.White else Color.Black,
                thickness = 3.dp,
                modifier = modifier.padding(top = 2.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun MovieCategoryPreview(){
    MovieAppTheme {
        MovieCategoryLabel(
            movieCategoryLabelViewState = MovieCategoryLabelViewState(
                itemId = 0,
                isSelected = true,
                categoryText = MovieCategoryLabelTextViewStateDirect( text = "Movie")
            )
        )

    }
}