package com.example.inventory.ui.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.inventory.InventoryTopAppBar
import com.example.inventory.R
import com.example.inventory.ui.AppViewModelProvider
import com.example.inventory.ui.navigation.NavigationDestination
import com.example.inventory.ui.theme.InventoryTheme
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.KeyboardType
import kotlinx.coroutines.launch
import java.util.Currency
import java.util.Locale


object ItemOrderDestination : NavigationDestination {
    override val route = "item_order"
    override val titleRes = R.string.item_order_title
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemOrderScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ItemOrderViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            InventoryTopAppBar(
                title = stringResource(ItemOrderDestination.titleRes),
                canNavigateBack = true,
            )
        },
        modifier = modifier
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            Text("Item Order Screen")
        }
//        ItemOrderBody(
//            itemUiState = viewModel.itemUiState,
//            onItemValueChange = viewModel::updateUiState,
//            onSaveClick = {
//                coroutineScope.launch {
//                    //viewModel.updateItem() //FIXME: Replace with increase quantity function
//                    navigateBack()
//                }
//            },
//            modifier = Modifier
//                .padding(
//                    start = innerPadding.calculateStartPadding(LocalLayoutDirection.current),
//                    end = innerPadding.calculateEndPadding(LocalLayoutDirection.current),
//                    top = innerPadding.calculateTopPadding()
//                )
//                .verticalScroll(rememberScrollState())
//        )
    }
}
//
//@Composable
//fun ItemOrderBody(
//    itemUiState: ItemUiState,
//    onItemValueChange: (ItemDetails) -> Unit,
//    onSaveClick: () -> Unit,
//    modifier: Modifier = Modifier
//) {
//    Column(
//        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_large)),
//        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_medium))
//    ) {
//        ItemOrderForm(
//            itemDetails = itemUiState.itemDetails,
//            onValueChange = onItemValueChange,
//            modifier = Modifier.fillMaxWidth()
//        )
//        Button(
//            onClick = onSaveClick,
//            enabled = itemUiState.isEntryValid,
//            shape = MaterialTheme.shapes.small,
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text(stringResource(R.string.order))
//        }
//    }
//}
//
//@Composable
//fun ItemOrderForm(
//    itemDetails: ItemDetails,
//    modifier: Modifier = Modifier,
//    onValueChange: (ItemDetails) -> Unit = {},
//    enabled: Boolean = true
//) {
//    Column(
//        modifier = modifier,
//        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
//    ) {
//        OutlinedTextField(
//            value = itemDetails.quantity,
//            onValueChange = { onValueChange(itemDetails.copy(quantity = it)) },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            label = { Text(stringResource(R.string.quantity_req)) },
//            colors = OutlinedTextFieldDefaults.colors(
//                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
//                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
//                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
//            ),
//            modifier = Modifier.fillMaxWidth(),
//            enabled = enabled,
//            singleLine = true
//        )
//        if (enabled) {
//            Text(
//                text = stringResource(R.string.required_fields),
//                modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium))
//            )
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun ItemOrderScreenPreview() {
    InventoryTheme {
//        ItemOrderBody(
//            itemUiState = ItemUiState(),
//            onItemValueChange = {},
//            onSaveClick = {},
//            modifier = Modifier.fillMaxWidth()
//        )
        ItemOrderScreen(
            navigateBack = {}
        )
    }
}