package com.epam.base;


public class SetProperties {

    private String NAME = "webdriver.gecko.driver";
    private String PATH = "resource\\geckodriver-v0.13.0-win64\\geckodriver.exe";
    private String URL = "https://mail.yandex.by/";
    private String USERNAME = "testtask28";
    private String PASSW = "testtask28testtask28";
    private String TOADRESS = "emartu@yandex.ru";
    private String SUBJ = "sent via WebDriver";
    private String MESSAGE = "Test message ... ";
    private String CONTENTTO = "emartu";
    private String CONTENTSUBJ = "sent";

    public String getCONTENTTO() {
        return CONTENTTO;
    }

    public String getCONTENTSUBJ() {
        return CONTENTSUBJ;
    }

    public SetProperties() {
    }

    public void setSystemProperty() {
        System.setProperty(NAME, PATH);
    }

    public String getUrl() {
        return this.URL;
    }

    public void setUrlValue(String URLVALUE) {
        this.URL = URLVALUE;
    }

    public String getUserName() {
        return this.USERNAME;
    }

    public void setUserName(String USERNAMEVALUE) {
        this.USERNAME = USERNAMEVALUE;
    }

    public String getPassw() {
        return this.PASSW = PASSW;
    }

    public void setPassw(String PASSWVALUE) {
        this.PASSW = PASSWVALUE;
    }

    public String getToAdress() {
        return this.TOADRESS = TOADRESS;
    }

    public void setToAdress(String TOADRESSVALUE) {
        this.TOADRESS = TOADRESSVALUE;
    }

    public String getSubj() {
        return this.SUBJ = SUBJ;
    }

    public void setSubj(String SUBJVALUE) {
        this.SUBJ = SUBJVALUE;
    }

    public String getMessage() {
        return this.MESSAGE = MESSAGE;
    }

    public void setMessage(String MESSAGEVALUE) {
        this.MESSAGE = MESSAGEVALUE;
    }


}
