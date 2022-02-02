package validation;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class test {
	@Test
	public void validate_card_number() {
		final boolean expected = true;
		
		final boolean actual = Cardvalidation.isValidNumber(379354508162306);
		assertEquals(actual, expected);
	}
	
	@Test
	public void validate_cvv() {
		final boolean expected = true;
		
		final boolean actual = Cardvalidation.isValidCVV("561");
		assertEquals(actual, expected);
	}
}

