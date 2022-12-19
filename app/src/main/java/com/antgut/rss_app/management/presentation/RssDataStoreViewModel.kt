package com.antgut.rss_app.management.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antgut.rss_app.management.domain.AddRssUseCase
import com.antgut.rss_app.management.domain.DeleteRssUseCase
import com.antgut.rss_app.management.domain.GetUserUseCase
import com.antgut.rss_app.management.domain.ManagementModel
import kotlinx.coroutines.launch

class RssDataStoreViewModel (
    private val getUserUseCase: GetUserUseCase,
    private val addRssUseCase: AddRssUseCase,
    private val deleteRssUseCase: DeleteRssUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData(UiState())
    val uiState: LiveData<UiState> = _uiState

    fun obtainUserRssList() {
        viewModelScope.launch {
            getUserUseCase.invoke()
                .collect { userRss ->
                    _uiState.postValue(
                        UiState(
                            isLoading = false,
                            userRssList = userRss
                        )
                    )
                }
        }
    }

    fun saveUserRss(url: String, name: String) {
        viewModelScope.launch {
            addRssUseCase.invoke(url, name)
        }
    }

    fun deleteUserRss(url: String){
        viewModelScope.launch {
            deleteRssUseCase.invoke(url)
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val userRssList: List<ManagementModel>? = null
    )
}