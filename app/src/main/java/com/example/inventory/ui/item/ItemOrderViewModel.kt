package com.example.inventory.ui.item
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.inventory.data.ItemsRepository
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first

/**
 * ViewModel to retrieve and update an item from the [ItemsRepository]'s data source.
 */
class ItemOrderViewModel(
    savedStateHandle: SavedStateHandle,
    private val itemsRepository: ItemsRepository
) : ViewModel() {

    private val itemId: Int = checkNotNull(savedStateHandle[ItemEditDestination.itemIdArg])
    /**
     * Holds current item ui state
     */
    var itemUiState by mutableStateOf(ItemUiState())
        private set

    init {
        viewModelScope.launch {
            itemUiState = itemsRepository.getItemStream(itemId)
                .filterNotNull()
                .first()
                .toItemUiState(true)
        }

    }

    //Validate that the order isn't empty
    private fun validateInput(uiState: ItemDetails = itemUiState.itemDetails): Boolean {
        return with(uiState) {
            quantity.isNotBlank()
        }
    }

//    fun increaseQuantity(amount: Int) {
//        val currentQuantity = itemUiState.itemDetails.quantity.toInt()
//        itemUiState = itemUiState.copy(
//            itemDetails = itemUiState.itemDetails.copy(
//                quantity = (currentQuantity + amount).toString()
//            )
//        )
//    }
//
//    fun updateUiState(itemDetails: ItemDetails) {
//        itemUiState =
//            ItemUiState(itemDetails = itemDetails, isEntryValid = validateInput(itemDetails))
//    }
//
//    suspend fun updateItem() {
//        if (validateInput(itemUiState.itemDetails)) {
//            itemsRepository.updateItem(itemUiState.itemDetails.toItem())
//        }
//    }

}