package uni.fmi;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import uni.fmi.models.Appointment;
import uni.fmi.models.DateTimePeriod;
import uni.fmi.models.Patient;
import uni.fmi.models.Role;
import uni.fmi.models.TimePeriod;
import uni.fmi.models.User;

public class TestSet {
	@Test
	public void testSetWithAppointments() {
		final Set<Appointment> testInstance = new HashSet<Appointment>();
		LocalDateTime now = LocalDateTime.now();
		testInstance.add(new Appointment(new User(), new Patient(), now));
		testInstance.add(new Appointment(new User(), new Patient(), now));
		assertEquals(1, testInstance.size());
	}

	@Test
	public void testSetWithPatients() {
		final Set<Patient> testInstance = new HashSet<Patient>();
		testInstance.add(new Patient("dimitrov@abv.bg", "0878999564", null , null));
		testInstance.add(new Patient("dimitrov@abv.bg", "0878982321", null, null));
		testInstance.add(new Patient("joro@abv.bg", "0878982321", null, null));
		assertEquals(2, testInstance.size());
	}
	
	@Test
	public void testSetWithTimePeriods() {
		final Set<TimePeriod> testInstance = new HashSet<TimePeriod>();
		testInstance.add(new TimePeriod(LocalTime.of(1,0), LocalTime.of(2,0)));
		testInstance.add(new TimePeriod(LocalTime.of(1,0), LocalTime.of(2,0)));
		testInstance.add(new TimePeriod(LocalTime.of(1,0), LocalTime.of(2,1)));
		assertEquals(2, testInstance.size());
	}
	
	@Test
	public void testSetWithDateTimePeriods() {
		final Set<DateTimePeriod> testInstance = new HashSet<DateTimePeriod>();
		testInstance.add(new DateTimePeriod(LocalDateTime.of(1, 1, 1, 1, 0), LocalDateTime.of(1, 1, 1, 2, 0)));
		testInstance.add(new DateTimePeriod(LocalDateTime.of(1, 1, 1, 1, 0), LocalDateTime.of(1, 1, 1, 2, 0)));
		testInstance.add(new DateTimePeriod(LocalDateTime.of(1, 1, 1, 1, 0), LocalDateTime.of(1, 1, 1, 2, 1)));
		assertEquals(2, testInstance.size());
	}
	
	@Test
	public void testSetWithUsers() {
		final Set<User> testInstance = new HashSet<User>();
		testInstance.add(new User("dimitar", null, null, null, "Mitko", null));
		testInstance.add(new User("dimitar", null, null, null, "Dimitar", null));
		testInstance.add(new User("dimitar2", null, null, null, null, null));
		assertEquals(2, testInstance.size());
	}
	
	@Test
	public void testSetWithRoles() {
		final Set<Role> testInstance = new HashSet<Role>();
		testInstance.add(new Role(0, "Admin"));
		testInstance.add(new Role(0, "Member"));
		testInstance.add(new Role(1, "Admin"));
		assertEquals(2, testInstance.size());
	}
}
