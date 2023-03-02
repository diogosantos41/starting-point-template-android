package com.dscoding.startingpoint.ui.second_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.dscoding.startingpoint.domain.model.Product
import com.dscoding.startingpoint.ui.common_components.LoadingIndicator
import com.dscoding.startingpoint.ui.navigation.NavActions
import com.dscoding.startingpoint.ui.utils.DevicePreview
import com.dscoding.startingpoint.ui.utils.navActions
import com.dscoding.startingpoint.utils.formatToDisplayCurrency

@Composable
fun SecondScreen(
    navActions: NavActions,
    viewModel: SecondScreenViewModel = hiltViewModel()

) {
    val state = viewModel.uiState.value

    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        items(state.products) { product ->
            ProductItem(product = product, onClick = { })
        }
    }
    LoadingIndicator(visible = state.isLoading)
}

@Composable
fun ProductItem(product: Product, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(start = 15.dp, top = 15.dp, end = 15.dp, bottom = 5.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        ),
        colors = CardDefaults.cardColors(
            contentColor = MaterialTheme.colorScheme.onBackground,
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(80.dp),
                contentScale = ContentScale.Crop,
                model = product.thumbnail,
                contentDescription = "Product Image"
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp)
                    .weight(1f),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = product.title, fontWeight = FontWeight.ExtraBold)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = formatToDisplayCurrency(product.price, "€"), fontSize = 14.sp)
            }
        }
    }
}

@DevicePreview
@Composable
fun ProductListScreenPreview() {
    SecondScreen(rememberNavController().navActions())
}

