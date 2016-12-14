package com.example;

import java.util.Objects;

/**
 * Created by LunaFlores on 12/14/16.
 */
public class Foo2 {
    private int num;
    private String name;
    private boolean bool;

    public Foo2() {
        super();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    @Override
    public boolean equals(Object o){

        if(o == this) return true;
        if(!(o instanceof Foo2)){
            return false;
        }

        Foo2 foo2 = (Foo2) o;
        return num == foo2.num &&
                Objects.equals(name,foo2.name) &&
                bool == foo2.bool;
    }

    @Override
    public int hashCode(){
        return Objects.hash(num, name, bool);
    }
}
