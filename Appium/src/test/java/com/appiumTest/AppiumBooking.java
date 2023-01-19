package com.appiumTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBooking {

    public static AppiumDriver<MobileElement> driver;

    public static void main(String[] args){
        //appiumTest1();

    }

    @Test
    public  void appiumTest1(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","android");
        caps.setCapability("platformVersion","11");
        caps.setCapability("deviceName","pixel-device");
        //caps.setCapability("udid","emulator-5554");
        caps.setCapability("automationName","uiAutomator2");
        caps.setCapability("appPackage","com.android.contacts");
        caps.setCapability("appActivity","com.android.contacts.activities.PeopleActivity");

        //hide keyboard
        caps.setCapability("unicodeKeyboard",true);
        caps.setCapability("resetKeyboard",true);

        try {

            URL url = new URL("http://127.0.0.1:4723/wd/hub/");

            driver = new AppiumDriver<MobileElement>(url,caps);

            //add a some waits
            WebDriverWait wait = new WebDriverWait(driver,10);

            //add a new contact button
            WebElement addContactButton = driver.findElementById("com.android.contacts:id/floating_action_button");
            addContactButton.click();

            //add a  some waits
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.contacts:id/left_button")));

            WebElement cancelButton = driver.findElementById("com.android.contacts:id/left_button");
            cancelButton.click();

            WebDriverWait waitt = new WebDriverWait(driver,5);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.contacts:id/account_name")));

            //formulario
            WebElement firstNameEditBox = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[1]");
            firstNameEditBox.click();
            firstNameEditBox.sendKeys("bryan");

            WebElement LastNameEditBox = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[2]");
            LastNameEditBox.click();
            LastNameEditBox.sendKeys("vasquez");

            WebElement phoneNumberEditBox = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText");
            phoneNumberEditBox.click();
            phoneNumberEditBox.sendKeys("965280478");

            WebElement saveButton = driver.findElementById("com.android.contacts:id/editor_menu_save_button");
            saveButton.click();



           //com.android.contacts:id/text

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }
}
