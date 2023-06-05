package com.example.superheroes.presentation.main.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.viewpager.widget.ViewPager
import coil.compose.AsyncImage
import com.example.superheroes.presentation.main.MainScreenState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(
    getNextSuperHero: (id: String) -> Unit,
    state: MutableState<MainScreenState>
) {

    val pagerState = rememberPagerState(
        initialPage = 4,
        initialPageOffsetFraction = 0f,
        pageCount = {175}
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
                        getNextSuperHero("1")
                    }
                    .align(Alignment.Center)
                    .size(50.dp)
                ,
                imageVector = Icons.Rounded.Refresh,
                contentDescription = "refresh"
            )
        } else {
            VerticalPager(state = pagerState) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ){
                    AsyncImage(
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize(),
                        model = state.value.superhero?.image?.url,
                        contentDescription = "")
                    ElevatedCard(
                        modifier = Modifier
                            .padding(20.dp)
                            .height(300.dp)
                    ) {
                        SingleRow(title = "Name", value = state.value.superhero?.name)
                        SingleRow(title = "Gender", value = state.value.superhero?.appearance?.gender)
                        SingleRow(title = "Eye color", value = state.value.superhero?.appearance?.`eye-color`)
                        SingleRow(title = "Hair Color", value = state.value.superhero?.appearance?.`hair-color`)
                        SingleRow(title = "Race", value = state.value.superhero?.appearance?.race)
                        SingleRow(title = "Height", value = state.value.superhero?.appearance?.height?.firstOrNull())
                        SingleRow(title = "Weight", value = state.value.superhero?.appearance?.weight?.firstOrNull())
                    }
                }
            }
        }
    }
}