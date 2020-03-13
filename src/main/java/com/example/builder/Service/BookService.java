package com.example.builder.Service;

import com.example.builder.entity.Book;
import com.example.builder.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getById(Long id){
        return bookRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void deleteById(Long id){
        bookRepository.deleteById(id);
    }

    public Book save(Book book){
        return bookRepository.saveAndFlush(book);
    }

}
