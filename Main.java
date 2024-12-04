import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\intan\\Downloads\\chromedriver-win64\\chromedriver.exe");
		
	WebDriver driver = new ChromeDriver();
	try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(2000); //2 detik (in millisecs)
		
		//  log in
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		
		username.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		Thread.sleep(2000);
		loginbutton.click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("btn_inventory")));
		List<WebElement> addToCartButton = driver.findElements(By.className("btn_inventory"));
		Random random = new Random();
		int randomProduct = random.nextInt(addToCartButton.size());
		addToCartButton.get(randomProduct).click();
		Thread.sleep(2000);
		
		WebElement cart = driver.findElement(By.id("shopping_cart_container"));
		cart.click();
		Thread.sleep(2000);
		
		WebElement cartItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item_name")));
		
		System.out.println("Item sucessfully added to cart" + cartItem.getText());
		
		// check out
					WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout")));
					checkoutButton.click();
					Thread.sleep(2000);

					// mengisi detail checkout
					WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
					WebElement lastname = driver.findElement(By.id("last-name"));
					WebElement postalCode = driver.findElement(By.id("postal-code"));

					firstName.sendKeys("John");
					lastname.sendKeys("Doe");
					postalCode.sendKeys("12345");
					
			WebElement continueBtn = driver.findElement(By.id("continue")); 
			continueBtn.click();
			Thread.sleep(2000); 
			
			//log out
			WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-menu-btn")));
			menuButton.click();
			
			Thread.sleep(2000);
			WebElement logoutLink = driver.findElement(By.id("logou_sidebar_link"));
			logoutLink.click();
		
	}catch (InterruptedException e ) {
		e.printStackTrace();
	}finally {
		driver.quit();
	}
	}

}

