# 配置开发环境

配置Minecraft2D Mod开发环境非常简单。只需要像平常一样创建一个Gradle或Maven项目，然后稍作修改即可。

```groovy
plugins {
    id 'java'
    id 'idea'
}

group 'com.examplemod'
archivesBaseName = 'examplemod'
version '1.0.0'

repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
}

dependencies {
    // We use the early build
    implementation 'com.github.Over-Run:Minecraft2D:0605237f49'
    // Minecraft2D 所需的依赖库
    implementation 'it.unimi.dsi:fastutil:8.4.4'
    implementation 'org.apache.logging.log4j:log4j-core:2.14.0'
    implementation platform("org.lwjgl:lwjgl-bom:3.2.3")
    // LWJGL 三件套
    String[] lwjglDepends = ['', '-glfw', '-opengl']
    // 根据自己的平台去掉注释
    String lwjglPlatform = 
            'windows'
            // 'windows-x86'
            // 'linux-arm64'
            // 'linux-arm32'
            // 'linux'
            // 'macos'
    for (String depend in lwjglDepends) {
        implementation "org.lwjgl:lwjgl$depend"
        runtimeOnly "org.lwjgl:lwjgl$depend::natives-$lwjglPlatform"
    }
}

idea.module.inheritOutputDirs = true
```

导入完成后，我们就可以制作Mod了。