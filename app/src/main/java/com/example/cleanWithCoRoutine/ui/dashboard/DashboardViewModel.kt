package com.example.cleanWithCoRoutine.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanWithCoRoutine.domain.usecases.GetCountriesUseCase
import com.example.cleanWithCoRoutine.domain.usecases.GetNumberOfTriesUseCase
import com.example.cleanWithCoRoutine.domain.usecases.InsertCountriesUseCase
import com.example.cleanWithCoRoutine.mappers.toDomain
import com.example.cleanWithCoRoutine.mappers.toPresentation
import com.example.cleanWithCoRoutine.models.Country
import com.example.cleanWithCoRoutine.models.StarWarsCharacterUiModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class DashboardViewModel
    @Inject constructor(
        val getCountriesUseCase: GetCountriesUseCase,
        val insertCountriesUseCase: InsertCountriesUseCase,
        val getNumberOfTriesUseCase: GetNumberOfTriesUseCase
    ) : ViewModel() {

    val searchResultsStarWars: LiveData<List<StarWarsCharacterUiModel>>
        get() = _searchResultsStarWars

    private var _searchResultsStarWars: MutableLiveData<List<StarWarsCharacterUiModel>> =
        MutableLiveData()

    val fromRoomDB: LiveData<List<Country>>
        get() = _fromRoomDB

    private var _fromRoomDB: MutableLiveData<List<Country>> =
        MutableLiveData()

    val numberOfTries: LiveData<Int>
        get() = _numberOfTries

    private var _numberOfTries: MutableLiveData<Int> =
        MutableLiveData()

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    fun search(params: String){

    }

    protected val handler = CoroutineExceptionHandler { _, exception ->
//        _uiState.value = Error(exception)
    }

    init {

        viewModelScope.launch(handler) {
            getCountriesUseCase().collect{countries ->
                _fromRoomDB.value = countries.map {
                    it.toPresentation()
                }
            }
        }

    }

    fun insert(){
        val countries = listOf<Country>(Country("nigeria", "Nigeria"), Country("america", "America"))

        viewModelScope.launch(handler) {
            insertCountriesUseCase(countries.map {
                it.toDomain()
            })
        }

    }

    fun getNumberOfTries(){
        viewModelScope.launch(handler) {
            getNumberOfTriesUseCase().collect{
                _numberOfTries.value = it
            }
        }
    }
}