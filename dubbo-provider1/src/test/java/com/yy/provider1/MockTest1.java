package com.yy.provider1;

import com.yy.provider1.service.impl.MyServiceImpl;
import com.yy.provider1.service.impl.UseDaoImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;
import sun.reflect.misc.ReflectUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MockTest1 {



    @Test
    public void validParms(){
        List mock = mock(List.class);

    //校验类实现  ArgumentMatcher<T>接口  重写 public boolean matches方法
        when(mock.addAll(argThat(new IsRightParams()))).thenReturn(true);

        mock.addAll(Arrays.asList("a","b","c"));

        verify(mock).addAll(argThat(new IsRightParams()));

    }
    @Test
    public void verifyTimes(){
        LinkedList mock = mock(LinkedList.class);
        mock.add("once");
        mock.add("twice");
        mock.add("twice");
        //下面两个验证是相等的,默认使用times(1)
        verify(mock,times(1)).add("once");
        verify(mock).add("once");

//        verify(mock,times(1)).add("twice");

        //至少被调用一次atlist(至少被调用次数)
        verify(mock,atLeast(1)).add("once");
        //至多被调用一次atMost(次数)
//        verify(mock,atMost(1)).add("twice");

        //never()   相当于  times(0),一次也没被调用
//        verify(mock,never()).add("once");

        MyService myService = mock(MyService.class);
        verifyZeroInteractions(myService);
        //查询没有交互的mock对象,这里的mock在前面用了mock.add("once")和mock.add("twice"),测试会报错
//        verifyZeroInteractions(mock,myService);

        when(mock.get(0)).thenReturn("LinkedList的0元素");
        Assert.assertEquals("指定发生错误的小msg",mock.get(0),"LinkedList的1元素");

    }


    @Spy
    UseDao useDao;

    private MyService myService;

    @Before
    public void init(){
        myService=new MyServiceImpl();
        UseDao useDao1=new UseDaoImpl();
        //这里mock的 UseDao useDao;设置给myService的useDao属性报npe
        ReflectionTestUtils.setField(myService,"useDao", useDao1);
    }

    @Test
    public void onlyMockOneMethod(){
        useDao.successSave();
        myService.testMethod1();
        Assert.assertEquals(myService.run("随便来个数返回true"),false);

    }

}
