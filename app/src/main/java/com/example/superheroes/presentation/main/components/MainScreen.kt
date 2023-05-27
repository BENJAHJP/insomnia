package com.example.superheroes.presentation.main.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.superheroes.domain.model.SuperheroModel
import com.example.superheroes.presentation.main.MainScreenState
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(
    getNextSuperHero: (id: String) -> Unit,
    state: MutableState<MainScreenState>
) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
        pageCount = { 751 }
    )
    Box {
        if (state.value.isLoading){
            CircularProgressIndicator(
                modifier = Modifier.align(
                    Alignment.Center
                )
            )
        } else if (state.value.message.isNotBlank()){
            Icon(
                modifier = Modifier
                    .clickable {
                        getNextSuperHero("$pagerState.currentPage")
                    }
                    .align(Alignment.Center)
                    .size(50.dp)
                ,
                imageVector = Icons.Rounded.Refresh,
                contentDescription = "refresh"
            )
        } else {
            VerticalPager(
                state = pagerState
            ) {
                AsyncImage(
                    model = state.value.superhero?.image?.url,
                    contentScale = ContentScale.Crop,
                    contentDescription = state.value.superhero?.name
                )
            }
            Column {
                Text(text = state.value.superhero?.name ?:"unknown")
            }
            IconButton(
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(
                            pagerState.currentPage + 1
                        )
                    }
                    getNextSuperHero("${pagerState.currentPage + 1}")
                }
            ) {
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowDown,
                    contentDescription = "arrow down"
                )
            }
        }
    }
}