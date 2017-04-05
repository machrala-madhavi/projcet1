package com.test1.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test1.model.Vw_Xmap_ps;

@Repository
public class VwPsDaoImpl implements VwPsDao {

@Autowired
private SessionFactory sessionFactory;

	public List<Vw_Xmap_ps> getVwPs() {
		Session ses=sessionFactory.openSession();
		Query qr=ses.createQuery("from Vw_Xmap_ps");
		List<Vw_Xmap_ps> data=qr.list();
		ses.close();
		return data;
	}
	public List<Vw_Xmap_ps>getBestVwPs(){
		Session ses=sessionFactory.openSession();
		String qry="from  Vw_Xmap_ps x1 where productsupplierprice=(select min(productsupplierprice)from Vw_Xmap_ps x2 where x1.Productid=x2.Productid)";
		Query qr=ses.createQuery(qry);
		List< Vw_Xmap_ps>data=qr.list();
		ses.close();
		return data;
	}
	
	@Transactional
	public List<Vw_Xmap_ps> getAllSuppProducts(String pid) {
		Session ses = sessionFactory.openSession();
		String qry = "from Vw_Xmap_ps where productid=?";		
		Query qr = ses.createQuery(qry);
		qr.setParameter(0, pid);
		List<Vw_Xmap_ps> data = qr.list();
		ses.close();		
		return data;
	}
	

}
