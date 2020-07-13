package com.example.web.model;

import java.util.Date;

public class BookModel {
    private int id;
    private String reader;
    private String author;
    private String bookName;
    private Date targetDate;
    //private boolean isDone;

    public BookModel(int id, String reader, String author,String bookName, Date targetDate) {
        super();
        this.id = id;
        this.reader = reader;
        this.bookName = bookName;
        this.author = author;
        this.targetDate = targetDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BookModel newObj = (BookModel) obj;
        if (id != newObj.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format(
                "BookModel [id=%s, reader=%s, author=%s, bookName=%s, targetDate=%s]", id,
                reader, author, bookName, targetDate);
    }

}