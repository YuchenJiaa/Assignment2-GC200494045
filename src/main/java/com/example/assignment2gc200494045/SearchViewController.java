package com.example.assignment2gc200494045;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SearchViewController {

    @FXML
    private ListView<Book> bookListView;

    @FXML
    private TextField searchTextField;

    @FXML
    private void search() throws IOException, InterruptedException {
        APIUtility.getBooksFromNYT(searchTextField.getText());
        APIResponse apiResponse = APIUtility.getBooksFromFile();
        bookListView.getItems().addAll(apiResponse.getResults());
    }

}

