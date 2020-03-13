package com.example.builder.repository;

import com.example.builder.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByNumberPagesOrderByName(Long qtdPaginas);
}
