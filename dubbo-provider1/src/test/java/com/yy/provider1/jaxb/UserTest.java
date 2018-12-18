package com.yy.provider1.jaxb;

import org.junit.Test;

import javax.xml.bind.*;
import java.io.File;

public class UserTest {
    //输出xml文件
    @Test
    public void test1(){
        User user = new User("陈本布衣", 2018, "超级管理员","瞎哔哔");
        File file = new File("E://user.xml");

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            //格式化输出,即标签自动换行,否则就是一行输出
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

            //设置编码,(默认编码就是utf-8)
            marshaller.setProperty(Marshaller.JAXB_ENCODING,"UTF-8");

            //是否省略xml头信息,默认不省略false
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT,false);

            marshaller.marshal(user,file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    //读取xml文件
    @Test
    public void test2(){
        File file=new File("E://user.xml");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            User unmarshal = (User) unmarshaller.unmarshal(file);
            System.out.println(unmarshal);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
