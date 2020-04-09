plugins {
    java
    application
    id("com.github.johnrengelman.shadow") version shadowJarVersion
    id("net.ltgt.apt-eclipse") version aptEclipseVersion
}

version = "0.1"
group = "ro.jtonic.handson.micronaut.cli.generated"

repositories {
    mavenCentral()
    maven { setUrl("https://jcenter.bintray.com") }
}

//fun Project.getDevelopmentOnlyConfiguration(): Configuration {
//    return configurations.findByName("developmentOnly")
//        ?: configurations.create("developmentOnly") {
//            dependencies.add(project.dependencies.implementation("io.micronaut:micronaut-runtime-osx"))
//            dependencies.add(project.dependencies.implementation("net.java.dev.jna:jna"))
//            dependencies.add(project.dependencies.implementation("io.micronaut:micronaut-http-client"))
//        }
//}

val developmentOnly by configurations.creating

dependencies {
    annotationProcessor(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    annotationProcessor("io.micronaut:micronaut-inject-java")
    annotationProcessor("io.micronaut:micronaut-validation")
    implementation(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-inject")
    implementation("io.micronaut:micronaut-validation")
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut:micronaut-http-server-netty")
    implementation("javax.annotation:javax.annotation-api")
    runtimeOnly("ch.qos.logback:logback-classic:$logbackVersion")
    testAnnotationProcessor(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    testAnnotationProcessor("io.micronaut:micronaut-inject-java")
    testImplementation(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("io.micronaut.test:micronaut-test-junit5")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

val mainClass = "ro.jtonic.handson.micronaut.cli.generated.Application"
// use JUnit 5 platform

tasks {

    withType<JavaExec> {
        classpath += developmentOnly
        jvmArgs = listOf("-noverify", "-XX:TieredStopAtLevel=1", "-Dcom.sun.management.jmxremote")
    }
    withType<JavaCompile> {
        with(options) {
            encoding = "UTF-8"
            compilerArgs.add("-parameters")
        }
    }
    test {
        // the error `Could not find io.micronaut:micronaut-runtime-osx:.` occurs when uncomment the following
        classpath += developmentOnly
        useJUnitPlatform()
    }
    shadowJar {
        manifest {
            attributes["Main-Class"] = mainClass
        }
        mergeServiceFiles()
    }
    application {
        mainClassName = mainClass
    }
}
