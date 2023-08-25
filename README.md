# Scissors Library
### Library for making MC Plugin

## What should we use it with
- Paper Server
- Basic of the Plugin Development Concept

## Support Version
```
1.20.1 (Main Version)
1.16 ~ (Untested)
``` 

## What is the benefit to use this?
- Don't have to write plugin.yml commands:
- Can code to intuitive
- Inexperienced programmer also can use


## How to Import
```gradle 
repositories {
    mavenCentral()
}

dependencies {
    implementation 'io.github.unongmilkumk:Scissors:1.2.0'
}
```

## List Of API

CommandMaker

ItemMaker

ConfigMaker

Region

PlayerHeadMaker

KoreanPack


## Examples

### Case 1
- Code : 
```java 
new CommandMaker("sciplugin", "scissors").setCommand((sender, args) -> {
  sender.sendMessage("scissors");
  if (sender instanceof Player player) {
      player.getInventory().addItem(
          new ItemMaker(Material.DIAMOND_SWORD)
          .name("Ultra Sword")
          .lore(List.of(
                  "This is a Ultra Sword"
              )
          )
          .unbreakable(true).item
      );
  }
  }).setAlias(List.of("sci")).register();
```
- Result : 
``` 
When type /scissors or /sci -> 
send "scissors"
give Diamond Sword named "Ultra Sword" lored "This is Ultra Sword"
```