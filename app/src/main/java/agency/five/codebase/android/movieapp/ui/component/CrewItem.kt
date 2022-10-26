package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.ui.theme.MovieAppTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class CrewItemViewState(
    val name: String,
    val job: String
)

@Composable
fun CrewItem(
    crewItemViewState : CrewItemViewState,
    modifier : Modifier = Modifier
)
{
    Column {
        Text(
            text = crewItemViewState.name,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .padding(bottom = 5.dp),
            fontSize = 14.sp

        )
        Text(
            text = crewItemViewState.job,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CardItemPreview() {
    MovieAppTheme {
        CrewItem(
                crewItemViewState = CrewItemViewState(
                    name = "Jon Favreau",
                    job = "Director"
                )
        )
    }
}