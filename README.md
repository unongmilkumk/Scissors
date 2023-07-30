# Scissors Library
### Library for making MC Plugin

## What should we use it with
- Paper Server
- Basic of the Plugin Development Concept

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
    implementation 'io.github.unongmilkumk:Scissors:1.0.0'
}
```

## How to Use

### CommandMaker
- Initializing : ```new CommandMaker("<namespace>", "<command name>")```
- Command Execute Setting : ```CommandMaker#.setCommand((sender, args) -> { <Codes> }```
- Command Alias Setting : ```CommandMaker#.setAlias(<List of Alias>)```
- Register : ```CommandMaker#.register()```

### ItemMaker
- Initiallizing : ```new ItemMaker(<Material>)```
- Name Setting : ```ItemMaker#.name(<name>)```
- Lore Setting : ```ItemMaker#.lore(<list of lore>)```
- Unbreakable Setting : ```ItemMaker#.unbreakable(true / false)```


## Examples

### Case 1
- Code : 
```java 
new CommandMaker("sciplugin", "scissors").setCommand((sender, args) -> {
  sender.sendMessage("scissors");
  if (sender instanceof Player player) {
      player.getInventory().addItem(new ItemMaker(Material.DIAMOND_SWORD).name("Ultra Sword")
      .lore(List.of("This is a Ultra Sword")).unbreakable(true).item);
  }
  }).setAlias(List.of("sci")).register();
```
- Result : 
``` 
When type /scissors or /sci -> 
send "scissors"
give Diamond Sword named "Ultra Sword" lored "This is Ultra Sword"
```