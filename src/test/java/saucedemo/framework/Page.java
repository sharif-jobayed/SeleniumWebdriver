package saucedemo.framework;

import saucedemo.framework.utils.DataConverter;

public abstract class Page {
    public static void main(String[] args) {
        DataConverter dc = new DataConverter();

        System.out.println(dc.getAppData().getBaseURL());
        System.out.println(dc.getUserCreds().getErrorUser().getUserName());
    }
}
