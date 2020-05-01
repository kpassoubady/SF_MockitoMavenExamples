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
import static org.mockito.Mockito.when;

public class ArrayListMock
{
    List mockedList;

    @Before
    public void setUp() throws Exception {
        mockedList = mock(ArrayList.class);
        //stub with any argument
        when(mockedList.get(anyInt())).thenReturn(100);

    }

    @After
    public void tearDown() throws Exception {
        mockedList=null;
    }

    @Test
    public void testArrayListUsingMock() throws Exception {
        Assert.assertEquals(mockedList.get(0),100);
        Assert.assertEquals(mockedList.get(1),100);
        Assert.assertEquals(mockedList.get(5),100);
        Assert.assertEquals(mockedList.get(6),100);
        Assert.assertEquals(mockedList.get(100),100);
    }
}
