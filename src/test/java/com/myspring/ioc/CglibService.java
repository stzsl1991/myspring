package com.myspring.ioc;

/**
 * Created by shulin on 16/10/27.
 */
public class CglibService {
    private String name;

    public void say(){
        System.out.println("我叫："+name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
