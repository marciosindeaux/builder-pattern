package com.example.builder.persistence;

import com.example.builder.builders.BookBuilder;
import com.example.builder.entity.Book;
import com.example.builder.repository.BookRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersistenceTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void persistNewBook(){
        Book book  = BookBuilder.oneBook()
                .withNumberPages(220L)
                .withAuthor("Jules Verne")
                .withName("Around the World in Eighty Days")
                .now();
        book = repository.saveAndFlush(book);
        Assert.assertNotNull(book.getId());
    }

}
