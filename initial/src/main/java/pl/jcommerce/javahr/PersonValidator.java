package pl.jcommerce.javahr;

public class PersonValidator {

	public boolean validate(Person p) {
		return !isNullOrEmpty(p.getFirstName()) 
				&& !isNullOrEmpty(p.getName()) 
				&& !isNullOrEmpty(p.getGender());
		
	}
	
	private boolean isNullOrEmpty(String s) {
		return s == null || s.equals("");
	}

}
