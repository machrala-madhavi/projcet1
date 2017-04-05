package com.test1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test1.dao.SignUpDao;
import com.test1.model.SignUp;
import com.test1.model.SignUp1;


@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired
	private SignUpDao signupdao;
	
	public String addUser(SignUp su) {
		return signupdao.adduser(su);
	}

	public SignUp1 loginCheck1(SignUp su) {
		return signupdao.loginCheck1(su);
	}
	public SignUp1 getUserById(String uid){
		return signupdao.getUserById(uid);
	}
public void editUser(SignUp1 su){
	signupdao.editUser(su);
}

/*public List<SignUp>getgetSignUp(){
	return signupdao.getSignUp();
}*/

public List<SignUp1>getSignUp(){
	return signupdao.getSignUp();
}
public void enableUser(String uid){
    signupdao.enableUser(uid);
}
public void disableUser(String uid){
	signupdao.disableUser(uid);
}



}
