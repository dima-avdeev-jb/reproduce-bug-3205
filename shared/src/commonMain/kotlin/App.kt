import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@Composable
fun App() {
    // https://github.com/JetBrains/compose-multiplatform/issues/3205
    Text("Reproduce bug 3205")
    MaterialUI2.SomeUI {
        Text("")
    }
}

object MaterialUI2 : FullStyle2, MAUIMetadata2

interface FullStyle2: InterfaceInAnotherModule

interface MAUIMetadata2 : InterfaceInAnotherModule {

    @Composable
    override fun SomeUI(
        content: @Composable () -> Unit,
    ) {
        content()
    }

}
