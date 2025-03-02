package com.valtech.training.first.services;

import java.util.List;
import java.util.Optional;

import com.valtech.training.first.dtos.BookInfoDTO;
import com.valtech.training.first.entities.Book;


public interface BookService {
	


    List<Book> findAll();  // Get all books

    List<Book> getBooksByYearBetween(int i, int j);

  List<Book> getBooksByPriceGreaterThan(int i);
  List<Integer> findAllPriceByAuthorsId(long id);
  List<BookInfoDTO> getBookInfoByAuthor(long id);


    

}
