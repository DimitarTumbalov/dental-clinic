package uni.fmi;
import static org.junit.Assert.assertEquals;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

import uni.fmi.models.Role;

public class TestSet {
	
	@Test
	public void testSetWithStrings() {
		final Set<String> testInstance = new HashSet<String>();
		String value1 = "value";
		testInstance.add(value1);
		
		String value2 = "value";
		testInstance.add(value2);
		
		String value3 = "value3";
		testInstance.add(value3);
		
		assertEquals(2, testInstance.size());
	}
	
	@Test
	public void testSetWIthRoles() {
		final Set<Role> testInstance = new HashSet<Role>();
		Role value1 = new Role();
		value1.setName("Dentist");
		testInstance.add(value1);
		
		Role value2 = new Role();
		value2.setName("Receptionist");
		testInstance.add(value2);
		
		Role value3 = new Role();
		value3.setName("Dentist");
		testInstance.add(value3);
		
		assertEquals(2, testInstance.size());
	}
}
