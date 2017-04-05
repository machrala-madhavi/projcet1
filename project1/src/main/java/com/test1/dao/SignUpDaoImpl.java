package com.test1.dao;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test1.model.Product;
import com.test1.model.SignUp;
import com.test1.model.SignUp1;


@Repository
public class SignUpDaoImpl implements SignUpDao {
	
	@Autowired
private SessionFactory sf;
@Transactional
	public SignUp1 loginCheck1(SignUp su) {
		Session ses = sf.openSession();
		//Query qr = ses.createQuery("from UserDetails where userid='" + ud.getUserid() + "' and password ='" + ud.getPassword());
		Query qr = ses.createQuery("from SignUp1 where userid=? and password=? and enabled=true");
		qr.setParameter(0, su.getUserid());
		qr.setParameter(1, su.getPassword());
		// qr.list(); // return multiple records
		SignUp1 temp = (SignUp1)qr.uniqueResult(); // returns one record	
		return temp;
	}
	
	public List<SignUp1> getSignUp(){
		Session ses=sf.openSession();
		Query qr=ses.createQuery("from SignUp1");
		List<SignUp1> data=qr.list();
        ses.flush();
		ses.close();
		return data;
		
	}
	
	private void saveUserImage(SignUp1 signup ){
		System.out.print("\n signup img :" +signup.getImagefile());
		try{
			if(signup.getImagefile()!=null){
		Path path=Paths.get("D://workspace1//project1//src//main//webapp//resources//images//users//"+signup.getUserid()+".jpg");
		signup.getImagefile().transferTo(new File(path.toString()));
		System.out.print("\n Product Image saved");
	}
		}
		catch(Exception ex){
			System.out.print("\n User Image not saved");	
		}

	}
	
	

	@Transactional
	private String generateUserId(){	
		
		String newUid="";
		
		Session s = sf.openSession();
		Query qr = s.createQuery("from SignUp1");
		List<SignUp> data = qr.list();
		s.close();
		if(data.size()==0){
			newUid="USR00001";
		}
		else {			
			Session ss = sf.openSession();		
			Query q = ss.createQuery("select max(userid) from SignUp1");
			String prevId = q.list().get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);		
			id=id+1;
			if(id<=9)
				newUid="USR0000"+id;
			else if(id<=99)
				newUid="USR000"+id;
			else if(id<=999)
				newUid="USR00"+id;
			else if(id<=9999)
				newUid="USR0"+id;
			else
				newUid="USR"+id;		
			System.out.print("\nGenerated : "+newUid);		
			ss.close();
			System.out.println("afterdao");
		}
		return newUid;
	}

	@Transactional
	public String adduser(SignUp su) {
		System.out.println("starting");
		Session ses=sf.openSession();
		Transaction tr=ses.beginTransaction();
		tr = ses.beginTransaction();
		su.setUserid(generateUserId());
		su.setRole("ROLE_USER");
		su.setEnabled(true);
		ses.save(su);
//		saveUserImage(su);
		tr.commit();
		ses.close();
		return su.getUserid();
	}	

@Transactional
public SignUp1 getUserById(String uid){
	Session ses=sf.openSession();
	SignUp1 su=ses.get(SignUp1.class,uid);
	ses.close();
	return su;
}

@Transactional
public void editUser(SignUp1 su){
	Session ses=sf.openSession();
	Transaction tr=ses.beginTransaction();
	su.setEnabled(true);
	su.setRole("ROLE_USER");
	ses.update(su);
	tr.commit();
	ses.close();
	}

/*@Transactional
public List<SignUp> getSignUp(){
	Session ses=sf.openSession();
	Query qr=ses.createQuery("from SignUp where userid like 'USR%'");
	List<SignUp>userdata=qr.list();
	ses.flush();
	ses.close();
	return usersdata;
}*/

@Transactional
public void enableUser(String uid){
	Session ses=sf.openSession();
	SignUp1 user=ses.get(SignUp1.class, uid);
	user.setEnabled(true);
	ses.update(user);
	ses.flush();
	ses.close();
}

public void disableUser(String uid){
	Session ses=sf.openSession();
	SignUp1 user=ses.get(SignUp1.class, uid);
	user.setEnabled(false);
	ses.update(user);
	ses.flush();
	ses.close();
}

}
