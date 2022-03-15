package com.company;

import java.util.ArrayList;
import java.util.List;

public class NameList {
    List<String> names;
    public NameList() {
        this.names = new ArrayList<String>();
    }
    public void add(String name) {
        names.add(name);
    }
    public String toString() {
        return names.toString();
    }
}
