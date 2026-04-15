class TextureProcessor {
    // Función para el Downscaling de Spectra (UHD -> HD -> LOW)
    fun portTexture(originalBitmap: Bitmap, targetQuality: String): Bitmap {
        val scaleFactor = when(targetQuality) {
            "HD" -> 0.5f
            "LOW" -> 0.25f
            else -> 1.0f // UHD
        }
        return Bitmap.createScaledBitmap(
            originalBitmap, 
            (originalBitmap.width * scaleFactor).toInt(), 
            (originalBitmap.height * scaleFactor).toInt(), 
            true
        )
    }

    // Lógica para exportar a las carpetas específicas
    val basePath = "/storage/emulated/0/GD Texture Splitter/Export/"
    val paths = mapOf(
        "split" to "${basePath}Split/",
        "merge" to "${basePath}Merged/",
        "port" to "${basePath}Ported/"
    )
}
