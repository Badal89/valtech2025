package day5;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

class DateTimeTest {

	@Test
	void test() throws ParseException {
		Date now =new Date();
		System.out.println(now);
		Date independenceday=new Date(47,7,15);
		System.out.println(independenceday);
		
//		yyyy->year  yy
//		MM->numeric MMM->alpha
//		dd->day
//		hour->hh
//		minute->mm
//		second->ss
		
		DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		System.out.println(df.format(independenceday));
		
		Date republicDay=df.parse("26-01-1950");
		System.out.println(republicDay);
		
	}

}
