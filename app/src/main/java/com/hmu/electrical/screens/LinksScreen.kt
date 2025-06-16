package com.hmu.electrical.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

data class LinkItem(
    val title: String,
    val icon: ImageVector,
    val url: String
)

@Composable
fun LinksScreen() {
    val links = listOf(
        LinkItem("eClass", Icons.Default.School, "https://eclass.hmu.gr"),
        LinkItem("Eudoxos", Icons.Default.MenuBook, "https://service.eudoxus.gr"),
        LinkItem("Webmail", Icons.Default.Email, "https://webmail.hmu.gr"),
        LinkItem("Πρόγραμμα Μαθημάτων", Icons.Default.CalendarMonth, "https://www.hmu.gr/electrical/courses")
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(links) { link ->
            LinkCard(link)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LinkCard(link: LinkItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clickable { /* TODO: Handle URL opening */ },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = link.icon,
                contentDescription = null,
                modifier = Modifier.size(48.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = link.title,
                style = MaterialTheme.typography.titleMedium,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }
    }
} 