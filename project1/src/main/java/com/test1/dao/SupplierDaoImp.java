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

import com.test1.model.Supplier;


@Repository
public class SupplierDaoImp implements SupplierDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void addSupplier(Supplier sup) {
		Session ses=sessionFactory.openSession();
		Transaction tr=ses.beginTransaction();
		sup.setSupplierid(generateSupplierId());
	    ses.save(sup);
	    saveSupplierImage(sup);
	    tr.commit();
	    ses.close();
		}

	@Transactional
	public List<Supplier> getSuppliers() {
	Session ses=sessionFactory.openSession();
	Query qr=ses.createQuery("from Supplier");
	List<Supplier> data=qr.list();
	ses.close();
    return data;
	}
	
	@Transactional
	public Supplier getSupplierById(String supid){
		Session ses=sessionFactory.openSession();
		Supplier temp=ses.get(Supplier.class,supid);
		ses.close();
		return temp;
			}
	
	@Transactional
	public void editSupplier(Supplier sup){
		Session ses=sessionFactory.openSession();
		Transaction tr=ses.beginTransaction();
		ses.update(sup);
		tr.commit();
		ses.close();

	}
	
	private void saveSupplierImage(Supplier sup){
		System.out.print("\n sup img :" +sup.getImagefile());
		try{
			if(sup.getImagefile()!=null){
		Path path=Paths.get("D://workspace1//project1//src//main//webapp//resources//images//suppliers//"+sup.getSupplierid()+".jpg");
		sup.getImagefile().transferTo(new File(path.toString()));
		System.out.print("\n Supplier Image saved");
	}
		}
		catch(Exception ex){
			System.out.print("\n Supplier Image not saved");	
		}
	}
	
	public void deleteSupplier(String supid){
		Session ses=sessionFactory.openSession();
		Transaction tr=ses.beginTransaction();
		Supplier temp=ses.get(Supplier.class, supid);
		ses.delete(temp);
		tr.commit();
		ses.close();
	
	

	}

@Transactional
private String generateSupplierId(){
String newSid="";

Session s=sessionFactory.openSession();
Query qr=s.createQuery("from Supplier");
List<Supplier>data=qr.list();
s.close();
if(data.size()==0){
	newSid="SUP00001";
}
else
{
	Session ss=sessionFactory.openSession();
	Query q=ss.createQuery("select max(supplierid)from Supplier");
    String prevId=q.list().get(0).toString();
    System.out.print("\n Existing id:"+prevId);
    int id=Integer.parseInt(prevId.substring(3));
    System.out.print("\n Existing id:"+id );
    id=id+1;
    if(id<=9)
    	newSid="SUP0000"+id;
    else if(id<=99)
    	newSid="SUP000"+id;
    else if(id<=999)
    	newSid="SUP00"+id;
    else if(id<=9999)
    	newSid="SUP0"+id;
    else 
    	newSid="SUP"+id;
    System.out.print("\n Generated :"+newSid);
    ss.close();
            }
              return newSid;
        }


}
