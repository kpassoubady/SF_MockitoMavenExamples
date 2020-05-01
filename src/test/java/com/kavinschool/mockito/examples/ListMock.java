package com.kavinschool.mockito.examples;
/**
 * Created by kangs on 10/10/17.
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListMock {
    List mockedList;

    @Before
    public void setUp() throws Exception {
        mockedList = mock(List.class);
        when(mockedList.get(0)).thenReturn("Learning");
        when(mockedList.get(1)).thenReturn("Mockito");
        when(mockedList.get(5)).thenReturn("is");
        when(mockedList.get(6)).thenReturn("Fun");
    }

    @After
    public void tearDown() throws Exception {
        mockedList = null;
    }

    @Test
    public void testListUsingMock() throws Exception {
        Assert.assertEquals(mockedList.get(0), "Learning");
        Assert.assertEquals(mockedList.get(1), "Mockito");
        Assert.assertEquals(mockedList.get(5), "is");
        Assert.assertEquals(mockedList.get(6), "Fun");
    }
}
