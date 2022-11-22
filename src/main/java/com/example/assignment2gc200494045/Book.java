package com.example.assignment2gc200494045;

public class Book {
//just make what you want to show on the view, I don't need to declare all
    private String url;
    private String publication_dt;
    private String byline;
    private String book_title;
    private String book_author;
    private String uuid;
    private String uri;
    private String summary;

    public String toString()
    {
        return String.format("%s-%s",publication_dt,book_title);
    }

}
