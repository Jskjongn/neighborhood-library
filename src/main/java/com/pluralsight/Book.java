package com.pluralsight;

public class Book {

    // properties of a book
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public Book(int id, String isbn, String title) {
        // gets values from constructor
        this.id = id;
        this.isbn = isbn;
        this.title = title;

        // gives these properties default values
        this.setCheckedOut(false);
        this.setCheckedOutTo("");
    }


    public void checkOut(String name){
        // checked out becomes true and takes the name of who checked it out
        this.setCheckedOut(true);
        this.setCheckedOutTo(name);
    }

    public void checkIn(){
        // checked out becomes false and clears name
        this.setCheckedOut(false);
        this.setCheckedOutTo("");
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }
}
