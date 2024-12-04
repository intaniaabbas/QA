package latihan;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Latihan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\intan\\Downloads\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			
			driver.get("https://www.demoblaze.com/index.html");
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("hrefch")));
			List<WebElement> randomproduct = driver.findElements(By.className("hrefch"));
			Random random = new Random();
			int randomproductadd = random.nextInt(randomproduct.size());
			randomproduct.get(randomproductadd).click();
			Thread.sleep(2000);
			
//			 WebElement samsungGalaxyS6Link = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Samsung galaxy s6")));
//		        samsungGalaxyS6Link.click();

		    //# 3. Click on "Add to cart" button
		     WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add to cart")));
		        addToCartButton.click();
		        Thread.sleep(2000);
		        
		     // Click on cart button
		        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cartur")));
		        cartButton.click();
		        Thread.sleep(2000);

		        // Click on place order button
		        WebElement placeOrderButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-success")));
		        placeOrderButton.click();
		        Thread.sleep(2000);

		        // Input all necessary data
		        WebElement nameInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("name")));
		        nameInput.sendKeys("John Doe");
		        Thread.sleep(2000);

		        WebElement countryInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("country")));
		        countryInput.sendKeys("USA");

		        WebElement cityInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("city")));
		        cityInput.sendKeys("New York");

		        WebElement creditCardNumberInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("card")));
		        creditCardNumberInput.sendKeys("1234-5678-9012-3456");
		        Thread.sleep(2000);

		        WebElement monthInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("month")));
		        monthInput.sendKeys("12");
		        Thread.sleep(2000);

		        WebElement yearInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("year")));
		        yearInput.sendKeys("2025");
		        Thread.sleep(2000);
		        
		        WebElement purchasebtn = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-primary")));
		  		purchasebtn.click();
		  		Thread.sleep(2000);
		  		
		}catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
//			driver.quit();
		

	}

}
}
