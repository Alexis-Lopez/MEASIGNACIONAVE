package com.ave.www.maave.WebServices;

import java.util.HashMap;

/**
 * Created by trini on 16/05/18.
 */

public class HttpRequestLogin {

    private HashMap<String, String> session;

    public HttpRequestLogin(String email, String password) {
        session = new HashMap<>();
        session.put("email", email);
        session.put("password", password);
    }

    public HashMap<String, String> getSession() {
        return session;
    }

    public void setSession(HashMap<String, String> session) {
        this.session = session;

    }

}
