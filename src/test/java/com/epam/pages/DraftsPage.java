package com.epam.pages;

import com.epam.base.BaseClass;
import com.epam.base.SetProperties;
import com.epam.base.TimeOut;
import com.epam.base.WaitTool;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DraftsPage {

    SetProperties setProperties = new SetProperties();
    public static WebDriver driver = new BaseClass().initDriver();
    WaitTool waitTool = new WaitTool();
    TimeOut timeout = new TimeOut();
    //private final String CONST = "const xpath";


    public void setUserName(String userName) {
        driver.get(setProperties.getUrl());
        WebElement login = driver.findElement(new By.ByXPath("//input[@name='login']"));
        login.sendKeys(userName);
    }

    public void setPassword(String passw) {
        WebElement password = driver.findElement(new By.ByXPath("//input[@name='passwd']"));
        password.sendKeys((passw));
    }

    public void clickSubmit() {
        WebElement submit = driver.findElement(new By.ByXPath("//button[@type='submit']"));
        submit.click();
    }

    public void doLogin() {
        this.setUserName(setProperties.getUserName());
        this.setPassword(setProperties.getPassw());
        this.clickSubmit();
    }

    public void clickCreateNewMail() {
        WebElement createMail = driver.findElement(new By.ByXPath("//a[@data-key='view=toolbar-button-compose-go&id=compose-go']"));
        createMail.click();
    }

    public void setToAdress() {
        WebElement sendTo = driver.findElement(new By.ByXPath("//*[@class='js-compose-field mail-Bubbles']"));
        sendTo.click();
        sendTo.sendKeys(setProperties.getToAdress());
        timeout.sleep(2);
    }

    public void setMailSubject() {
        WebElement subject = driver.findElement(new By.ByXPath("//*[@class='mail-Compose-Field-Input-Controller js-compose-field js-editor-tabfocus-prev']"));
        subject.click();
        subject.sendKeys(setProperties.getSubj());
        timeout.sleep(2);
    }

    public void setMailBody() {
        WebElement mailBody = driver.findElement(new By.ByXPath("//*[@id='cke_1_contents']"));
        mailBody.click();
        mailBody.sendKeys(setProperties.getMessage());
        timeout.sleep(4);

    }

//    public void clickSendButton() {
//        WebElement sendButton = driver.findElement(new By.ByXPath("//button[@type='submit']"));
//        sendButton.click();
//    }

    public void clickPopUpSaveChanges() {
        WebElement popupSaveButton = driver.findElement(new By.ByXPath("//button[@data-action='save']"));
        popupSaveButton.click();
        timeout.sleep(2);
    }

    public void clickDraftLink() {
        WebElement draftLink = driver.findElement(new By.ByXPath("//a[@data-key='view=folder&fid=6']"));
        draftLink.click();
    }

    public void goDraft() {
        this.doLogin();
        waitTool.waitForElementPresent(driver, new By.ByXPath("//*[@class='mail-User-Name']"), 5);
        this.clickCreateNewMail();
        timeout.sleep(6);
        this.setToAdress();
        timeout.sleep(6);
        this.setMailSubject();
        timeout.sleep(6);
        this.setMailBody();
        timeout.sleep(1);
        this.clickDraftLink();
        timeout.sleep(1);
        this.clickPopUpSaveChanges();
        timeout.sleep(6);
    }


//    public boolean messageIsInDraft() {
//        try {
//            WebElement element = driver.findElement(new By.ByXPath("//span[@title='sent via WebDriver']"));
//            return true;
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//    }

    public void openDraftMessage() {
        WebElement draftMessage = driver.findElement(new By.ByXPath("//span[@title='sent via WebDriver']"));
        draftMessage.click();
        timeout.sleep(6);
    }

    public String getDraftContentTo() {
        WebElement toAdress = driver.findElement(new By.ByXPath("//span[@data-contact-email='biddeford@yandex.by']"));
        return toAdress.getText();
    }

    public String getDraftContentSubject() {
        String subject = driver.findElement(new By.ByXPath("//input[@name='subj']")).getText();
        return subject;
    }

    public String getMailBody() {
        WebElement mailBody = driver.findElement(new By.ByXPath("//div[@id='cke_57_contents']/*[descendant::div]//text()"));
        return mailBody.getText();
    }

    public void sendTheMail() {
        WebElement sendButton = driver.findElement(new By.ByXPath("//button[@id='nb-20']"));
        sendButton.click();
    }

    public boolean verifyDisappFromDrafts() {
        try {
            WebElement element = driver.findElement(new By.ByXPath("//span[@title='sent via WebDriver']"));
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    public void clickOnSentMail() {
        WebElement sentLink = driver.findElement(new By.ByXPath("//*[@class='svgicon svgicon-mail--Folder_sent mail-NestedList-Item-Icon']"));
        sentLink.click();

    }

    public boolean verifyMessageIsInSent() {
        try {
            WebElement element = driver.findElement(new By.ByXPath("//span[@title='sent via WebDriver']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void doLogOff() {
        WebElement userPict = driver.findElement(new By.ByXPath("//*[@class='mail-User-Name']"));
        userPict.click();
        WebElement exitButton = driver.findElement(new By.ByXPath("//*[@data-click-action='common.exitAll']"));
        exitButton.click();
    }

}

