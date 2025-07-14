package dev.five_star.template

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.unit.dp
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun buttonClick_triggersOnAction() {
        composeTestRule.setContent {
            ExampleRoot(ExampleViewModel(), Modifier.padding(8.dp))
        }

        composeTestRule.onNodeWithTag("ClickMeButton").performClick()

        composeTestRule.onNodeWithTag("greetingText").assertTextEquals("Hello World!")
    }
}