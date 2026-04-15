// Fragmento de la UI principal con Navigation Bar Flotante
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            FloatingNavigationBar(navController)
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = "split", Modifier.padding(innerPadding)) {
            composable("split") { SplitScreen() }
            composable("merge") { MergeScreen() }
            composable("port") { PortScreen() }
            composable("settings") { SettingsScreen() }
        }
    }
}

@Composable
fun FloatingNavigationBar(navController: NavController) {
    Surface(
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(24.dp)), // Estilo Expressive
        color = MaterialTheme.colorScheme.surfaceVariant,
        tonalElevation = 8.dp
    ) {
        NavigationBar(containerColor = Color.Transparent) {
            val items = listOf("Split", "Merge", "Port", "Settings")
            items.forEach { item ->
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Build, contentDescription = item) },
                    label = { Text(item) },
                    selected = false,
                    onClick = { navController.navigate(item.lowercase()) }
                )
            }
        }
    }
}
