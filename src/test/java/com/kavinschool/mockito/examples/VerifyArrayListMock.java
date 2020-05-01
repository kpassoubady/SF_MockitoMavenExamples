package com.kavinschool.mockito.examples; /**
 * Created by kangs on 10/10/17.
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class VerifyArrayListMock
{
    List mockedList;

    @Before
    public void setUp() throws Exception {
        mockedList = mock(ArrayList.class);
        //stub with any argument with many returns
        when(mockedList.get(anyInt())).thenReturn(100).thenReturn("times").thenReturn(100).thenReturn("is").thenReturn(10000);

    }

    @After
    public void tearDown() throws Exception {
        mockedList=null;
    }

    @Test
    public void testArrayListUsingMock() throws Exception {
        Assert.assertEquals(mockedList.get(0),100);
        Assert.assertEquals(mockedList.get(1),"times");
        Assert.assertEquals(mockedList.get(5),100);
        Assert.assertEquals(mockedList.get(6),"is");
        Assert.assertEquals(mockedList.get(100),10000);
        mockedList.clear();
        verify(mockedList).get(0);
        verify(mockedList).clear();
        //Below will fail
        //verify(mockedList).get(105);
    }
}
