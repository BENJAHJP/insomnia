package com.example.superheroes.presentation.main.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.example.superheroes.domain.model.SuperheroModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(
    getNextSuperHero: (id: Int) -> Unit,
    superheroModel: SuperheroModel
) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
        pageCount = { 751 }
    )
    Box {
        VerticalPager(
            state = pagerState
        ) {
            AsyncImage(
                model = superheroModel.image.url,
                contentScale = ContentScale.Crop,
                contentDescription = superheroModel.name
            )
        }
        Column {
            Text(text = superheroModel.name)
        }
        IconButton(
            onClick = {
                scope.launch {
                    pagerState.animateScrollToPage(
                        pagerState.currentPage + 1
                    )
                }
                getNextSuperHero(pagerState.currentPage + 1)
            }
        ) {

        }
    }
}