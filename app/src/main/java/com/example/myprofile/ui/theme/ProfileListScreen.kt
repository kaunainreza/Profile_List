@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.myprofile.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProfileListScreen(
    viewModel: ProfileViewModel = ProfileViewModel(),
    onItemClick: (Any) -> Unit = { id -> println("Clicked on item $id") }
)
{
    val profiles by viewModel.profileList.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchProfiles()
    }

    Scaffold(topBar = { TopAppBar(title = { Text("Profiles") }) }) { padding ->
        LazyColumn(modifier = Modifier
            .padding(padding)
            .padding(16.dp)) {
            items(profiles) { profile ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .clickable { onItemClick(profile.id) }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(profile.title, style = MaterialTheme.typography.titleMedium)
                        Text("Completed: ${profile.completed}")
                    }
                }
            }
        }
    }
}
