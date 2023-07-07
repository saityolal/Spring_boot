package springboot.aop;

import java.lang.reflect.Array;
import java.util.List;

public class Account {

    private String name;

    private String level;

    public Account(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public Account() {
        System.out.println("\n Account Constructor has been initiated");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
