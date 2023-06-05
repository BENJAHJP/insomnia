package com.example.superheroes.presentation.main.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SingleRow(
    title: String,
    value: String?
) {
    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = title,
            fontSize = 25.sp,
            color = Color.Red,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1f))
        if (value != null){
            Text(
                text = value,
                fontSize = 20.sp
            )
        }
    }
}