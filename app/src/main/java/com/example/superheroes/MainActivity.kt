package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.superheroes.presentation.main.MainScreenViewModel
import com.example.superheroes.presentation.main.components.MainScreen
import com.example.superheroes.ui.theme.SuperheroesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme {
                val viewModel: MainScreenViewModel = hiltViewModel()
                MainScreen(
                    viewModel::getSuperhero,
                    viewModel.state
                )
            }
        }
    }
}