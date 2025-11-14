package com.example.pasteleria1000sabores.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaInicial(modifier: Modifier = Modifier) {
    val navItems = listOf(
        ItemsNav("Inicio", Icons.Default.Home),
        ItemsNav("Configuración", Icons.Default.Settings),
        ItemsNav("Notificaciones", Icons.Default.Notifications),
    )

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItems.forEachIndexed { index, nav ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = { selectedIndex = index },
                        icon = {
                            Icon(
                                imageVector = nav.icon,
                                contentDescription = nav.label
                            )
                        },
                        label = { Text(nav.label) },
                    )
                }
            }
        }
    )
    { innerPadding ->
        ContenidoPantalla(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            selectedIndex = selectedIndex
        )
    }
}

@Composable
fun ContenidoPantalla(modifier: Modifier = Modifier, selectedIndex: Int) {
    when (selectedIndex) {
        0 -> HomePage(modifier)
        1 -> SettingsPage(modifier)
        2 -> NotificationsPage(modifier)
    }
}

@Composable
fun HomePage(modifier: Modifier = Modifier) {
    PageContainer(text = "Bienvenido a Pastelería 1000 Sabores", modifier = modifier)
}

@Composable
fun SettingsPage(modifier: Modifier = Modifier) {
    PageContainer(text = "Configura tu experiencia", modifier = modifier)
}

@Composable
fun NotificationsPage(modifier: Modifier = Modifier) {
    PageContainer(text = "Aún no tienes notificaciones", modifier = modifier)
}

@Composable
private fun PageContainer(text: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(text)
    }
}

data class ItemsNav(val label: String, val icon: ImageVector)

@Preview(showBackground = true)
@Composable
fun PantallaInicialPreview() {
    Pasteleria1000SaboresTheme {
        PantallaInicial()
    }
}