package com.valtech.training.first.repos;
import com.valtech.training.first.dtos.BookInfoDTO;
import com.valtech.training.first.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
	List<Book> findAllByName(String name);
	
	List<Book> findAllByYearBetween(int min,int max);
	List<Book> findAllByPriceGreaterThan(int price);
	List<Book> findAllByAuthorsId(long authorId);
	
	@Query("SELECT b.price FROM Book b JOIN b.authors a WHERE a.id = ?1")
	List<Integer> findAllPriceByAuthorsId(long id);
	@Query("SELECT new com.valtech.training.first.dtos.BookInfoDTO(b.publisher.name,b.price) FROM Book b JOIN b.authors a WHERE a.id = ?1")
	List<BookInfoDTO> getBookInfoByAuthor(long id);
//	Creating the class here for simplicity otherwise should be a part of another package
	
	
}
