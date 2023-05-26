import androidx.compose.runtime.Composable

@Composable
fun App() {
    ObjectWithImplementation1.SomeUI {
        println("Works fine")
    }
    ObjectWithImplementation2.SomeUI {
        println("Don't executes")
    }
}

object ObjectWithImplementation1 : InterfaceWithImplementation, RedundantInterface // Works fine
object ObjectWithImplementation2 : RedundantInterface, InterfaceWithImplementation // Bug here, order maters

interface RedundantInterface : InterfaceInAnotherModule

interface InterfaceWithImplementation : InterfaceInAnotherModule {
    @Composable
    override fun SomeUI(
        content: @Composable () -> Unit,
    ) {
        content()
    }
}
