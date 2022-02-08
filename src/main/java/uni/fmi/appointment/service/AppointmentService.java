package uni.fmi.appointment.service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import uni.fmi.models.Appointment;
import uni.fmi.models.Calendar;
import uni.fmi.models.DateTimePeriod;
import uni.fmi.models.Patient;
import uni.fmi.models.TimePeriod;
import uni.fmi.models.User;

public class AppointmentService {
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	public static final Pattern VALID_BULGARIAN_PHONE_NUMBER_REGEX = Pattern.compile("^\\+?(359|0)8[789][0-9](|-| )[0-9]{3}(|-| )[0-9]{3}$", Pattern.CASE_INSENSITIVE);
	public static final Pattern VALID_NAME_REGEX = Pattern.compile("^[a-zA-Z\\u0080-\\u9fff'-]{2,20}$", Pattern.CASE_INSENSITIVE);
	
	private static List<Appointment> appointmentsDb = new ArrayList<>();
	
	private static TimePeriod workingHours11 = new TimePeriod(LocalTime.of(8, 0), LocalTime.of(12, 0));
	private static TimePeriod workingHours12 = new TimePeriod(LocalTime.of(13, 0), LocalTime.of(17, 0));
	
	private static TimePeriod workingHours21 = new TimePeriod(LocalTime.of(9, 30), LocalTime.of(13, 30));
	private static TimePeriod workingHours22 = new TimePeriod(LocalTime.of(14, 30), LocalTime.of(18, 30));
	
	private static TimePeriod workingHours31 = new TimePeriod(LocalTime.of(10, 0), LocalTime.of(13, 0));
	private static TimePeriod workingHours32 = new TimePeriod(LocalTime.of(14, 0), LocalTime.of(19, 0));
	
	private static Map<DayOfWeek, Set<TimePeriod>> workSchedule = Map.of(
			DayOfWeek.MONDAY, Set.of(workingHours11, workingHours12), // MONDAY: 08:00 - 12:00 and 13:00 - 17:00
			DayOfWeek.TUESDAY, Set.of(workingHours11, workingHours12), // TUESDAY: 08:00 - 12:00 and 13:00 - 17:00
			DayOfWeek.WEDNESDAY, Set.of(workingHours21, workingHours22), // WEDNESDAY: 09:30 - 13:30 and 14:30 - 18:30
			DayOfWeek.THURSDAY, Set.of(workingHours11, workingHours12), // THURSDAY: 08:00 - 12:00 and 13:00 - 17:00
			DayOfWeek.FRIDAY, Set.of(workingHours31, workingHours32) // FRIDAY: 10:00 - 13:00 and 14:00 - 19:00
	);
	
	private static Set<DateTimePeriod> holidays = Set.of(
			new DateTimePeriod(LocalDateTime.of(2022, 3, 1, 0, 0), LocalDateTime.of(2022, 3, 15, 0, 0)), // Holiday from 01.03 to 15.03 in 2022
			new DateTimePeriod(LocalDateTime.of(2022, 5, 27, 0, 0), LocalDateTime.of(2022, 3, 28, 0, 0)) // Holiday on the 27 of March in 2022
	);
	
	private static Calendar calendar = new Calendar(workSchedule, holidays);

	public static String appointment(User creator, Patient patient, LocalDateTime time) {
		intDb();
		
		// Check if Email is valid
		if(!isEmailValid(patient.getEmail()))
			return "Невалиден имейл адрес";
		
		// Check if Phone number is valid
		if(!isPhoneNumberValid(patient.getPhoneNumber()))
			return "Невалиден телефонен номер";
		
		// Check if First name is valid
		if(!isNameValid(patient.getFirstName()))
			return "Невалидно първо име";
		
		// Check if Last name is valid
		if(!isNameValid(patient.getLastName()))
			return "Невалидна фамилия";
		
		LocalDateTime now = LocalDateTime.now();
		LocalTime appointmentTime = time.toLocalTime();
		DayOfWeek appointmentDay = time.getDayOfWeek();

		if(time.isBefore(now) || time.isAfter(now.plusYears(2))){ // Check if the year is valid
			return "Невалиден час";
		}
		else if(appointmentsDb.stream().anyMatch(a -> time.isAfter(a.getTime().minusSeconds(1)) && time.isBefore(a.getTime().plusMinutes(30)))){ // Check if an appointment in this time frame already exists
			return "Часът е зает";
		}
		else if(calendar.getHolidays().stream().anyMatch(h -> time.isAfter(h.getStart().minusSeconds(1)) && time.isBefore(h.getEnd()))){ // Check if the clinic will be working
			return "Кабинетът ще бъде затворен";
		}else{
			Set<TimePeriod> workingHours = calendar.getWorkSchedule().get(appointmentDay);
			
			// Check if the appointment is within working hours
			if(workingHours != null && workingHours.stream().anyMatch(wh -> appointmentTime.isAfter(wh.getStart().minusSeconds(1)) && appointmentTime.isBefore(wh.getEnd().minusMinutes(29)))) {
				if(creator != null) {
					appointmentsDb.add(new Appointment(creator, patient, time));
					return "Часът е запазен успешно";
				} else
					return "Беше ви изпратен линк за потвърждение на часа на вашия имейл адрес";	
			} else
				return "Кабинетът няма да работи в този час";
		}
	}

	private static boolean isEmailValid(String email) {
		final Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
		return matcher.find();
	}
	
	private static boolean isPhoneNumberValid(String phoneNumber) {
		final Matcher matcher = VALID_BULGARIAN_PHONE_NUMBER_REGEX.matcher(phoneNumber);
		return matcher.find();
	}
	
	private static boolean isNameValid(String name) {
		final Matcher matcher = VALID_NAME_REGEX.matcher(name);
		return matcher.find();
	}
	
	private static void intDb() {
		appointmentsDb.clear();
		appointmentsDb.add(
			new Appointment(null, new Patient("petrov@abv.bg", "0878595877", "Petar", "Petrov"), LocalDateTime.of(2022, 5, 5, 14, 0)) // 05.05 TUESDAY: 14:00
		);
	}
	
}
