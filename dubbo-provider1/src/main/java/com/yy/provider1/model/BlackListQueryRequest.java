package com.yy.provider1.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.Data;
import lombok.ToString;

/**
 * Created by huawai on 2018/9/7. 百晓黑名单查询
 */
@Data
@ToString
public class BlackListQueryRequest {

    /**
     * 租户号码
     */
    private Long tenantId;

    // 证件号码(最大20位)
    private String idNo;

    // 证件类型
    private IdType idType;

    private String name;

    private String args;

}
