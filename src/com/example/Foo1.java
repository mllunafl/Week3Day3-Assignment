package com.example;

/**
 * Created by LunaFlores on 12/14/16.
 */
public class Foo1 {
    private int num;
    private String name;
    private boolean bool;

    public Foo1() {
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
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Foo1)) {
            return false;
        }

        Foo1 foo1 = (Foo1) o;

        return foo1.name.equals(name) &&
                foo1.num == num &&
                foo1.bool == bool;
   }

   @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + num;
        result = 31 * result + name.hashCode();
        result = 31 * result + (bool ? 1 : 0);
        return result;
   }
}
