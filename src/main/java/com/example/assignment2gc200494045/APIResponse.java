package com.example.assignment2gc200494045;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class APIResponse {

    private String status;
    private String copyright;
    private int num_results;
    private Book[] results;

    public Book[] getResults() {
        return results;
    }

    public List<Book> getBooks(){
        return Arrays.asList(results);
    }

    public String getStatus() {
        return status;
    }

    public String getCopyright() {
        return copyright;
    }

    public int getNum_results() {
        return num_results;
    }
}
