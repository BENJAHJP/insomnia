package com.example.superheroes.presentation.main.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.example.superheroes.domain.model.SuperheroModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(superheroModel: SuperheroModel) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
        pageCount = { 98 }
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
    }
}