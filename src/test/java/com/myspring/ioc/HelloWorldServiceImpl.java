package com.myspring.ioc;

/**
 * Created by shulin on 16/10/20.
 */
public class HelloWorldServiceImpl implements HelloWorldService{
    private String name;
    private String word;
    private OutputService outputService;

    public void sayHello() {
//        System.out.println(name + "对着大伙说：" + word);
        //必须用注入的对象调用方法的时候，AOP才会发生。如果这里的只是输出sysout，那么AOP不会切入
        outputService.say();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
