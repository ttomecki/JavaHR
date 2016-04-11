package pl.jcommerce.javahr;

import org.junit.Assert;
import org.junit.Test;


public class PersonValidatorTest {

	
	@Test
	public void testValidateOK() {
		Person p = new Person("TEST", "TEST");
		p.setGender("MALE");
		PersonValidator pv = new PersonValidator();
		Assert.assertTrue(pv.validate(p));
	}
	
	@Test
	public void testValidateEmptyName() {
		Person p = new Person(null, "TEST");
		PersonValidator pv = new PersonValidator();
		Assert.assertFalse(pv.validate(p));
	}
}
