package com.example.rufflez.myapplication;

/**
 * Created by rufflez on 10/4/15.
 */
public class VersionModel {
    public String name;
    public static final String[] data = {
            "cupcake", "donut", "eclair", "froyo", "gingerbread",
            "honeycomb", "ice cream sandwich", "jelly bean", "kit kat",
            "Lollipop", "marshmallow"
    };
    VersionModel(String name){
        this.name = name;
    }
}
