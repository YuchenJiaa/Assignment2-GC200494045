package com.example.assignment2gc200494045;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InfoViewController implements Initializable {

    @FXML
    private Label moreInfoLabel;

    @FXML
    private Label titleLabel;

    @FXML
    void getBack(ActionEvent event) throws IOException {
        SceneChanger.changeToFirstScene(event, "search-view.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void getBookInfo( String url, String publication_dt, String byline, String book_title,
                             String book_author, String uuid, String uri, String summary)
    {
        titleLabel.setText(publication_dt+" - "+book_title);
        moreInfoLabel.setText("Url: "+url+"\n"+"Byline: "+byline+"\n"+"Book author: "+book_author+
                "\n"+"Uuid: "+uuid+"\n"+"Uri: "+uri+"\n"+"Summary: "+summary);
    }

}



