package com.antgut.rss_app.management.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antgut.rss_app.management.domain.DeleteRssUseCase
import com.antgut.rss_app.management.domain.GetUserUseCase
import com.antgut.rss_app.management.domain.ManagementModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ManagerViewModel(
    private val getUserRssUseCase: GetUserUseCase,
    private val deleteRssUseCase: DeleteRssUseCase
) : ViewModel() {

    val managerPublisher: MutableLiveData<ManagerFeedUiState> by lazy {
        MutableLiveData<ManagerFeedUiState>()
    }

    fun getRss() {
        managerPublisher.value = ManagerFeedUiState(true)

        viewModelScope.launch(Dispatchers.IO) {
            val rssFeed = getUserRssUseCase.execute()
            managerPublisher.postValue(
                ManagerFeedUiState(
                    isLoading = false,
                    rssFeed = rssFeed
                )
            )
        }
    }

    fun deleteRss(url: String) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteRssUseCase.execute(url)
        }
    }

    data class ManagerFeedUiState(
        val isLoading: Boolean = false,
        val rssFeed: List<ManagementModel> = emptyList()

        )

}