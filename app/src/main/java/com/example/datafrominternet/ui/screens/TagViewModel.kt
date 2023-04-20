package com.example.datafrominternet.ui.screens

import androidx.annotation.Keep
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

@Keep
class TagViewModel : ViewModel() {
    private val _includedTags = emptyList<Tags>().toMutableStateList()
    val includedTags: List<Tags> get() = _includedTags


    fun toggleIncludedTags(tag: Tags) {
        if (_includedTags.contains(tag))
            _includedTags.remove(tag)
        else
            _includedTags.add(tag)
    }
}