package dev.five_star.template

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ExampleRoot(viewModel: ExampleViewModel, modifier: Modifier) {

    val state = viewModel.state.collectAsStateWithLifecycle()

    ExampleScreen(
        state = state.value, onAction = viewModel::onAction, modifier = modifier
    )

}

@Composable
fun ExampleScreen(
    state: ExampleState, onAction: (ExampleAction) -> Unit, modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { onAction(ExampleAction.OnButtonClicked) },
            modifier = modifier.testTag("ClickMeButton")
        ) {
            Text(text = "Click Me")
        }

        Text(
            text = state.greeting,
            modifier = modifier.testTag("greetingText")
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ExampleScreenPreview() {
    ExampleScreen(state = ExampleState(), onAction = {})
}
