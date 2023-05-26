import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun App() {
    // https://github.com/JetBrains/compose-multiplatform/issues/3205
    Text("Reproduce bug 3205")
    MaterialUI2.SomeUI {
        Text("")
    }
}

object MaterialUI2 : RedundantInterface, MAUIMetadata2 // Order maters

interface RedundantInterface : InterfaceInAnotherModule // Bug here

interface MAUIMetadata2 : InterfaceInAnotherModule {
    @Composable
    override fun SomeUI(
        content: @Composable () -> Unit,
    ) {
        content()
    }

}
