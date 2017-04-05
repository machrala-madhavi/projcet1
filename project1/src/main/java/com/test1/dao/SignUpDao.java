package com.test1.dao;

import java.util.List;

import com.test1.model.SignUp;
import com.test1.model.SignUp1;

public interface SignUpDao {
	
	public abstract String adduser(SignUp su);
    public abstract SignUp1 loginCheck1(SignUp su);
    public abstract List<SignUp1> getSignUp();
    public abstract SignUp1 getUserById(String uid);
    public abstract void editUser(SignUp1 su);
    public abstract void enableUser(String uid);
    public abstract void disableUser(String uid);

}
