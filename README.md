# Scissors Library
### Library for making MC Plugin

## What should we use it with
- Paper Server
- Basic of the Plugin Development Concept

## Usage

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


##Examples

### Case 1
- Code : 
``` 
new CommandMaker("sciplugin", "scissors").setCommand((sender, args) -> {
  sender.sendMessage("scissors");
  if (sender instanceof Player player) {
      player.getInventory().addItem(new ItemMaker(Material.DIAMOND_SWORD).name("Ultra Sword")
      .lore(List.of("This is a Ultra Sword")).unbreakable(true).item);
  }
  }).setAlias(List.of("sci")).register();
```
- Result : 
``` When type /scissors or /sci -> send "scissors" and give Diamond Sword Named Ultra Sword Lored This is Ultra Sword```