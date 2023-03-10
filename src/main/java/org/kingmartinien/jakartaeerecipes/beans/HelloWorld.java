package org.kingmartinien.jakartaeerecipes.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class HelloWorld {
    private String hello = "Hello World KING!";

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
