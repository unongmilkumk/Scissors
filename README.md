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