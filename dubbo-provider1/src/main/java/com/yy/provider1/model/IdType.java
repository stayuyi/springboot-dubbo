package com.yy.provider1.model;

/**
 * Created by huawai on 2018/9/7. Description:
 */

public enum IdType {

    /**
     * 居民身份证
     */
    JMSFZ("0"),

    /**
     * 军人身份证
     */
    JRSFZ("4"),

    /**
     * 武警身份证
     */
    WJSFZ("5"),

    /**
     * 港、澳、台居民有效身份证
     */
    GATJMSFZ("6"),

    /**
     * 外国护照
     */
    WGHZ("7"),

    /**
     * 个人客户其它有效证件
     */
    GRKHQTYXZJ("8"),

    /**
     * 中国护照
     */
    ZGHZ("9"),

    /**
     * 港澳居民来往内地通行证
     */
    GATJMTXZ("A"),

    /**
     * 台湾居民来往大陆通行证
     */
    TWJMTXZ("B"),

    /**
     * 外国人永久居留证
     */
    WGRYJJLZ("C"),

    /**
     * 户口簿
     */
    HKB("D");

    private String code;

    IdType(String code) {
        this.code = code;
    }
}
