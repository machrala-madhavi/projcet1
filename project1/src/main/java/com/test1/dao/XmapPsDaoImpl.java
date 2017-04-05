package com.test1.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test1.model.Product;
import com.test1.model.Xmap_product_Supplier;

 @Repository
public class XmapPsDaoImpl implements XmapPsDao {

 @Autowired
private SessionFactory sessionFactory;

 @Transactional
	public void addXmapPs(Xmap_product_Supplier xps) {
		Session ses=sessionFactory.openSession();
		Transaction tr=ses.beginTransaction();
		xps.setPsid(generatepsid());
		ses.save(xps);
		tr.commit();
		ses.close();

	}
 
	public List<Xmap_product_Supplier> displayXmapPs() {
		Session s = sessionFactory.openSession();
		Query qr = s.createQuery("from Xmap_product_Supplier");
		List<Xmap_product_Supplier> data = qr.list();		
		s.close();
		return data;
	}
	
	@Transactional
	public  Xmap_product_Supplier getXmap_product_SupplierById(String xpsid){
		Session ses=sessionFactory.openSession();
		Xmap_product_Supplier temp=ses.get(Xmap_product_Supplier.class,xpsid);
		ses.close();
		return temp;
		
	}
	
	@Transactional
	public void editXmap_product_Supplier(Xmap_product_Supplier xps){
		Session ses=sessionFactory.openSession();
		Transaction tr=ses.beginTransaction();
		ses.update(xps);
		tr.commit();
		ses.close();
	}
	
	public void deleteXmap_product_Supplier(String xpsid){
		Session ses=sessionFactory.openSession();
		Transaction tr=ses.beginTransaction();
		Xmap_product_Supplier temp=ses.get( Xmap_product_Supplier.class,xpsid);
		ses.delete(temp);
		tr.commit();
		ses.close();
	}
		@Transactional
		private String generatepsid(){
			String newPSid="";
		Session s=sessionFactory.openSession();
		Query qr=s.createQuery("from Xmap_product_Supplier");
		List<Xmap_product_Supplier>data=qr.list();
		s.close();
		if(data.size()==0){
			newPSid="XPS00001";
		}
		else{
			Session ss=sessionFactory.openSession();
			Query q=ss.createQuery("select max(psid)from Xmap_product_Supplier");
			String prevId=q.list().get(0).toString();
			System.out .print("\n Existing :"+prevId);
			int id=Integer.parseInt(prevId.substring(3));
			System.out.print("\n Existing id:"+id);
            id=id+1;
            if(id<=9)
            	newPSid="XPS0000"+id;
            else if(id<=99)
            	newPSid="XPS000"+id;
            else if(id<=999)
            	newPSid="XPS00"+id;
            else if(id<=9999)
            	newPSid="XPS0"+id;
            else
            	newPSid="XPS"+id;
            System.out.print("\n Generated :"+newPSid);
            ss.close();
		}
		return newPSid;
	}
		

}

