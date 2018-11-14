package com.yy.provider1;

public interface UseDao {
    Integer save(String name);


    default void successSave() {
        System.out.println("这是UseDao的default方法,成功保存");
    }

}
