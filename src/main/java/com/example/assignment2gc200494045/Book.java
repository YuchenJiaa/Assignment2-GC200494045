package com.example.assignment2gc200494045;

public class Book implements Comparable<Book>{
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

    //make the book sort by publication date, if the date is same then sort by title
    @Override
    public int compareTo(Book otherBook) {
        if(this.publication_dt.compareTo(otherBook.publication_dt)==0){
            return this.book_title.compareTo(otherBook.book_title);
        }
        else
            return -(this.publication_dt.compareTo(otherBook.publication_dt));

    }

    public String getUrl() {
        return url;
    }

    public String getPublication_dt() {
        return publication_dt;
    }

    public String getByline() {
        return byline;
    }

    public String getBook_title() {
        return book_title;
    }

    public String getBook_author() {
        return book_author;
    }

    public String getUuid() {
        return uuid;
    }

    public String getUri() {
        return uri;
    }

    public String getSummary() {
        return summary;
    }
}
