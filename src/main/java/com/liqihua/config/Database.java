package com.liqihua.config;

import java.util.List;

public class Database {

    private String name;
    private String url;
    private String username;
    private String password;
    private String driveClassName;
    private List<Database> slaves;



    public Database() {
    }

    public Database(String name, String url, String username, String password, String driveClassName) {
        this.name = name;
        this.url = url;
        this.username = username;
        this.password = password;
        this.driveClassName = driveClassName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriveClassName() {
        return driveClassName;
    }

    public void setDriveClassName(String driveClassName) {
        this.driveClassName = driveClassName;
    }

    public List<Database> getSlaves() {
        return slaves;
    }

    public void setSlaves(List<Database> slaves) {
        this.slaves = slaves;
    }

    @Override
    public String toString() {
        return "Database{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", driveClassName='" + driveClassName + '\'' +
                ", slaves=" + slaves +
                '}';
    }
}
