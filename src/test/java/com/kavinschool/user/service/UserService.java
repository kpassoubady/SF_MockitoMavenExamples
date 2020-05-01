package com.kavinschool.user.service;

/**
 * Created by kangs on 10/10/17.
 */
public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User get(long ssn) {
        return userDao.get(ssn);
    }

    public long save(long ssn, String firstName, String lastName, int age) throws Exception {
        User user = new User();
        user.setAge(age);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setSsn(ssn);
        return userDao.save(user);
    }

    public long remove(long ssn) throws Exception {
        return userDao.remove(ssn);
    }

    public long update(long ssn, String firstName, String lastName, int age) throws Exception {
        User user = new User();
        user.setAge(age);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setSsn(ssn);
        return userDao.update(user);
    }
}
