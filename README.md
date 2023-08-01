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
    implementation 'io.github.unongmilkumk:Scissors:1.0.1'
}
```

## How to Use

### CommandMaker
- Initializing : ```new CommandMaker("<namespace>", "<command name>")```
- Command Execute Setting : ```CommandMaker#.setCommand((sender, args) -> { <Codes> }```
- Command Alias Setting : ```CommandMaker#.setAlias(<List of Alias>)```
- Register : ```CommandMaker#.register()```

### ItemMaker
- Initializing : ```new ItemMaker(<Material>)``` (MakeItem) or ```new itemMaker(<Item>)``` (CopyItem)
- Name Setting : ```ItemMaker#.name(<name>)```
- Lore Setting : ```ItemMaker#.lore(<list of lore>)```
- Unbreakable Setting : ```ItemMaker#.unbreakable(true / false)```

### ConfigMaker
- Initializing : ```new ConfigMaker(<Plugin>, "<ConfigName>.yml"```
- Has : ```ConfigMaker#.has(<path>)``` -> Boolean of Contains "path"
- Get : ```ConfigMaker#.get(<path>)``` -> value of "path"
- Set : ```ConfigMaker#.set(<path>, <value>)``` -> set value of "path"
- Save : ```ConfigMaker#.save()``` -> Save Config

### Region
- Initializing : ```new Region(<World>, <x, y, z>, <x, y, z>)``` or ```new Region(<Location>, <Location>)```
- Contains : ```Region#.contains(<Region or Location>)```

### PlayerHeadMaker
- Initializing : ```new PlayerHeadMaker(<player name>)```
- Name Setting : ```ItemMaker#.name(<name>)```
- Lore Setting : ```ItemMaker#.lore(<list of lore>)```
- Unbreakable Setting : ```ItemMaker#.unbreakable(true / false)```

### GuiMaker
- Initializing : ```new GuiMaker(<Player>)``` (Player Inventory) or 
```new GuiMaker(<Name>)``` (Custom Inventory)
- Set : ```GuiMaker#.set( [<Index> or <Rows, Column>], <ItemStack> )```
- Get : ```GuiMaker#.get( [<Index> or <Rows, Column>] )```


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