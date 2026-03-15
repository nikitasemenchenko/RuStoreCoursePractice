package com.example.rustorecoursepractice.presentation.appList

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.rustorecoursepractice.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainHeader(
    onClick: () -> Unit
) {
    TopAppBar(
        title = {
            Image(
                painter = painterResource(R.drawable.rustore_logo),
                contentDescription = null,
                modifier = Modifier.size(150.dp).clickable(onClick = onClick)
            )
        },
        actions = {
            IconButton(
                onClick = { },
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null,
                    modifier = Modifier.padding(start = 8.dp),
                    tint = MaterialTheme.colorScheme.onPrimaryContainer

                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}