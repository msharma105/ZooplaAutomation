package Pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base.BaseClass;

public class HotelListPage extends BaseClass {

	static List<Integer> reverselist = new ArrayList<Integer>();
	@FindBy(xpath = "//ul[@class='listing-results clearfix js-gtm-list']//div[2]//a[@class='listing-results-price text-price']")
	static List<WebElement> priceList;
	@FindBy(xpath = "//button[@class='btn']")
	static WebElement popup;

	public HotelListPage() {
		PageFactory.initElements(driver, this);
	}

	public static AgentDetailsPage getHotelPrice() {

		//Loop to get price in int from webelements
		for (int i = 1; i < priceList.size(); i++) {
			if (!priceList.get(i).getText().equals("POA")) {

				reverselist.add(
						Integer.valueOf(priceList.get(i).getText().split(" ")[0].substring(1).replaceAll(",", "")));
			}
		}
		
		//Reverse sort
		Collections.sort(reverselist, Collections.reverseOrder());

		//Print all the values in sorted order(Reverse sorted)
		for (int i = 1; i < reverselist.size(); i++) {

			System.out.println(reverselist.get(i));
		}
		
		int desiredPropValue = reverselist.get(5);
		int desiredElementIndex = 0;
		for (int i = 0; i < priceList.size(); i++) {
			if (priceList.get(i).getText().contains(desiredPropValue + "")) {
				desiredElementIndex = i;
			}
		}
		WebElement desiredElement = priceList.get(desiredElementIndex);
		
		
		popup.click();
		desiredElement.click();
		return new AgentDetailsPage();

	}

}
