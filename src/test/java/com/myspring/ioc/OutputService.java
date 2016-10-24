package com.myspring.ioc;

/**
 * Created by shulin on 16/10/21.
 */
public class OutputService {
    private String name;

    private HelloWorldServiceImpl helloWorldService;

    public void modifyName(){
        helloWorldService.setName(name);
    }

    public void say(){
        helloWorldService.sayHello();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HelloWorldServiceImpl getHelloWorldService() {
        return helloWorldService;
    }

    public void setHelloWorldService(HelloWorldServiceImpl helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}
