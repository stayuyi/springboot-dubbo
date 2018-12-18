package com.yy.provider1.jaxb;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlType//@XmlType，将Java类或枚举类型映射到XML模式类型，常与@XmlRootElement、@XmlAccessorType共用，propOrder属性定义字段生成的XML节点顺序；
@XmlRootElement(name = "userMenu") //@XmlRootElement，将Java类或枚举映射成XML元素根节点，是唯一一个必须注解，name属性指定根节点名称，不指定默认为类名的小写；
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)  //@XmlAccessorOrder，控制JAXB 绑定类中属性和字段的排序，有两个属性，AccessorOrder.ALPHABETICAL——对生成的XML元素按字母书序排序，XmlAccessOrder.UNDEFINED——不排序，默认为该值；
//@Data    注意这个注解会产生  类的两个属性具有相同名称
@NoArgsConstructor
@AllArgsConstructor
public class UserMenu implements Serializable {

    private String userName;

    @XmlAttribute  //用于把java对象的属性映射为xml的属性,并可通过name属性为生成的xml属性指定别名
    private int age;

    @XmlElement(nillable=true) //该注解用在java类的属性上，用于将属性映射为xml的子节点。可通过在后面配置name属性值来改变java属性在xml文件中的名称
    //nillable=true 表示null占位符,   nillable默认false,则当此元素为null的时候,xml文件中不会出现此元素,设为true时,此元素会在xml文件中出现
    //在传数组的时候就很有用, 比如你只有minOccurs传{0,nill,1,nill} 就会变成{0,1}
    //所以说nillable就算不传值也有占位作用. 还有一些动态表, 也需要nillable把表构造穿过去, 否则会报错. 这个时候你就不能用minOccurs来传
    //required =true 表示必此变量为必传变量,为false表示非必传
    private String role;

    @XmlTransient  //在由java对象映射xml时，忽略此属性。即，在生成的xml文件中不出现此元素
    private String bibi;

    @XmlElement
    private Menu menu;
}
