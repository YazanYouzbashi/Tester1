package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Test2 {

	Teesorte tee;
	
	@BeforeEach
	void setUp() throws Exception {
	
		tee = new Teesorte(123, "Pfeffermintze", "Pfefferminze","nein", new String [] {"keine"});
	
	}

	@AfterEach
	void tearDown() throws Exception {
		tee = null;

	
	}

	@Test
	void test() {
		assertThrows(IllegalArgumentException.class ,()-> new Teesorte(4231, "Pfeffermintze", "Pfefferminze", "nein", null));
	}

}
