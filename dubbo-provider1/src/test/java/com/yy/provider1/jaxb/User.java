package com.yy.provider1.jaxb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@XmlType
@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userName;
    private int age;
    private String role;
    private String bibi;
}
