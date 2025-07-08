package com.example.myprofile.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myprofile.api.RetrofitInstance
import com.example.myprofile.models.ProfileDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {
    private val _profileList = MutableStateFlow<List<ProfileDto>>(emptyList())
    val profileList: StateFlow<List<ProfileDto>> = _profileList

    private val _selectedProfile = MutableStateFlow<ProfileDto?>(null)
    val selectedProfile: StateFlow<ProfileDto?> = _selectedProfile

    fun fetchProfiles() {
        viewModelScope.launch {
            _profileList.value = RetrofitInstance.api.getProfiles()
        }
    }

    fun fetchProfileById(id: Int) {
        viewModelScope.launch {
            _selectedProfile.value = RetrofitInstance.api.getProfileById(id)
        }
    }
}