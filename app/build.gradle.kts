plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.gd.texturesplitter"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.gd.texturesplitter"
        minSdk = 26 // Requerido para manejo de archivos eficiente
        targetSdk = 34
        versionCode = 1
        versionName = "1.0-Expressive"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Material 3 Expressive & Core
    implementation("androidx.compose.material3:material3:1.2.0")
    implementation("androidx.compose.ui:ui:1.6.0")
    implementation("androidx.compose.animation:animation:1.6.0")
    implementation("androidx.compose.material:material-icons-extended:1.6.0")
    
    // Navegación y Ciclo de vida
    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")

    // Manejo de imágenes y Plist (XML)
    implementation("org.dom4j:dom4j:2.1.4") // Para leer los .plist de Cocos2d-x
}
