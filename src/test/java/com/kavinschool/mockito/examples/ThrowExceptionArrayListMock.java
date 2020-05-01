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
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ThrowExceptionArrayListMock
{
    List mockedList;

    @Before
    public void setUp() throws Exception {
        mockedList = mock(ArrayList.class);
        //stub with any argument which throws an exception
        //when(mockedList.get(anyInt())).thenThrow(new ArithmeticException());

        //Use doThrow alternative approach
        //stub with any argument which throws an exception
        doThrow(new NullPointerException()).when(mockedList).clear();

    }

    @After
    public void tearDown() throws Exception {
        mockedList=null;
    }

    @Test
    public void testExceptionThrownUsingMock() throws Exception {
        //This test should fail
        //Assert.assertEquals(mockedList.get(0),100);
        mockedList.clear();
    }

    @Test(expected = NullPointerException.class)
    public void testExpectedExceptionUsingMock()  {
        //Assert.assertEquals(mockedList.get(0),100);
        mockedList.clear();
    }
}
