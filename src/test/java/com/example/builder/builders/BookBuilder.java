package com.example.builder.builders;

import com.example.builder.entity.Book;

public class BookBuilder {

    private Book book;

    private BookBuilder(Book book){
        this.book = book;
    }

    public static BookBuilder oneBook(){
        return new BookBuilder(new Book());
    }

    public BookBuilder withId(Long id){
        book.setId(id);
        return this;
    }

    public BookBuilder withName(String name){
        book.setName(name);
        return this;
    }

    public BookBuilder withAuthor(String author){
        book.setAuthor(author);
        return this;
    }

    public BookBuilder withNumberPages(Long numberPages){
        book.setNumberPages(numberPages);
        return this;
    }

    public Book now(){
        return this.book;
    }

}
