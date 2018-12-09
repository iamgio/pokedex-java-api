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

# Getting started

To get started, let's try to get the types of [Bulbasaur](https://www.pokemon.com/us/pokedex/bulbasaur):

```java
public class Main {
    public static void main(String[] args) {
        Pokemon bulbasaur = Pokemon.fromName("bulbasaur");
        PokemonType[] types = bulbasaur.getTypes();
        for(PokemonType type : types) {
            System.out.println(type);
        }
    }
}
```

This will output:
```
GRASS
POISON
```

Every component of the API (such as Pokémons, abilities, etc) can be instantiated by using two static methods: `fromName`, which takes the name as a string, and `fromId`, which takes the identifier as a number.

_This project is currently work in progress. Once finished, the JAR file will be released. At the moment you're free to clone this repository and use it as you wish. Credits to this project and to pokeapi.co are appreciated._