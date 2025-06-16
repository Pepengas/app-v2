package com.hmu.electrical.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class NewsItem(
    val title: String,
    val date: LocalDate,
    val content: String,
    val type: NewsType
)

enum class NewsType {
    NEWS, ANNOUNCEMENT, EVENT
}

@Composable
fun HomeScreen() {
    val newsItems = listOf(
        NewsItem(
            "Ενημέρωση για εξετάσεις",
            LocalDate.now(),
            "Οι εξετάσεις του εξαμήνου θα διεξαχθούν στις 15/1/2024",
            NewsType.ANNOUNCEMENT
        ),
        NewsItem(
            "Εργαστήριο Ρομποτικής",
            LocalDate.now().plusDays(1),
            "Νέο εργαστήριο ρομποτικής στο τμήμα Ηλεκτρολόγων Μηχανικών",
            NewsType.NEWS
        ),
        NewsItem(
            "Ημερίδα AI",
            LocalDate.now().plusDays(3),
            "Ημερίδα για την Τεχνητή Νοημοσύνη στις 20/1/2024",
            NewsType.EVENT
        )
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(newsItems) { item ->
            NewsCard(item)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsCard(item: NewsItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = item.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = item.content,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = when(item.type) {
                    NewsType.NEWS -> "Νέα"
                    NewsType.ANNOUNCEMENT -> "Ανακοίνωση"
                    NewsType.EVENT -> "Εκδήλωση"
                },
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
} 