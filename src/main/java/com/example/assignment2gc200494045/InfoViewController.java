package com.example.assignment2gc200494045;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InfoViewController implements Initializable {

    public String author = "";
    @FXML
    private Label moreInfoLabel;

    @FXML
    private Label titleLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    /**
     * when users click back button, it will call the changeToFirstScene() method to go back
     */
    @FXML
    private void getBack(ActionEvent event) throws IOException, InterruptedException {
        SceneChanger.changeToFirstScene(event, "search-view.fxml", author);
    }
    /**
     * This method set text for the second view
     */
    public void getBookInfo( String url, String publication_dt, String byline, String book_title,
                             String book_author, String uuid, String uri, String summary)
    {
        titleLabel.setText(publication_dt+" - "+book_title);
        moreInfoLabel.setText("Url: "+url+"\n"+"\n"+"Byline: "+byline+"\n"+"\n"+"Book author: "+book_author+
                "\n"+"\n"+"Uuid: "+uuid+"\n"+"\n"+"Uri: "+uri+"\n"+"\n"+"Summary: "+summary);
        author = book_author;
    }}




