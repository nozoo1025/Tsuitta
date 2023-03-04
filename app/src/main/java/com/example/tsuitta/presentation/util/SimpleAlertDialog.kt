package com.example.tsuitta.presentation.util

import android.app.AlertDialog
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SimpleAlertDialog(
    title: String,
    message: String,
    confirmText: String,
    onConfirmed: () -> Unit,
) {
    val openDialog = remember { mutableStateOf(true) }

    // TODO: 色の管理を一箇所でする
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { },
            icon = { Icon(Icons.Default.Warning, contentDescription = "") },
            title = {
                Text(
                    text = title,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                    fontWeight = MaterialTheme.typography.headlineSmall.fontWeight
                )
            },
            text = {
                Text(
                    text = message,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = MaterialTheme.typography.bodyMedium.fontWeight
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {},
                ) {
                    Text(
                        text = confirmText,
                        fontSize = MaterialTheme.typography.labelLarge.fontSize,
                        fontWeight = MaterialTheme.typography.labelLarge.fontWeight,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        )
    }
}