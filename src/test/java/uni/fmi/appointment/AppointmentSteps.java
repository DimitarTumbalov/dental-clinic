package uni.fmi.appointment;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uni.fmi.appointment.model.AppointmentScreenModel;
import uni.fmi.models.User;

public class AppointmentSteps {
	private AppointmentScreenModel appointmentModel;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
	
	@Given("^Човекът отваря екрана за запазване на час$")
	public void openAppointmentScreen() throws Throwable {
		appointmentModel = new AppointmentScreenModel();
	}

	@Given("^Потребителят е влязал в акаунта си$")
	public void потревбителят_е_влязал_в_акаунта_си() throws Throwable {
	    appointmentModel.setCreator(new User());
	}
	
	@When("^Въведе име: \"([^\"]*)\"$")
	public void addFirstName(final String firstName) throws Throwable {
		appointmentModel.setFirstName(firstName);
	}

	@When("^Въведе фамилия: \"([^\"]*)\"$")
	public void addLastName(final String lastName) throws Throwable {
	    appointmentModel.setLastName(lastName);
	}

	@When("^Въведе email: \"([^\"]*)\"$")
	public void addEmail(final String email) throws Throwable {
		appointmentModel.setEmail(email);
	}

	@When("^Въведе телефонен номер: \"([^\"]*)\"$")
	public void addPhoneNumber(String phoneNumber) throws Throwable {
		appointmentModel.setPhoneNumber(phoneNumber);
	}
	
	@When("^Избере час: \"([^\"]*)\"$")
	public void addPeriod(final String time) throws Throwable {
		try {
			LocalDateTime t = LocalDateTime.parse(time, formatter);
			appointmentModel.setTime(t);
		}catch(Exception i) {
			appointmentModel.setTime(LocalDateTime.of(1, 1, 1, 1, 1));
		}
	}

	@When("^Натисне бутона за запазване на час$")
	public void clickSaveButton() throws Throwable {
		appointmentModel.clickSaveButton();
	}
	
	@Then("^Вижда съобщение: \"([^\"]*)\"$")
	public void checkMessage(final String message) throws Throwable {
	    assertEquals(message, appointmentModel.getMessage());
	}
}
