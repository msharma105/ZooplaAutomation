package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;

public class AgentDetailsPage extends BaseClass {

	public static String agentNamePrePage;
	public static String agentNameNextPage;
	@FindBy(xpath = "//div[@class='dp-sidebar-wrapper__contact']//h4[@class='ui-agent__name']")
	static WebElement agentDetail1;
	@FindBy(xpath = "//h1[@class='bottom-half']//b[1]")
	static WebElement agentDetail2;

	public AgentDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	public static void AgentNameClick() {
		agentNamePrePage = agentDetail1.getText();
		agentDetail1.click();

		agentNameNextPage = agentDetail2.getText();
	}

}
