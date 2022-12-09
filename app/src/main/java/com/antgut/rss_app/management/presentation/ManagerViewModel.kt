package com.antgut.rss_app.management.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antgut.rss_app.management.domain.DeleteRssUseCase
import com.antgut.rss_app.management.domain.GetUserUseCase
import com.antgut.rss_app.management.domain.ManagementModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ManagerViewModel(private val getUserRssUseCase: GetUserUseCase, private val deleteRssUseCase: DeleteRssUseCase) : ViewModel() {

    val managerPublisher: MutableLiveData<RssManagerFeedUiState> by lazy {
        MutableLiveData<RssManagerFeedUiState>()
    }

    fun getRss() {
        managerPublisher.value = RssManagerFeedUiState(true)

        viewModelScope.launch(Dispatchers.IO) {
            val rssFeed = getUserRssUseCase.execute()
            managerPublisher.postValue(
                RssManagerFeedUiState(
                    isLoading = false,
                    rssFeed = rssFeed
                )
            )
        }
    }
    fun deleteRss(url:String){
        viewModelScope.launch (Dispatchers.IO){
            deleteRssUseCase.execute(url)
        }
    }

    data class RssManagerFeedUiState(
        val isLoading: Boolean = false,
        val rssFeed: List<ManagementModel> = emptyList()
    )

}