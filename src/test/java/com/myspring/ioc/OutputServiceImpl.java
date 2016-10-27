package com.myspring.ioc;

/**
 * Created by shulin on 16/10/21.
 */
public class OutputServiceImpl implements OutputService {
    private String name;

    private HelloWorldServiceImpl helloWorldService;

    @Override
    public void modifyName() {
        helloWorldService.setName(name);
    }

    @Override
    public void say() {
//        helloWorldService.sayHello();
        System.out.println("OutputServiceImpl");
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
