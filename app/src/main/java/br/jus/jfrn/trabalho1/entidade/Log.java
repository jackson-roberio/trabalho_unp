package br.jus.jfrn.trabalho1.entidade;

import java.util.Calendar;

public class Log {

    private Long id;
    private Calendar data;
    private String login;
    private boolean logou;

    public Log() {}

    public Log (String login, boolean logou){
        this.login = login;
        this.logou = logou;
        data = Calendar.getInstance();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isLogou() {
        return logou;
    }

    public void setLogou(boolean logou) {
        this.logou = logou;
    }
}
