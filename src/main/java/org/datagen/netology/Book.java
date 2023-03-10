package org.datagen.netology;

public class Book {
    String title;
    int releaseYear;
    Author author;
    int pages;

    public Book(String title, int releaseYear, Author author, int pages) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.author = author;
        this.pages = pages;
    }

    public boolean isBig(){
        return this.pages < 500;
    }

    public boolean matches(String word){
        return word.contains(this.author.name) ||
                word.contains(this.author.surname) ||
                word.contains(this.title);
    }
    public int estimatePrice(){
        return (int) Math.floor(3 * this.pages * Math.sqrt(this.author.rating));
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", author=" + author +
                ", pages=" + pages +
                '}';
    }
}
