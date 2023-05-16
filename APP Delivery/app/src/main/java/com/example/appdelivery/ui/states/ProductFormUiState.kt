package com.example.appdelivery.ui.states

data class ProductFormUiState(
    val url: String = "",
    val name: String = "",
    val price: String = "",
    val description: String = "",
    val onUrlChange: (String) -> Unit = {},
    val onNameChange: (String) -> Unit = {},
    val onPriceChange: (String) -> Unit = {},
    val onDescriptionChange: (String) -> Unit = {},
//    val onSaveClick: () -> Unit = {},
) {
    val isShowPreview: Boolean get() = url.isNotBlank()
}