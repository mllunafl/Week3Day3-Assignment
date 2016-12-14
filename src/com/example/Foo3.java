package com.example;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by LunaFlores on 12/14/16.
 */
public class Foo3 {
    private int num;
    private String name;
    private boolean bool;

    public Foo3() {
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

        if (o == this) return true;
        if (!(o instanceof Foo3)){
            return false;
        }
        Foo3 foo3 = (Foo3) o;

        return new EqualsBuilder()
                .append(num, foo3.num)
                .append(name, foo3.name)
                .append(bool, foo3.bool)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17,37)
                .append(num)
                .append(name)
                .append(bool)
                .toHashCode();
    }
}
