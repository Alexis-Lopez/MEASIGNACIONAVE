package com.ave.www.maave.Model;

/**
 * Created by trini on 9/04/18.
 */

public class mdDetailsQuestion {
    private Integer id;
    private String question;
    private String Respues1;
    private String Respues2;
    private String Respues3;

    public mdDetailsQuestion(String question, String respues1, String respues2, String respues3) {
        this.question = question;
        Respues1 = respues1;
        Respues2 = respues2;
        Respues3 = respues3;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRespues1() {
        return Respues1;
    }

    public void setRespues1(String respues1) {
        Respues1 = respues1;
    }

    public String getRespues2() {
        return Respues2;
    }

    public void setRespues2(String respues2) {
        Respues2 = respues2;
    }

    public String getRespues3() {
        return Respues3;
    }

    public void setRespues3(String respues3) {
        Respues3 = respues3;
    }
}
