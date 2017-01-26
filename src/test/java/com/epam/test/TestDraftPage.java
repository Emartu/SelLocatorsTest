package com.epam.test;

import com.epam.base.SetProperties;
import com.epam.pages.DraftsPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestDraftPage {
    DraftsPage objDraftPage;

    @BeforeClass
    public void setup() {
        new SetProperties().setSystemProperty();
    }

    @AfterClass
    public void closeBrowser() {
        DraftsPage.driver.quit();
    }


    @Test(description = "verifies the draft content - To")
    public void draftContentToCheck() {
        objDraftPage = new DraftsPage();
        objDraftPage.doLogin();
        objDraftPage.goDraft();
        objDraftPage.openDraftMessage();
        Assert.assertTrue(true, String.valueOf(objDraftPage.getDraftContentTo().contains("emartu")));
    }

    @Test(description = "verifies the draft content - Subject")
    public void draftContentSubjCheck() {
        objDraftPage = new DraftsPage();
        objDraftPage.goDraft();
        objDraftPage.openDraftMessage();
        Assert.assertTrue(true, String.valueOf(objDraftPage.getDraftContentSubject().contains("sent")));
    }

    @Test(description = "verifies the draft content - body message")
    public void draftContentBodyCheck() {
        objDraftPage = new DraftsPage();
        objDraftPage.goDraft();
        objDraftPage.openDraftMessage();
        Assert.assertEquals(objDraftPage.getMailBody(), "Test message ... ", "Draft Message: mail body is not valid ...");
    }

    @Test(description = "verifies the a message disappears from Draft folder")
    public void disappearedFromDraftCheck() {
        objDraftPage = new DraftsPage();
        objDraftPage.goDraft();
        objDraftPage.openDraftMessage();
        objDraftPage.sendTheMail();
        Assert.assertTrue(objDraftPage.verifyDisappFromDrafts(), "Message is not disappeared from Drafts folder ... ");
    }

    @Test
    public void isMessageSent() {
        objDraftPage = new DraftsPage();
        objDraftPage.doLogin();
        objDraftPage.goDraft();
        objDraftPage.openDraftMessage();
        objDraftPage.sendTheMail();
        objDraftPage.clickOnSentMail();
        Assert.assertTrue(objDraftPage.verifyMessageIsInSent(), "Message is not sent ... ");
    }
}
