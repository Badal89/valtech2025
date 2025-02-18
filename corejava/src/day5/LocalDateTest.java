package day5;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

class LocalDateTest {
	@Test
	void testDateTime() {
		
		LocalDateTime independenceday=LocalDateTime.of(1947,8,15,9,15,10);
		System.out.println(independenceday);
	}

	@Test
	void test() {
		LocalDate independenceday=LocalDate.of(1947,8,15);
		System.out.println(independenceday);
		LocalDate preindependenceday=independenceday.minusDays(1);
		System.out.println(preindependenceday);
		LocalDate postindependenceday=independenceday.plusDays(1);
		System.out.println(postindependenceday);
		
		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println(dtf.format(independenceday));
		System.out.println(LocalDate.parse("1947-08-15"));
	}

}
