package com.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
/*
 * 
 * How To Implement Keyset Pagination With "Next Page" Button In Spring Boot

Description: When we rely on an offset paging we have the performance penalty induced by throwing away n records before reached the desired offset. Larger n leads to a significant performance penalty. When we have a large n is better to rely on keyset pagination which maintain a "constant" time for large datasets. In order to understand how bad offset can perform please check this article:

Screenshot from that article (offset pagination): 

Need to know if there are more records?
By its nature, keyset doesn't use a SELECT COUNT to fetch the number of total records. But, we a little tweak we can easily say if there are more records, therefore to show a button of type Next Page:

public AuthorView fetchNextPage(long id, int limit) {
     List<Author> authors = authorRepository.fetchAll(id, limit + 1);

     if (authors.size() == (limit + 1)) {
          authors.remove(authors.size() - 1);
          return new AuthorView(authors, true);
     }

     return new AuthorView(authors, false);
}

Or, like this (rely on Author.toString() method):

public Map<List<Author>, Boolean> fetchNextPage(long id, int limit) {
     List<Author> authors = authorRepository.fetchAll(id, limit + 1);

     if(authors.size() == (limit + 1)) {
          authors.remove(authors.size() -1);
          return Collections.singletonMap(authors, true);
     }

     return Collections.singletonMap(authors, false);
}

A Previous Page button can be implemented easily based on the first record.

Key points:
- choose the column(s) to act as the latest visited record (e.g., id)
- use the column(s) in the WHERE and ORDER BY clauses of your SQL

Sample:



 * 
 * 
 */
