package dev.five_star.template

sealed interface ExampleAction {
    object OnButtonClicked: ExampleAction
}