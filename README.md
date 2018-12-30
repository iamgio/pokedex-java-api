<p align="center">
    <img src="https://i.imgur.com/eT8UJl0.png">
</p>

[![Codacy](https://api.codacy.com/project/badge/Grade/087ddd3689bf4ad08d383f52a9936708)](https://www.codacy.com/app/iAmGio/pokedex-java-api?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=iAmGio/pokedex-java-api&amp;utm_campaign=Badge_Grade) [![CodeFactor](https://www.codefactor.io/repository/github/iamgio/pokedex-java-api/badge)](https://www.codefactor.io/repository/github/iamgio/pokedex-java-api)

# Pokédex Java API
_pokedex-java-api_ is the first wrapper for [pokeapi.co](https://pokeapi.co) written in pure Java.
   
# Why should I use PDJ API?
- [x] Fully documented  
- [x] Everything is treated as an object  
- [x] Mantainable and readable code  

# Maven

```xml
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>

    <dependencies>
        <dependency>
            <groupId>com.github.iAmGio</groupId>
            <artifactId>pokedex-java-api</artifactId>
            <version>VERSION</version>
        </dependency>
    </dependencies>
```

# Gradle

```groovy
  repositories {
	maven {
	  url 'https://jitpack.io' 
	}
  }
  
  dependencies {
    implementation 'com.github.iAmGio:pokedex-java-api:VERSION'
  }
```

# Manual / JAR

JAR files can be found in the [releases](https://github.com/iAmGio/pokedex-java-api/releases) tab.

# Getting started

To get started, let's try to get the types of [Bulbasaur](https://www.pokemon.com/us/pokedex/bulbasaur):

```java
public class Main {
    public static void main(String[] args) {
        Pokemon bulbasaur = Pokemon.fromName("bulbasaur");
        Pair<PokemonType, PokemonType> types = bulbasaur.getTypes();
        System.out.println(types.getFirst());
        System.out.println(types.getSecond());
    }
}
```

This will output:
```
GRASS
POISON
```

Every component of the API (such as Pokémons, abilities, etc) can be instantiated by using two static methods: `fromName`, which takes the name as a string, and `fromId`, which takes the identifier as a number.

# Localized strings

An interesting part of this library is the one which collects strings from various languages, contained inside the [lang](https://github.com/iAmGio/pokedex-java-api/tree/master/src/main/java/eu/iamgio/pokedex/lang) package.   
Every localized string is composed by two fields: `name` (String) and `language` (enum Language), and groups of them are stored inside specific lists, such as `LocalizedNames` or `FlavorList` (both extend `LocalizedNameList`). They have a `get(Language)` method which returns the string in the selected language.   

The particular one is `FlavorList`: a flavor is a localized string assigned within a version (or a version group) of the official game: having a flavor list, you will be able to do something like this:
```java
FlavorList<Version> flavors = ...;
String englishStringFromPearl = flavors.filterVersion(Version.PEARL).get(Language.ENGLISH);
```

_Credits to this project and to pokeapi.co are appreciated._