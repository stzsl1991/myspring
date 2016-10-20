package com.myspring.ioc;

/**
 * Created by shulin on 16/10/20.
 */
public class HelloWorldService {
    private String name;
    private String word;

    public void sayHello() {
        System.out.println(name + "对着大伙说：" + word);
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
