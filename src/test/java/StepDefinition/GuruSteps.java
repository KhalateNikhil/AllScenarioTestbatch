package StepDefinition;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import BaseLayer.BaseClass;
import PageLayer.ResgisterPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class GuruSteps extends BaseClass {

	private static ResgisterPage registerpage;

	@Given("user is on register page")
	public void user_is_on_register_page() {
		BaseClass.initialization();
		String url1 = prop.getProperty("url");
		driver.get(url1);
	}

	@When("user enter firstname,lastname,phone and email")
	public void user_enter_firstname_lastname_phone_and_email() {
		registerpage = new ResgisterPage();
		registerpage.validatContactInfo("Nikhil", "Khalate", "7383873", "nsk@gamil.com");

	}

	@When("user enter {string}, {string}, {string}, {string} and {string}")
	public void user_enter_and(String Add, String City, String State, String postalcode, String country) {
		registerpage.validatemailinginfo(Add, City, State, postalcode, country);
	}

	@When("user enter username, password, confirmpassword and click on submit button")
	public void user_enter_username_password_confirmpassword_and_click_on_submit_button(DataTable dataTable) {

		List<List<String>> ls = dataTable.asLists();
		String username = ls.get(0).get(0);

		String password = ls.get(0).get(1);
		String cpassword = ls.get(0).get(2);

		registerpage.validateUserInfo(username, password, cpassword);
	}

	@AfterStep
	public void tearDown(Scenario scenario)  {
		if (scenario.isFailed()) {
			byte[] f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			String date = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());

			scenario.attach(f, "image/png", date+scenario.getName());
		}
		else
		{
			byte[] f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			String date = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());

			scenario.attach(f, "image/png", date+scenario.getName());
		}
	}

}
