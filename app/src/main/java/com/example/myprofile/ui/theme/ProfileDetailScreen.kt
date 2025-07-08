@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.myprofile.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@ExperimentalMaterial3Api
@Composable
fun ProfileDetailScreen(viewModel: ProfileViewModel, profileId: Int, onBack: () -> Unit) {
    val profile by viewModel.selectedProfile.collectAsState()

    LaunchedEffect(profileId) {
        viewModel.fetchProfileById(profileId)
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Profile Detail") }, navigationIcon = {
                IconButton(onClick = onBack) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            })
        }
    ) { padding ->
        profile?.let {
            Column(modifier = Modifier.padding(padding).padding(16.dp)) {
                Text("Title: ${it.title}", style = MaterialTheme.typography.titleLarge)
                Text("Completed: ${it.completed}")
                Text("User ID: ${it.userId}")
                Text("ID: ${it.id}")
            }
        } ?: Text("Loading...")
    }
}
