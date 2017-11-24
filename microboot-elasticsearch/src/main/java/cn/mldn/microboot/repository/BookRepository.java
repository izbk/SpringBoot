package cn.mldn.microboot.repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;

import cn.mldn.microboot.entity.Book;

public interface BookRepository extends ElasticsearchRepository<Book, String> {

    Page<Book> findByAuthor(String author, Pageable pageable);

    List<Book> findByTitle(String title);

    List<Book> findByAuthorAndTitle(String author, String title);
    
    List<Book> findByTitleLike(String title);

    // Enables the distinct flag for the query
    List<Book> findDistinctBookByAuthorOrTitle(String author, String title);
    List<Book> findPeopleDistinctByAuthorOrTitle(String author, String title);

    // Enabling ignoring case for an individual property
    List<Book> findByAuthorIgnoreCase(String author);
    // Enabling ignoring case for all suitable properties
    List<Book> findByAuthorAndTitleAllIgnoreCase(String author, String title);

    // Enabling static ORDER BY for a query
    List<Book> findByAuthorOrderByTitleAsc(String author);
    List<Book> findByAuthorOrderByTitleDesc(String author);
    
    //Using Pageable, Slice and Sort in query methods
    Page<Book> findByLastname(String lastname, Pageable pageable);
    List<Book> findByLastname(String lastname, Sort sort);

    //Limiting the result size of a query with Top and First
    Page<Book> queryFirst10ByLastname(String lastname, Pageable pageable);
    Slice<Book> findTop3ByLastname(String lastname, Pageable pageable);
    List<Book> findFirst10ByLastname(String lastname, Sort sort);
    List<Book> findTop10ByLastname(String lastname, Pageable pageable);
    
    @Query("select u from Book u")
    Stream<Book> findAllByCustomQueryAndStream();
    Stream<Book> readAllByAuthorNotNull();
    @Query("select u from Book u")
    Stream<Book> streamAllPaged(Pageable pageable);

    //Use java.util.concurrent.Future as return type.
    @Async
    Future<Book> findByAuthor(String author);
    //Use a Java 8 java.util.concurrent.CompletableFuture as return type
    @Async
    CompletableFuture<Book> findOneByAuthor(String author); 
    //Use a org.springframework.util.concurrent.ListenableFuture as return type
    @Async
    ListenableFuture<Book> findOneByTitle(String title); 
    
}