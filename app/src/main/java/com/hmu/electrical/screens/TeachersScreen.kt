package com.hmu.electrical.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

data class Teacher(
    val name: String,
    val title: String,
    val email: String,
    val phone: String,
    val office: String
)

@Composable
fun TeachersScreen() {
    val teachers = listOf(
        Teacher(
            "Κωνσταντίνος Παπαδόπουλος",
            "Καθηγητής",
            "k.papadopoulos@hmu.gr",
            "2810-379000",
            "Κτίριο ΗΜΜΥ, Γραφείο 101"
        ),
        Teacher(
            "Μαρία Αλεξίου",
            "Αναπληρώτρια Καθηγήτρια",
            "m.alexiou@hmu.gr",
            "2810-379001",
            "Κτίριο ΗΜΜΥ, Γραφείο 102"
        ),
        Teacher(
            "Γιώργος Νικολάου",
            "Επίκουρος Καθηγητής",
            "g.nikolaou@hmu.gr",
            "2810-379002",
            "Κτίριο ΗΜΜΥ, Γραφείο 103"
        )
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(teachers) { teacher ->
            TeacherCard(teacher)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeacherCard(teacher: Teacher) {
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
                text = teacher.name,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = teacher.title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = teacher.email,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = teacher.phone,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = teacher.office,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
} 