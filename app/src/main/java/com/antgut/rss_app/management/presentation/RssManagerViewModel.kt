package com.antgut.rss_app.management.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antgut.rss_app.management.domain.SaveRssUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RssManagerViewModel(private val addUserRssUseCase: SaveRssUseCase) : ViewModel() {

    val managerPublisher: MutableLiveData<RssManagerUiState> by lazy {
        MutableLiveData<RssManagerUiState>()
    }

    fun saveRss(url: String, name: String) {
        managerPublisher.value = RssManagerUiState(true)

        viewModelScope.launch(Dispatchers.IO) {
            addUserRssUseCase.execute(url, name)
            managerPublisher.postValue(
                RssManagerUiState(
                    isSuccess = true
                )
            )
        }
    }

    data class RssManagerUiState(
        val isSuccess: Boolean = false
    )

}