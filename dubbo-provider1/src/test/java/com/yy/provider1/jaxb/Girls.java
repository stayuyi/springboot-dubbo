package com.yy.provider1.jaxb;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * TODO 2019/7/9
 *
 * @author yuyi
 */

@Data
@XmlRootElement(name = "girls")
@XmlAccessorType(XmlAccessType.FIELD)
public class Girls {
	private String name;
	private int age;
}
