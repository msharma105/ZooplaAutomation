package Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.AgentDetailsPage;
import Pages.HotelListPage;
import Pages.SignInPage;

public class AgentDetailsPageTest extends BaseClass {

	SignInPage signInPage;

	public AgentDetailsPageTest() throws IOException {
		loadProperties();

	}

	@BeforeTest
	public void requiredMethodCalls() {
		BaseClass.Initialization();
		signInPage = new SignInPage();
		SignInPage.search();
		HotelListPage.getHotelPrice();
		AgentDetailsPage.AgentNameClick();
	}

	@Test
	public void comapreAgentName() {
		{
			Assert.assertEquals(AgentDetailsPage.agentNameNextPage, AgentDetailsPage.agentNamePrePage);
			System.out.println("Broker name is same");
		}

	}
}
