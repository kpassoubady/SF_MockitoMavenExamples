package com.kavinschool.mockito.examples;
/**
 * Created by kangs on 10/10/17.
 */
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.mockito.Mockito.*;

public class CalendarMock
{
    Calendar mockedCalendar;

    @Before
    public void setUp() throws Exception {
        mockedCalendar = mock(Calendar.class);
        when(mockedCalendar.get(Calendar.YEAR)).thenReturn(2017);
        when(mockedCalendar.get(Calendar.MONTH)).thenReturn(2);
    }

    @After
    public void tearDown() throws Exception {
        //mockedCalendar=null;
        reset(mockedCalendar);
    }

    @Test
    public void testCalendarUsingMock() throws Exception {
        Assert.assertEquals(mockedCalendar.get(Calendar.YEAR),2017);
        Assert.assertEquals(mockedCalendar.get(Calendar.MONTH),2);
    }
}
