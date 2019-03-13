package com.yy.provider1.enumtest;

/**
 * Created by yuyi on 2019/1/25.
 */

public enum UnionpayEnums {
    WEIRENZHENG(1, "0、未认证；", 16, -1, 0),
    ONCETIME(2, "上月支付1次及以下；", 8, 0, 1),
    TOWTIMES(3, "上月支付1-2次", 12, 1, 2),
    THREETIMES(4, "上月支付3-4次；", 16, 3, 4),
    FIVETIMES(5, "上月支付5-7次", 20, 4, 7),
    SIXTIMES(6, "上月支付7次以上", 24, 7, Integer.MAX_VALUE);
    private int code;//排序
    private String desc;//描述
    private int score;//分值
    private int lower;//最低次数
    private int high;//最高次数


    UnionpayEnums(int code, String desc, int score, int lower, int high) {
        this.code = code;
        this.desc = desc;
        this.score = score;
        this.lower = lower;
        this.high = high;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLower() {
        return lower;
    }

    public void setLower(int lower) {
        this.lower = lower;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }


}



