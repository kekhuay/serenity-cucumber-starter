defaultTasks("clean", "test", "aggregate")

repositories {
    mavenLocal()
    jcenter()
}

buildscript {
    repositories {
        mavenLocal()
        jcenter()
    }
    dependencies {
        classpath("net.serenity-bdd:serenity-gradle-plugin:2.3.4")
    }
}

plugins {
    java
    eclipse
    idea
    kotlin("jvm") version "1.4.10"
}

apply(plugin = "net.serenity-bdd.aggregator")

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

val slf4jVersion = "1.7.7"
val serenityCoreVersion = "2.3.4"
val serenityCucumberVersion = "2.3.4"
val junitVersion = "4.12"
val assertJVersion = "3.8.0"
val logbackVersion = "1.2.3"

dependencies {
    implementation(kotlin("stdlib"))
    implementation("ch.qos.logback:logback-classic:$logbackVersion")

    testImplementation("net.serenity-bdd:serenity-core:$serenityCoreVersion")
    testImplementation("net.serenity-bdd:serenity-cucumber6:$serenityCucumberVersion")
    testImplementation("net.serenity-bdd:serenity-screenplay:$serenityCoreVersion")
    testImplementation("net.serenity-bdd:serenity-screenplay-webdriver:$serenityCoreVersion")
    testImplementation("net.serenity-bdd:serenity-ensure:$serenityCoreVersion")
    testImplementation("junit:junit:$junitVersion")
    testImplementation("org.assertj:assertj-core:$assertJVersion")
}

tasks.named<Test>("test") {
    testLogging {
        showStandardStreams = true
    }
    systemProperties(System.getProperties().mapKeys { it.key as String })
    finalizedBy("aggregate")
}

gradle.startParameter.isContinueOnFailure = true