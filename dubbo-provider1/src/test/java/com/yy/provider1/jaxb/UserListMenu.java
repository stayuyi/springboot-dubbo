package com.yy.provider1.jaxb;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@Data
@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserListMenu {
	private String userName;
	private int age;

	@XmlElementWrapper(name = "wrapper1")
	private List<Menu> menu;

	@XmlElementWrapper(name = "wrapper2")
	private List<Girls> grils;

}
