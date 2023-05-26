import androidx.compose.runtime.Composable

interface InterfaceInAnotherModule {
    @Composable
    fun SomeUI(content: @Composable () -> Unit) // functions without implementation
}
