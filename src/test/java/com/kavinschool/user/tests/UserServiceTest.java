package com.kavinschool.user.tests;


import com.kavinschool.user.service.User;
import com.kavinschool.user.service.UserDao;
import com.kavinschool.user.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by kangs on 10/10/17.
 */
public class UserServiceTest {
    UserDao mockUserDao;

    User user;

    UserService userService;

    @Before
    public void setUp() {
        mockUserDao = mock(UserDao.class);
        userService = new UserService(mockUserDao);

        //Create a user
        user = new User();
        user.setSsn(123456789);
        user.setFirstName("Keith");
        user.setLastName("Ken");
        user.setAge(40);
    }

    @Test
    public void testSave() throws Exception {
        //Using argument captor to test the values passed to the UserDao.save method
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        userService.save(123456789,"Roopa", "Das", 35);

        //capture the arguments
        verify(mockUserDao).save(userArgumentCaptor.capture());
        //Test the method called once
        verify(mockUserDao, times(1)).save(any(User.class));

        //Get the user
        User storedUser = (User) userArgumentCaptor.getValue();

        //Verify the values saved is what you are expecting
        assertEquals("Roopa", storedUser.getFirstName());
        assertEquals("Das", storedUser.getLastName());
        assertEquals(35, storedUser.getAge());
        assertEquals(123456789, storedUser.getSsn());
    }

    @Test
    public void testGetUsingSpy() throws Exception {
       // UserService userService = new UserService(mockUserDao);
        UserService spy = spy(userService);

        when(spy.get(user.getSsn())).thenReturn(user);
        assertEquals(user, spy.get(user.getSsn()));
    }

    @Test
    public void testGetWithMock() throws Exception {
        when(mockUserDao.get(user.getSsn())).thenReturn(user);
        assertEquals(user, userService.get(user.getSsn()));
    }

    @Test
    public void testSaveWithMock() throws Exception {
        when(mockUserDao.save(any(User.class))).thenReturn(user.getSsn());
        long actualValue = userService.save(user.getSsn(), user.getFirstName(), user.getLastName(), user.getAge());
        assertEquals(user.getSsn(), actualValue);
    }

    @Test
    public void testRemoveWithMock() throws Exception {
        when(mockUserDao.remove(user.getSsn())).thenReturn(user.getSsn());
        assertEquals(user.getSsn(),userService.remove(user.getSsn()));
    }

}
