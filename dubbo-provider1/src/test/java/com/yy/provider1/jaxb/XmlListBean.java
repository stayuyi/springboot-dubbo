package com.yy.provider1.jaxb;

import com.google.common.collect.Lists;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;

/**
 * TODO 2019/7/9
 *
 * @author yuyi
 */

public class XmlListBean {
	@Test
	public void test1(){
		UserListMenu user=new UserListMenu();
		Menu menu1=new Menu();
		Menu menu2=new Menu();
		menu1.setId("1");
		menu2.setId("2");
		menu1.setName("uu");
		menu2.setName("ii");

		Girls girl1=new Girls();
		Girls girl2=new Girls();
		girl1.setAge(18);
		girl2.setAge(18);
		girl1.setName("貂蝉");
		girl2.setName("妲己");


		ArrayList<Menu> menus = Lists.newArrayList(menu1, menu2);
		ArrayList<Girls> girls = Lists.newArrayList(girl1, girl2);
		user.setMenu(menus);
		user.setGrils(girls);

		File file = new File("D://userList.xml");
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(UserListMenu.class);
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
		File file=new File("D://userList.xml");
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(UserListMenu.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			UserListMenu unmarshal = (UserListMenu) unmarshaller.unmarshal(file);
			System.out.println(unmarshal);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
