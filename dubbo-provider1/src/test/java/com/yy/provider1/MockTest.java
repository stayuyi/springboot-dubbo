package com.yy.provider1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MockTest {
    @Mock
    private MyService myService;

    @Test
    public void mockTest(){
        final String name="abc";
        System.out.println(myService.run(name));
    }

    @Test
    public void addList(){
        List mockList = mock(List.class);
        mockList.add("aaa");
        mockList.clear();

        verify(mockList).add("abc");
        verify(mockList).clear();

    }
    @Test
    public void getElem(){
        Map mockMap = mock(HashMap.class);
//    设定mock对象某个方法调用时的返回值(打桩stubbing)
//     when(mock.someMethod()).thenReturn(value)
        when(mockMap.get("one")).thenReturn("I am one");

    System.out.println(mockMap.get("one"));

    //下面没有进行打桩函数,输出null
    System.out.println(mockMap.get("abc"));
//    可以连续设定返回值
        when(mockMap.get("one")).thenReturn("first one").thenReturn("second one","third one");
    System.out.println(mockMap.get("one"));
    System.out.println(mockMap.get("one"));
    System.out.println(mockMap.get("one"));
    System.out.println(mockMap.get("one"));

    //    doReturn(value).when(mock.someMethod())
        doReturn("doReturn").when(mockMap).get("do");
    System.out.println(mockMap.get("do"));



//    调用mockMap.get("null")抛出npe   ,  调用指定方法时抛出指定的异常:
    //when(mock.someMethod()).thenThrow(new RuntimeException());
        when(mockMap.get("null")).thenThrow(new RuntimeException("npe"));
//        mockMap.get("null");

//    doThrow(new RuntimeException()).when(mock.someMethod())
        doThrow(new RuntimeException("error param")).when(mockMap).get("error");
//        mockMap.get("error");

   /*     对void方法进行方法预期设定只能用如下语法：
    doNothing().when(mock.someMethod())
    doThrow(new RuntimeException()).when(mock.someMethod())
    doNothing().doThrow(new RuntimeException()).when(mock.someMethod())*/

        //参数匹配器 (Argument matchers),anyInt()  anyString()  anySet()
    //接受任何同类型的参数都返回一个值
    doReturn("everything").when(mockMap).get(anyString());
    System.out.println(mockMap.get("乱七八糟的参数"));
    }



    @Mock
    CompareMockSpy compareMock;

    @Before
    public void initMock(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
   /*
    A----- @Mock创建的是全部mock的对象，既在对具体的方法打桩之前，
    mock对象的所有属性和方法全被置空（0或者null）；
    B-----与之对应的是@Spy这个注解，@Spy可以创建部分mock的对象，
    部分mock对象的所有成员方法都会按照原方法的逻辑执行，直到被打桩返回某个具体的值。
    @Mock和@Spy才是两个具有可比性的概念。
    即:
    1、Mock声明的对象，对函数的调用均执行mock（即虚假函数），不执行真正部分。
    2、Spy声明的对象，对函数的调用均执行真正部分。
    */

    public void testMock(){
        compareMock.fun(5);
          //上面执行mock,未打印信息,执行的不是真正部分

        doCallRealMethod().when(compareMock).fun(anyInt());
        compareMock.fun(15);
        //doCallRealMethod()声明后,执行真正部分,这里真正执行了fun
        //mock只能对publick和protected函数进行mock
        //对于private的fun2执行了真正部分
        //最终输出115

        //真正执行fun1,输出5
        doCallRealMethod().when(compareMock).fun1(anyInt());
        compareMock.fun1(5);

        //执行mock,这里输出的int的默认值0,没有输出10,
        System.out.println(compareMock.getValue());

        when(compareMock.getValue()).thenReturn(10);
        System.out.println(compareMock.getValue());
    }


    @Spy
    CompareMockSpy compareSpy;

    @Before
    public void initSpy(){
        MockitoAnnotations.initMocks(CompareMockSpy.class);
    }

    @Test
    public void testSpy(){
        compareSpy.fun(5);
        //这里直接调用了fun,然后调了fun1和fun2,输出 5  和 105,调用了真正方法

        System.out.println(compareSpy.getValue());
        //这里直接调用真正方法,输出10

        when(compareSpy.getValue()).thenReturn(20);
        System.out.println(compareSpy.getValue());
        //输出了打桩的值20
    }

}
