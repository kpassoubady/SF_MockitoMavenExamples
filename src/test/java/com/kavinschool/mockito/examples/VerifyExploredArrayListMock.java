package com.kavinschool.mockito.examples; /**
 * Created by kangs on 10/10/17.
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class VerifyExploredArrayListMock {
    List mockedList;

    @Before
    public void setUp() throws Exception {
        mockedList = mock(ArrayList.class);
        //stub with any argument with many returns
        when(mockedList.get(anyInt())).thenReturn(100).thenReturn("times").thenReturn(100).thenReturn("is").thenReturn(10000);
        mockedList.add("Learning");
        mockedList.add("is");
        mockedList.add("fun");
    }

    @After
    public void tearDown() throws Exception {
        mockedList = null;
    }

    @Test
    public void testArrayListUsingMock() throws Exception {
        Assert.assertEquals(mockedList.get(0), 100);
        Assert.assertEquals(mockedList.get(1), "times");
        Assert.assertEquals(mockedList.get(5), 100);
        Assert.assertEquals(mockedList.get(6), "is");
        Assert.assertEquals(mockedList.get(100), 10000);
        mockedList.clear();

        verify(mockedList).get(0);
        verify(mockedList).clear();

        mockedList.clear();

        verify(mockedList, times(2)).clear();
        verify(mockedList, times(5)).get(anyInt());
        verify(mockedList, atLeast(2)).get(anyInt());
        verify(mockedList, never()).remove(ArgumentMatchers.any());
        verify(mockedList, atLeast(2)).add(anyString());
        verify(mockedList, atMost(2)).clear();
    }
}
