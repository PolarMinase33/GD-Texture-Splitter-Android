@Composable
fun FloatingNavBar(navController: NavController) {
    Surface(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(64.dp),
        shape = CircleShape, // Forma de cápsula Expressive
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.9f),
        tonalElevation = 8.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* Navegar a Split */ }) { Icon(Icons.Default.Scissors, "Split") }
            IconButton(onClick = { /* Navegar a Merge */ }) { Icon(Icons.Default.Layers, "Merge") }
            IconButton(onClick = { /* Navegar a Port */ }) { Icon(Icons.Default.Transform, "Port") }
            IconButton(onClick = { /* Navegar a Settings */ }) { Icon(Icons.Default.Settings, "Settings") }
        }
    }
}
