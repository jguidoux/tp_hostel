plugins {
    id("info.solidsoft.pitest") version "1.4.0"
    `java-library`
}

repositories {
    jcenter()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8

}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

dependencies {
    api("org.slf4j:slf4j-api:1.7.25")
    implementation("ch.qos.logback:logback-classic:1.2.3")
    testImplementation("junit:junit:4.12")
    testImplementation("org.assertj:assertj-core:3.10.0")
    testImplementation("com.approvaltests:approvaltests:2.0.0")
}


pitest {
    targetClasses = setOf("fr.slickteam.hostel.*")  //by default "${project.group}.*"
    threads = 4
    pitestVersion = "1.4.0"
    outputFormats = setOf("XML", "HTML")
    timestampedReports = false
}
