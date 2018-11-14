package com.yy.provider1;

public class CompareMockSpy {
    public void fun(int a){
        fun1(a);
        fun2(a);
    }

    public void fun1(int b){
        System.out.println(b);
    }

    private void fun2(int c){
        System.out.println(c+100);
    }

    public int getValue(){
        return 10;
    }

}
