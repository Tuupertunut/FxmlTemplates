# FXML templates

Netbeans plugin for creating standalone FXML Nodes to JavaFX projects.

This plugin adds two new creatable file types under the JavaFX category:

### JavaFX FXML Node

Creates two files:

- FXML file, representing the scene graph of the node.
- Java class file, which works as both the root and controller of the FXML.

The Java file works as a standalone Node, meaning it can be added as a child to other Nodes.

### JavaFX FXML Application

Creates three files:

- JavaFX application main class
- The two files of an FXML Node, as described in the previous section. The node is used as the root node of the application.

# Usage

![Image of new file menu](https://i.imgur.com/OWBHQkl.png)

The new file types can be found in the "New file" dialog under the JavaFX category.

# Examples

### JavaFX FXML Node

Creating a JavaFX FXML Node with the name `MyNode` will create the following files:

**MyNode.java**

```java
package myapp;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class MyNode extends AnchorPane {

    public MyNode() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MyNode.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    private void initialize() {
    }
}
```

**MyNode.fxml**

```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.layout.AnchorPane?>

<fx:root id="AnchorPane" prefHeight="200.0" prefWidth="200.0" type="AnchorPane" xmlns:fx="http://javafx.com/fxml/1" />
```

### JavaFX FXML Application

Creating a JavaFX FXML Application with the name `MyApp` will create similar files, with an additional main class:

**MyApp.java**

```java
package myapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        MyAppPane root = new MyAppPane();

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
```

**MyAppPane.java**

```java
package myapp;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class MyAppPane extends AnchorPane {

    public MyAppPane() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MyAppPane.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    private void initialize() {
    }
}
```

**MyAppPane.fxml**

```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.layout.AnchorPane?>

<fx:root id="AnchorPane" prefHeight="200.0" prefWidth="200.0" type="AnchorPane" xmlns:fx="http://javafx.com/fxml/1" />
```
