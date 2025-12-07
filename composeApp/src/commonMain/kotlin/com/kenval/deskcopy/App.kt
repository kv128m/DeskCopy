package com.kenval.deskcopy

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.kenval.deskcopy.theme.DeskCopyTheme
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.koin.koinViewModel
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject

@Composable
fun Comp() {

    val vm = koinViewModel<TestViewModel>()
    val viewState = vm.state.collectAsState()
    println(viewState.value)

    Box(
        modifier = Modifier.fillMaxSize()
    ) {}
}

@Composable
@Preview
fun App() {

    val testRepo: TestRepository = koinInject()

    PreComposeApp {
            val navigator = rememberNavigator()
            DeskCopyTheme {
                NavHost(
                    navigator = navigator,
                    initialRoute = "/home"
                ) {
                    scene("/home") {
                        Comp()


                    }
                }
            }
    }

}


//val testViewModel = koinViewModel<TestViewModel>()

//                    Scaffold { paddingValues ->
//                        Box(modifier = Modifier.padding(paddingValues), contentAlignment = Alignment.Center) {
//                            Button(
//                                onClick = {
//                                    CoroutineScope(Dispatchers.IO).launch {
//                                        val result = testRepo.getResponse()
//                                        println(result)
//                                    }
//                                }
//                            ) {
//                                Text("Send to server")
//                            }
//                        }
//                    }