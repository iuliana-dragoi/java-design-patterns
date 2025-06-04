# Java Design Patterns - Gradle Setup Guide

This repository contains implementations of various design patterns in Java, organized as a multi-project Gradle build.

## 🚀 Quick Start

### Prerequisites
- Java 17 or higher
- Git

### Clone and Setup
```bash
git clone https://github.com/yourusername/java-design-patterns.git
cd java-design-patterns
./gradlew build
```

## 📁 Project Structure

```
java-design-patterns/
├── gradle/wrapper/          # Gradle wrapper files (auto-generated)
├── gradlew                  # Gradle wrapper script (Unix)
├── gradlew.bat             # Gradle wrapper script (Windows)
├── settings.gradle         # Multi-project configuration
├── build.gradle           # Root build configuration
├── .gitignore
├── README.md
├── creational-patterns/
│   ├── singleton/
│   ├── factory-method/
│   └── ...
├── structural-patterns/
│   ├── adapter/
│   ├── decorator/
│   └── ...
└── behavioral-patterns/
    ├── observer/
    ├── strategy/
    └── ...
```

## 🛠️ Gradle Configuration

### Root Build Configuration (`build.gradle`)

```gradle
plugins {
    id 'java'
}

allprojects {
    group = 'com.patterns'
    version = '1.0.0'
    
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply plugin: 'java'
    apply plugin: 'application'
    
    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    
    dependencies {
        testImplementation 'org.junit.jupiter:junit-jupiter:5.9.2'
        testImplementation 'org.mockito:mockito-core:5.1.1'
    }
    
    test {
        useJUnitPlatform()
    }
}
```

### Multi-Project Setup (`settings.gradle`)

```gradle
rootProject.name = 'java-design-patterns'

// Creational Patterns
include 'creational-patterns:singleton'
include 'creational-patterns:factory-method'
include 'creational-patterns:abstract-factory'
include 'creational-patterns:builder'
include 'creational-patterns:prototype'

// Structural Patterns
include 'structural-patterns:adapter'
include 'structural-patterns:decorator'
include 'structural-patterns:facade'
include 'structural-patterns:composite'
include 'structural-patterns:proxy'

// Behavioral Patterns
include 'behavioral-patterns:observer'
include 'behavioral-patterns:strategy'
include 'behavioral-patterns:command'
include 'behavioral-patterns:template-method'
include 'behavioral-patterns:state'
include 'behavioral-patterns:chain-of-responsibility'
```

### Individual Pattern Build (`creational-patterns/singleton/build.gradle`)

```gradle
plugins {
    id 'java'
    id 'application'
}

application {
    mainClass = 'demo.SingletonDemo'
}

dependencies {
    // Pattern-specific dependencies if needed
}
```

## 🔧 Initial Setup Commands

### Option 1: From Scratch (if starting new project)

```bash
# Initialize new Gradle project
gradle init --type java-application --dsl groovy --test-framework junit-jupiter

# Choose options:
# Project type: 2 (application)
# Language: 3 (Java)  
# Multiple subprojects: yes
# Build script DSL: 1 (Groovy)
# Test framework: 4 (JUnit Jupiter)
```

### Option 2: Manual Setup (if repository exists)

```bash
# Create Gradle wrapper
gradle wrapper --gradle-version 8.4

# Verify setup
./gradlew --version
```

### Fixing Kotlin DSL to Groovy DSL

If you accidentally initialized with Kotlin DSL (.kts files):

```bash
# Rename files
mv settings.gradle.kts settings.gradle
mv build.gradle.kts build.gradle

# Update syntax inside files:
# - Change "string" to 'string'
# - Remove parentheses from method calls
# - Update plugin syntax
```

## 📋 Essential Gradle Commands

### Building
```bash
# Build entire project
./gradlew build

# Build specific pattern
./gradlew :creational-patterns:singleton:build

# Clean build
./gradlew clean build
```

### Running
```bash
# Run specific pattern demo
./gradlew :creational-patterns:singleton:run

# Run with arguments
./gradlew :creational-patterns:singleton:run --args="arg1 arg2"
```

### Testing
```bash
# Run all tests
./gradlew test

# Run tests for specific pattern
./gradlew :creational-patterns:singleton:test

# Run tests with details
./gradlew test --info
```

### Development
```bash
# Continuous build (watches for changes)
./gradlew build --continuous

# Generate IDE files
./gradlew idea          # IntelliJ IDEA
./gradlew eclipse       # Eclipse
```

### Project Management
```bash
# List all projects
./gradlew projects

# Show dependencies
./gradlew dependencies

# Show project structure
./gradlew :creational-patterns:singleton:dependencies --configuration compileClasspath
```

## 🎯 Adding New Pattern

### 1. Create Directory Structure
```bash
mkdir -p creational-patterns/new-pattern/src/main/java
mkdir -p creational-patterns/new-pattern/src/test/java
```

### 2. Add to `settings.gradle`
```gradle
include 'creational-patterns:new-pattern'
```

### 3. Create `build.gradle` for Pattern
```gradle
plugins {
    id 'java'
    id 'application'
}

application {
    mainClass = 'demo.NewPatternDemo'
}
```

### 4. Verify Setup
```bash
./gradlew :creational-patterns:new-pattern:build
```

## 🚨 Common Issues & Solutions

### Gradle Wrapper Not Found
```bash
# Regenerate wrapper
gradle wrapper --gradle-version 8.4
```

### Permission Denied (Unix/Linux/Mac)
```bash
chmod +x gradlew
```

### Java Version Issues
```bash
# Check Java version
java --version

# Set JAVA_HOME if needed
export JAVA_HOME=/path/to/java17
```

### Build Failures
```bash
# Clean and rebuild
./gradlew clean build

# Build with debug info
./gradlew build --debug --stacktrace
```

## 📚 Useful Gradle Resources

- [Gradle User Manual](https://docs.gradle.org/current/userguide/userguide.html)
- [Multi-Project Builds](https://docs.gradle.org/current/userguide/multi_project_builds.html)
- [Java Plugin Reference](https://docs.gradle.org/current/userguide/java_plugin.html)
- [Application Plugin](https://docs.gradle.org/current/userguide/application_plugin.html)

## 🏗️ Project Status

- ✅ Gradle setup complete
- ✅ Multi-project structure configured
- ⏳ Implementing patterns (in progress)

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Add your pattern implementation
4. Update `settings.gradle` to include new pattern
5. Create pull request

---

**Next Steps:** Start implementing design patterns! Begin with [Singleton Pattern](creational-patterns/singleton/)