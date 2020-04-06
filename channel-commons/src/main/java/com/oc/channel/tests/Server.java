package com.oc.channel.tests;


/**
 * Created by tigershome on 2020/4/3.
 */
public class Server {

    private String hostname;

    private int port;

    public Server(){}

    public Server(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
