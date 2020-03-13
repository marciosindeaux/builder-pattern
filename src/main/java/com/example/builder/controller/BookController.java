package com.example.builder.controller;

import com.example.builder.Service.BookService;
import com.example.builder.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("all")
    public ResponseEntity getAll(){
        ResponseEntity response;
        try{
            response = new ResponseEntity(bookService.getAllBooks(), HttpStatus.OK);
        }catch ( Exception e){
            response = new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping("{id}")
    public ResponseEntity getById(@PathVariable("id") Long id){
        ResponseEntity responseEntity;
         try {
             responseEntity = new ResponseEntity(bookService.getById(id), HttpStatus.OK);
         } catch (NoSuchElementException e){
             responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
         } catch (Exception e) {
             responseEntity = new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
         }
         return responseEntity;
    }

    @PostMapping
    public ResponseEntity saveNew(@RequestBody Book book){
        try {
            bookService.save(book);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
