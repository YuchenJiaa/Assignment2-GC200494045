package com.example.assignment2gc200494045;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

public class SearchViewController implements Initializable {

    @FXML
    private ListView<Book> bookListView;

    @FXML
    private Label booksFoundLabel;

    @FXML
    private Button moreInfoButton;

    @FXML
    private Label remindLabel;

    @FXML
    private HBox resultsBox;

    @FXML
    private TextField searchTextField;

    @FXML
    void search(ActionEvent event) throws IOException, InterruptedException {
        APIUtility.getBooksFromNYT(searchTextField.getText());
        APIResponse apiResponse = APIUtility.getBooksFromFile();
        //show the number of books in the label
        if (apiResponse.getNum_results()==0)
        {
            resultsBox.setVisible(false);
        }
        else
        {
            resultsBox.setVisible(true);
        }
        booksFoundLabel.setVisible(true);
        bookListView.getItems().clear();
        bookListView.getItems().addAll(apiResponse.getBooks());
        Collections.sort(bookListView.getItems());
        updateLabels();
    }

//    @FXML
//    private void search() throws IOException, InterruptedException {
//        APIUtility.getBooksFromNYT(searchTextField.getText());
//        APIResponse apiResponse = APIUtility.getBooksFromFile();
//        bookListView.getItems().addAll(apiResponse.getResults());
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        resultsBox.setVisible(false);
        booksFoundLabel.setVisible(false);
    }

    private void updateLabels(){
        booksFoundLabel.setText("Books found: "+ bookListView.getItems().size());
    }
}



