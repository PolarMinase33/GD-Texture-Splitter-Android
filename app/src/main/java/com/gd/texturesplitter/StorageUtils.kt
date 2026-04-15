package com.gd.texturesplitter

import android.content.Context
import android.graphics.Bitmap
import android.os.Environment
import java.io.File
import java.io.FileOutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

object StorageUtils {

    // Ruta base solicitada: /GD Texture Splitter/Export
    private fun getBaseFolder(): File {
        val folder = File(Environment.getExternalStorageDirectory(), "GD Texture Splitter/Export")
        if (!folder.exists()) folder.mkdirs()
        return folder
    }

    /**
     * Crea carpetas hijas y guarda resultados
     * @param type: "Split", "Merged" o "Ported"
     */
    fun saveResult(type: String, fileName: String, bitmap: Bitmap? = null, zipContent: Map<String, Bitmap>? = null) {
        val targetDir = File(getBaseFolder(), type)
        if (!targetDir.exists()) targetDir.mkdirs()

        val file = File(targetDir, fileName)

        when {
            // Caso SPLIT: Crear ZIP con imágenes separadas
            type == "Split" && zipContent != null -> {
                ZipOutputStream(FileOutputStream(file)).use { zipOut ->
                    zipContent.forEach { (name, bmp) ->
                        val entry = ZipEntry(name)
                        zipOut.putNextEntry(entry)
                        bmp.compress(Bitmap.CompressFormat.PNG, 100, zipOut)
                        zipOut.closeEntry()
                    }
                }
            }
            // Caso MERGED/PORTED: Guardar PNG y su respectivo Plist
            bitmap != null -> {
                FileOutputStream(file).use { out ->
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
                }
            }
        }
    }

    /**
     * Genera el contenido del archivo .plist (Cocos2d-x)
     */
    fun generatePlist(frames: String): String {
        return """
            <?xml version="1.0" encoding="UTF-8"?>
            <!DOCTYPE plist PUBLIC "-//Apple Computer//DTD PLIST 1.0//EN" "http://www.apple.com/DTDs/PropertyList-1.0.dtd">
            <plist version="1.0">
            <dict>
                <key>frames</key>
                <dict>
                    $frames
                </dict>
                <key>metadata</key>
                <dict>
                    <key>format</key>
                    <integer>3</integer>
                    <key>pixelFormat</key>
                    <string>RGBA8888</string>
                </dict>
            </dict>
            </plist>
        """.trimIndent()
    }
}
