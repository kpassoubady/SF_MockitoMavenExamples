package com.kavinschool.user.service;

/**
 * Created by kangs on 10/10/17.
 */
public interface UserDao {

    public User get(long ssn);

    public long save(User user) throws Exception;

    public long remove(long ssn) throws Exception;

    public long update(User user) throws Exception;

}
