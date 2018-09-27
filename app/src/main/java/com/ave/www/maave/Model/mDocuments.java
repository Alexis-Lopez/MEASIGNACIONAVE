package com.ave.www.maave.Model;

/**
 * Created by trini on 25/05/18.
 */

public class mDocuments {

    private String title;
    private String URL;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public mDocuments(String title, String URL) {
        this.title = title;
        this.URL = URL;
    }
}
