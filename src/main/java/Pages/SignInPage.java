package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;

public class SignInPage extends BaseClass {
	@FindBy(id = "search-input-location")
	static WebElement searchField;
	@FindBy(id = "search-submit")
	static WebElement searchButton;

	public SignInPage() {
		PageFactory.initElements(driver, this);
	}

	public static HotelListPage search() {
		searchField.sendKeys("London");
		searchButton.click();
		return new HotelListPage();
	}

}
