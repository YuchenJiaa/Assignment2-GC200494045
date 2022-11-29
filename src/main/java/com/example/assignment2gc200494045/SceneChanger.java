package com.example.assignment2gc200494045;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {
    //This method can make the first scene change to the second scene when event happens
    public static void changeToSecondScene(ActionEvent event,String fxmlFileName,String url, String publication_dt,
                                    String byline, String book_title, String book_author, String uuid,
                                    String uri, String summary) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFileName));
        Scene scene = new Scene(fxmlLoader.load());

        InfoViewController controller = fxmlLoader.getController();

        controller.getBookInfo(url, publication_dt, byline, book_title, book_author, uuid, uri, summary);

        //get the Stage object from the ActionEvent
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }
    //This method can make the second scene back to the first scene when event happens
    public static void changeToFirstScene(ActionEvent event, String fxmlFileName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFileName));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }
}
