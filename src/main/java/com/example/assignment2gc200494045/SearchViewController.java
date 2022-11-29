package com.example.assignment2gc200494045;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private ImageView arrowImageView;
    //when click details button, use the changeToSecondScene method to switch the scene
    @FXML
    void getDetails(ActionEvent event) throws IOException {
        Book booksSelected = bookListView.getSelectionModel().getSelectedItem();
        SceneChanger.changeToSecondScene(event, "info-view.fxml", booksSelected.getUrl(),booksSelected.getPublication_dt(),
                booksSelected.getByline(),booksSelected.getBook_title(),booksSelected.getBook_author(),booksSelected.getUuid(),
                booksSelected.getUri(),booksSelected.getSummary());
    }
    //when click search button, API is called and returns a JSON file.
    //Then it is parsed and displayed as Nook objects in the ListView
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
            arrowImageView.setImage(new Image(Main.class
                    .getResourceAsStream("images/arrowReminder.png")));
        }

        booksFoundLabel.setVisible(true);
        bookListView.getItems().clear();
        bookListView.getItems().addAll(apiResponse.getBooks());
        Collections.sort(bookListView.getItems());
        updateLabels();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        resultsBox.setVisible(false);
        booksFoundLabel.setVisible(false);
    }
    //calculate the number of books results
    private void updateLabels(){
        booksFoundLabel.setText("Books found: "+ bookListView.getItems().size());
    }
}



