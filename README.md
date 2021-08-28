
# 8086.java

A portable 8086 emulator written in JavaFX


## Environment Variables

To run this project, you will need to add the following environment variables with appropriate values

`JAVA_HOME` 



  
## Installation

You'll need `Maven` and a working `Java` environment

Edit the `pom.xml` file and change the values below to match that of your setup

```xml
  <maven.compiler.source>1.8</maven.compiler.source>
  <maven.compiler.target>1.8</maven.compiler.target>
```
> `javac --version` / `java -version` to get source and target version (or --version)

To Run

```bash
  mvn javafx:run
```

Clean run
```bash
  mvn clean javafx:run
```    