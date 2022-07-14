package com.nasa.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nasa.domain.model.Result
import com.nasa.domain.use_case.GetCuriosityUseCase
import com.nasa.domain.use_case.GetOpportunityUseCase
import com.nasa.domain.use_case.GetSpiritUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCuriosityUseCase: GetCuriosityUseCase,
    private val getOpportunityUseCase: GetOpportunityUseCase,
    private val getSpiritUseCase: GetSpiritUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState(null, null, null))
    val state: StateFlow<HomeState> = _state

    fun getCuriosity(sol: Int, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            getCuriosityUseCase.invoke(sol, page)
                .collect { result ->
                    when(result) {
                        is Result.Loading -> {
                            _state.value = HomeState(
                                loading = true,
                                contents = null,
                                message = null,
                            )
                        }
                        is Result.Success -> {
                            _state.value = HomeState(
                                loading = null,
                                contents = result.data,
                                message = null,
                            )
                        }
                        is Result.Error -> {
                            _state.value = HomeState(
                                loading = null,
                                contents = null,
                                message = result.message,
                            )
                        }
                    }
                }
        }
    }

    fun getOpportunity(sol: Int, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            getOpportunityUseCase.invoke(sol, page).collect { result ->
                when(result) {
                    is Result.Loading -> {
                        _state.value = HomeState(
                            loading = true,
                            contents = null,
                            message = null,
                        )
                    }
                    is Result.Success -> {
                        _state.value = HomeState(
                            loading = null,
                            contents = result.data,
                            message = null,
                        )
                    }
                    is Result.Error -> {
                        _state.value = HomeState(
                            loading = null,
                            contents = null,
                            message = result.message,
                        )
                    }
                }
            }
        }
    }

    fun getSpirit(sol: Int, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            getSpiritUseCase.invoke(sol, page).collect { result ->
                when(result) {
                    is Result.Loading -> {
                        _state.value = HomeState(
                            loading = true,
                            contents = null,
                            message = null,
                        )
                    }
                    is Result.Success -> {
                        _state.value = HomeState(
                            loading = null,
                            contents = result.data,
                            message = null,
                        )
                    }
                    is Result.Error -> {
                        _state.value = HomeState(
                            loading = null,
                            contents = null,
                            message = result.message,
                        )
                    }
                }
            }
        }
    }

    fun clearState() {
        _state.value = HomeState(null, null, null)
    }

}