package com.yy.provider1.jaxb;

import org.junit.Test;

import javax.xml.bind.*;
import java.io.File;

public class TestJaxb {
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

    @Test
    public void test3(){
        UserMenu userMenu=new UserMenu("uName",18,"role","what",new Menu("菜单","001"));
        UserMenu1 userMenu1=new UserMenu1("uName",18,"role","what",new Menu("菜单","001"));
        try {
            String s1 = JaxbXmlUtil.convertToXml(userMenu);
            System.out.println(s1);

            String s2 = JaxbXmlUtil.convertToXml(userMenu1);
            System.out.println(s2);
            //对比两个类看一下,UserMenu不去掉@Data会报下面的错误
            //@XmlAccessorType的默认访问级别是XmlAccessType.PUBLIC_MEMBER。
            // 因此，如果java对象中的private成员变量设置了public权限的getter/setter方法，
            // 就不要在private变量上使用@XmlElement和@XmlAttribute注解，否则在由java对象生成xml时会报同一个属性在java类里存在两次的错误。
            // 同理，如果@XmlAccessorType的访问权限为XmlAccessType.NONE，如果在java的成员变量上使用了@XmlElement或@XmlAttribute注解，
            // 这些成员变量依然可以映射到xml文件。
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
