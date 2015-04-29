# dota2apiwrapper
A Java wrapper of Dota2 Web APIs.

## About
This project provides a simple Java wrapper for Valve's Web APIs (especially dota2, since I like it!). I use maven to manage the project, and I have already created a .jar file with all the dependencies, which is under the target directory. If you want to use this Java wrapper in your project, just copy it into your lib and add it to the project build path. I will keep updating the APIs, it can only retrieve match details by match id right now.

## Before you use the API
You need to register an API key first before you use this Java wrapper. Go to http://steamcommunity.com/dev/apikey and get a key using your steam account. It does not matter what you enter for the domain name. Keep your API key.

## How to use the API
- Initialize the wrapper object.
```java
Dota2APIWrapper api = new Dota2APIWrapper(YOUR_API_KEY);
```
- Get match details by match id.
```java
MatchDetail detail = api.getMatchDetails("1426751847"); // Pass in your match id as a String.
```
- Get up to date heroes list.
```java
Map<Integer, Hero> heroes = api.getHeroes();
```
- Get up to date game items list.
```java
Map<Integer, Item> items = api.getGameItems();
```
MatchDetail class has a lot of getters to get the details of the match (e.g. which team won, players details, game mode, etc.).

## Notes
More features are coming up! This is just a quick start of how it works. I will refactor the code later (e.g. provide factorires instead of calling the implementation directly, and adding docs for sure:)).
