package org.example;

import java.sql.SQLOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String a = "abc";
        String b = new String("abc");
        String c = "a" + "b" + "c";

        System.out.println(a == b);//false
        System.out.println(a.equals(b));//true
        System.out.println(a == c);//true
    }
}