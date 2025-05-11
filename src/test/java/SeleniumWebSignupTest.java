import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;


public class SeleniumWebSignupTest {

    //import the selenium WebDriver
    private WebDriver driver;

   @BeforeTest
   public void start() throws InterruptedException {
       //locate where the chromedriver is
       System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
       //1. Open your Chrome browser
       driver = new ChromeDriver();
       //2. Input your Selenium Demo Page URL (https://selenium-blog.herokuapp.com)
       driver.get("https://selenium-blog.herokuapp.com");
       //Test 1: Verify that user input the right url and on the right webpage
       if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
           //Pass
           System.out.println("Correct Webpage") ;
       else
       //Fail
           System.out.println("Wrong Webpage") ;
       Thread.sleep(5000);
       //Test2: Verify that when user clicks on the Signup button,the user is redirected to the Signup page
       String expectedPageurl = "https://selenium-blog.herokuapp.com/signup";
       String actualPageurl = driver.getCurrentUrl();
       if(actualPageurl.contains(expectedPageurl))
           //Pass
           System.out.println("Signup page opened") ;
       else
           //Fail
           System.out.println("Signup page not opened") ;
       //3. Maximize the browser
       driver.manage().window().maximize();
       //4. Click on Signup button to open the Signup page
       driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();


   }

    @Test (priority = 0)
            public void negativeSignup() throws InterruptedException {
       // 5.Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("ruth8");
        // Test3: Verify that user cannot signup with username less than 3 characters
        String shortUsername = "ru";
        // less than 3 characters
        String validEmail = "ruth8@malinator.com";// reuse the variable without 'String'
        String validPassword = "7654321"; // reuse the variable without 'String'
        String expectedurl = "https://selenium-blog.herokuapp.com/users.5358";// reuse the variable without 'String'
        String actualurl = driver.getCurrentUrl(); // reuse the variable without 'String'
        if(actualurl.contains(expectedurl))
            //Pass
            System.out.println("User could not sign up with short username") ;
        else
            //Fail
            System.out.println("User was able to sign up with short username") ;
        //6. Locate the email address field and Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("ruth8@malinator.com");
        // Test4 : Verify that user cannot signup with invalid email
        String Username = "ruth8";// reuse the variable without 'String'
        String invalidEmail = "ruth.com";
        validPassword = "7654321";
        expectedurl = "https://selenium-blog.herokuapp.com/users.5358";
        // reuse the variable without 'String'
        actualurl = driver.getCurrentUrl();
        if(actualurl.contains(expectedurl))
            //Pass
            System.out.println("User could not sign up with invalid email") ;
        else
            //Fail
            System.out.println("User was able to sign up with invalid email") ;
        //7. Locate the password field and Input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("7654321");
        // Test5: Verify that user cannot sign up with password less or equal to one character
        Username = "ruth8";
        validEmail = "ruth8@malinator.com";
        String invalidPassword = "5";
        // less or equal to one character
        expectedurl = "https://selenium-blog.herokuapp.com/users.5358";
        actualurl = driver.getCurrentUrl();
        if(actualurl.contains(expectedurl))
            //Pass
            System.out.println("User could not sign up with invalid password") ;
        else
            //Fail
            System.out.println("User was able to sign up with invalid password") ;
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void positiveSignup() throws InterruptedException {
       //Test6: Verify that user is successfully signed up when valid details are inputted
        String Username = "ruth8";
        String validEmail = "ruth8@malinator.com";
        String validPassword = "7654321";
        String expectedUrl = "https://selenium-blog.herokuapp.com/users.5358";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("User was able to sign up with valid credentials") ;
        else
            //Fail
            System.out.println("User could not sign up with valid credentials") ;
        //8. Click on the signup button

    }
    @Test (priority = 2)
            public void clickMeaghan() throws InterruptedException {
        //9. Click on meaghan line on the list page
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        //Test 7:Verify that Meaghan item is present on the item list page
        String expectedPageUrl = "https://selenium-blog.herokuapp.com/users.5367";
        String actualPageUrl = driver.getCurrentUrl();
        if(actualPageUrl.contains(expectedPageUrl))
        //Pass
        System.out.println("Correct All users page") ;
        else
        //Fail
        System.out.println("Wrong All users page") ;
        Thread.sleep(5000);
    }

    @Test (priority = 3)
            public void verifyItem() throws InterruptedException {
    //10.Search for an item (using Python with Selenium) and confirm it is present
    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[1]/a")).click();
    //Test 8: Verify that the item searched for on the all user page is present
    String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
    String actualPageUrl = driver.getCurrentUrl();
        if(actualPageUrl.contains(expectedPageUrl))
            //Pass
            System.out.println("Correct all user page") ;
        else
            //Fail
            System.out.println("Wrong all user page") ;
        Thread.sleep(5000);

    }

    @Test (priority = 4 )
    public void logoutSuccessfully() {
       //11.click on logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        //Test 11: Verify that when the user logout, he/she is directed to the home page
        String expectedTitle = "Alpha blog";
        String actualTitle = driver.getTitle();
        String expectedUrl = "https://selenium-blog.herokuapp.com/";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("Correct Webpage") ;
        else
            //Fail
            System.out.println("Wrong Webpage") ;
    }

    @AfterTest
    public void closeBrowser () {
       driver.quit();


   }
}




