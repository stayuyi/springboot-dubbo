package com.yy.provider1.jaxb;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlType(propOrder = {"userName","role","menu"})
@XmlRootElement(name = "user")
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class UserMenu1 implements Serializable{

        private String userName;
        private int age;
        private String role;
        private String bibi;
        private Menu menu;
        public UserMenu1() {
        }

        public UserMenu1(String userName, int age, String role, String bibi) {
            this.userName = userName;
            this.role = role;
            this.age = age;
            this.bibi = bibi;
        }

    public UserMenu1(String userName, int age, String role, String bibi, Menu menu) {
        this.userName = userName;
        this.age = age;
        this.role = role;
        this.bibi = bibi;
        this.menu = menu;
    }

    public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        @XmlAttribute
        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @XmlElement(nillable=true)
        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        @XmlTransient
        public String getBibi() {
            return bibi;
        }

        public void setBibi(String bibi) {
            this.bibi = bibi;
        }

        @XmlElement
        public Menu getMenu() {
            return menu;
        }

        public void setMenu(Menu menu) {
            this.menu = menu;
        }

        @Override
        public String toString() {
            return "User{" +
                    "userName='" + userName + '\'' +
                    ", age=" + age +
                    ", role='" + role + '\'' +
                    ", menu=" + menu +
                    '}';
        }
    }






