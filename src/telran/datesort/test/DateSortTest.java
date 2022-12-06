package telran.datesort.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateSortTest {
	Comparator<String> comparator;

	@BeforeEach
	void setUp() throws Exception {
		comparator = (s1, s2) -> {
			if (Integer.parseInt(s1.substring(6, 10)) < Integer.parseInt(s2.substring(6, 10))) {
				return -1;

			} else if (Integer.parseInt(s1.substring(6, 10)) > Integer.parseInt(s2.substring(6, 10))) { //years
				return 1;
				
			} else if (Integer.parseInt(s1.substring(3, 4)) < Integer.parseInt(s2.substring(3, 4))) { 
				return -1;
				
			} else if (Integer.parseInt(s1.substring(3, 4)) > Integer.parseInt(s2.substring(3, 4))) {//months
				return 1;
				
			} else if (Integer.parseInt(s1.substring(0, 1)) < Integer.parseInt(s2.substring(0, 1))) { 
				return -1;
				
			} else if (Integer.parseInt(s1.substring(0, 1)) > Integer.parseInt(s2.substring(0, 1))) {//days
				return 1;
			}
			return 0;
		};
	}

	@Test
	void dateSortTest() {
		String[] dates = { "07-05-1990", "28-01-2010", "11-08-1990", "15-01-2010", "16-06-1970" };
		String[] expected = { "16-06-1970", "07-05-1990", "11-08-1990", "15-01-2010", "28-01-2010" };
		Arrays.sort(dates, comparator);
		assertArrayEquals(expected, dates);
	}

}
