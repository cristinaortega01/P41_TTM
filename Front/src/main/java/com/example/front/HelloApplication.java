package com.example.front;

package com.example.front;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import java.applet.AudioClip;
import java.io.IOException;
import java.util.LinkedList;

public class HelloApplication extends Application {
    private Scene thirdscene(Stage stage){
        //Crear aqui segunda escena
        StackPane stack = new StackPane();
        Text title = new Text("Music Tune Education");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        title.setTextAlignment(TextAlignment.CENTER);
        HBox hbox = new HBox();
        hbox.setMargin(title, new Insets(0, 0, 0, 350));
        hbox.getChildren().add(title);

        //Imagen
        /* private Image img = new Image("C:\\Users\\leon\\Pictures\\lobo.jpg", false);
        etiquetaImagen = new Label();
        etiquetaImagen.setGraphic(new ImageView(img));
        etiquetaImagen.setTooltip(new Tooltip("Una etiqueta con una imagen..."));
        */

        Button buttonsing = new Button("SING");
        buttonsing.setOnAction(event);
        buttonsing.setPrefSize(200, 40);
        GridPane.setMargin(buttonsing, new Insets(180, 0, 0, 150));
        gridPane.add(buttonsing, 3, 1);

                lastscene(stage);
            }
        };
        buttonsing.setOnAction(event1);

        /*AudioClip buzzer = new AudioClip(getClass().getResource("/descargas/LAsound.mp3").toExternalForm()) {
            @Override
            public void play() {
            }
            @Override
            public void loop() {
            }
            @Override
            public void stop() {
            }
        };
        buttonsing.setOnAction(event ->{
            buzzer.play();
        });*/

        buttonsing.setPrefSize(200, 40);
        GridPane gridPane = new GridPane();
        gridPane.setMargin(buttonsing, new Insets(180, 0, 0, 150));
        gridPane.add(buttonsing, 3, 1);


        BorderPane border = new BorderPane();
        border.setCenter(gridPane);
        Scene scene = new Scene(border, 960, 540);
        stage.setScene(scene);
        stage.show();
    }

    private void secondscene(Stage stage){
        //Crear aqui segunda escena
        BorderPane border = new BorderPane();
        Button buttonchange = new Button("TEST");
        Mixer.Info[] infos = AudioSystem.getMixerInfo(); //tenemos instancias de los dispositivos de audio instalados en el pc.
        LinkedList<Mixer.Info> infos_2 = new LinkedList<>();
        for(Mixer.Info info: infos) {
            if (info.getName().startsWith("Port") == false){
                infos_2.add(info);
            }
        }

        ChoiceBox deviceSelection = new ChoiceBox();
        deviceSelection.setPrefSize(200, 40);
        deviceSelection.getItems().addAll(infos_2);
        deviceSelection.setValue(infos_2.getFirst()); //by default the first MIDI device.
        border.setCenter(deviceSelection);

        deviceSelection.setOnAction((event) -> {
            int selectedIndex = deviceSelection.getSelectionModel().getSelectedIndex();
            Object selectedItem = deviceSelection.getSelectionModel().getSelectedItem();

            System.out.println("Selection made: [" + selectedIndex + "] " + selectedItem);
            System.out.println("   ChoiceBox.getValue(): " + deviceSelection.getValue());

            try {
                TargetDataLine mic = AudioSystem.getTargetDataLine(new
                        AudioFormat(44100, 16, 1, true, true), infos_2.get(selectedIndex));
                System.out.println("Device works correctly!!!!");
            }catch(Exception e){
                System.out.println(e);
            }
        });



        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                thirdscene(stage);
            }
        };

        buttonchange.setOnAction(event);
        buttonchange.setPrefSize(200, 40);
        border.setTop(buttonchange);
        Scene scene = new Scene(border, 960, 540);
        stage.setScene(scene);
        stage.show();
    }


    private  HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        StackPane stack = new StackPane();
        Text title = new Text("Music Tune Education");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        title.setTextAlignment(TextAlignment.CENTER);
        hbox.setMargin(title, new Insets(0, 0, 0, 350));
        hbox.getChildren().add(title);

        Rectangle helpIcon = new Rectangle(30.0, 25.0);
        helpIcon.setFill(new LinearGradient(0,0,0,1, true, CycleMethod.NO_CYCLE,
                new Stop[]{
                        new Stop(0, Color.web("#4977A3")),
                        new Stop(0.5, Color.web("#B0C6DA")),
                        new Stop(1,Color.web("#9CB6CF")),}));
        helpIcon.setStroke(Color.web("#D0E6FA"));
        helpIcon.setArcHeight(3.5);
        helpIcon.setArcWidth(3.5);

        EventHandler<ActionEvent> helpevent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                Alert helpalert = new Alert(Alert.AlertType.INFORMATION);
                helpalert.setTitle("INFORMATION");
                helpalert.setHeaderText("\t\tSOFTWARE DOCUMENTATION");
                helpalert.setContentText("1.First Steps");
                helpalert.showAndWait();
            }
        };
        Button helpButton = new Button("?");
        helpButton.setPrefSize(29, 23);
        helpButton.setOnAction(helpevent);

        stack.getChildren().addAll(helpIcon, helpButton);
        stack.setAlignment(Pos.CENTER_RIGHT);     // Right-justify nodes in stack
        StackPane.setMargin(helpButton, new Insets(1, 1, 0, 0));

        hbox.getChildren().add(stack);            // Add to HBox from Example 1-2
        HBox.setHgrow(stack, Priority.ALWAYS);    // Give stack any extra space

        return hbox;
    }

    private void firstScene(Stage stage){
        BorderPane border = new BorderPane();
        HBox hbox = addHBox();
        border.setTop(hbox);

        BorderPane gridborder = new BorderPane();
        border.setCenter(gridborder);
        GridPane gridPane = new GridPane();
        HBox hboxdesc = new HBox();
        StackPane stack = new StackPane();
        Text description = new Text("Description");
        description.setTextAlignment(TextAlignment.CENTER);
        hboxdesc.setMargin(description, new Insets(20, 0, 0, 200));
        hboxdesc.getChildren().add(description);
        gridborder.setTop(hboxdesc);

        ChoiceBox levelselect = new ChoiceBox();
        levelselect.setPrefSize(200, 40);
        levelselect.getItems().addAll("Level 1", "Level 2", "Level 3");
        levelselect.setValue("Level 1");
        ChoiceBox rangeselect = new ChoiceBox();
        rangeselect.setPrefSize(200, 40);
        rangeselect.getItems().addAll("Bajo", "Contralto", "Tenor", "Bajo");
        rangeselect.setValue("Bajo");
        Button buttonstart = new Button("START");

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                secondscene(stage);
            }
        };

        buttonstart.setOnAction(event);
        buttonstart.setPrefSize(200, 40);

        GridPane.setMargin(levelselect, new Insets(180, 0, 0, 80));
        GridPane.setMargin(rangeselect, new Insets(180, 0, 0, 40));
        GridPane.setMargin(buttonstart, new Insets(180, 0, 0, 150));

        gridPane.add(levelselect, 1, 1);
        gridPane.add(rangeselect, 2,1);
        gridPane.add(buttonstart, 3, 1);

        gridborder.setCenter(gridPane);

        Scene scene = new Scene(border, 960, 540);
        stage.setTitle("Music Tune education!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void start(Stage stage) throws IOException {
        firstScene(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}