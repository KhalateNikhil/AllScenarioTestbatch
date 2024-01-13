package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilityLayer.HandleDropDown;
import UtilityLayer.Wait;

public class ResgisterPage extends BaseClass {

	// create object repository by using @FindBy annotation

	@FindBy(name = "firstName")
	private WebElement fname;

	@FindBy(name = "lastName")
	private WebElement lname;

	@FindBy(name = "phone")
	private WebElement phone;

	@FindBy(name = "userName")
	private WebElement email;

	@FindBy(name = "address1")
	private WebElement add;

	@FindBy(name = "city")
	private WebElement city;

	@FindBy(name = "state")
	private WebElement state;

	@FindBy(name = "postalCode")
	private WebElement pcode;

	@FindBy(name = "country")
	private WebElement country;

	@FindBy(name = "email")
	private WebElement usname;

	@FindBy(name = "password")
	private WebElement pass;

	@FindBy(name = "confirmPassword")
	private WebElement cpass;

	@FindBy(name = "submit")
	private WebElement submit;

	// initialize OR by using PageFactory.initElement method in constructor

	public ResgisterPage() {
		PageFactory.initElements(driver, this);
	}

	// create associated methods

	public void validatContactInfo(String firstname, String lastname, String phnno, String Email) {
		Wait.sendKeys(fname, firstname);
		Wait.sendKeys(lname, lastname);
		Wait.sendKeys(phone, phnno);
		Wait.sendKeys(email, Email);

	}

	public void validatemailinginfo(String Adress, String City, String State, String Pcode, String Country) {
		Wait.sendKeys(add, Adress);
		Wait.sendKeys(city, City);
		Wait.sendKeys(state, State);
		Wait.sendKeys(pcode, Pcode);
		HandleDropDown.selectByVisibleText(country, Country);
	}

	public void validateUserInfo(String username, String password, String confirmpass) {
		Wait.sendKeys(usname, username);
		Wait.sendKeys(pass, password);
		Wait.sendKeys(cpass, confirmpass);
		Wait.click(submit);
	}

}
