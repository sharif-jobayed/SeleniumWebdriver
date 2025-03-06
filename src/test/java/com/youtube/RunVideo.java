package com.youtube;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RunVideo {

    private WebDriver driver;
    private WebDriverWait xWait;
    private Actions getActions;
    private WebElement playerControlPanel;
    private WebElement playBtn;
    private By currentPlayTime;

    public RunVideo() {

    }

    @BeforeMethod()
    public void setUp() {
        this.driver = new ChromeDriver();
        this.xWait = new WebDriverWait(this.driver, Duration.ofSeconds(1000));
        this.getActions = new Actions(this.driver);

        this.driver.manage().window().setSize(new Dimension(1440, 900));
        this.driver.get("https://youtu.be/uf5-OsAoAAQ?si=Bvb_UWVzjiVFgFKH");
    }

    @Test()
    public void runVideo() {
        this.playerControlPanel = this.driver.findElement(By.xpath("//div[@class='ytp-chrome-controls']"));
        this.playBtn = this.driver.findElement(By.xpath("//button[contains(@class,'ytp-play-button')]"));
        this.currentPlayTime = By.xpath("//span[@class='ytp-time-current']");

        try {
            this.playBtn.click();
            Boolean timeLimit = this.xWait.until(ExpectedConditions.textToBe(this.currentPlayTime, "0:10"));
            if(this.playerControlPanel.isDisplayed() && timeLimit) {
                this.tearDown();
            } else {
                this.getActions.moveToElement(this.playerControlPanel);
                this.tearDown();
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @AfterMethod()
    public void tearDown() {
        if (driver != null) {
            this.driver.quit();
        }
    }

}
