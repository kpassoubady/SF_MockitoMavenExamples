package com.kavinschool.user.service;

/**
 * Created by kangs on 10/10/17.
 */
public class UserDaoDummy implements UserDao {
    public User get(long ssn) {
        return null;
    }

    public long save(User user) throws Exception {
        return 0;
    }

    public long remove(long ssn) throws Exception {
        return 0;
    }

    public long update(User user) throws Exception {
        return 0;
    }
}
