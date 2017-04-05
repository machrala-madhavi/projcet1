package com.test1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test1.dao.VwPsDao;
import com.test1.model.Vw_Xmap_ps;

@Service
public class VwPsServiceImpl implements VmPsService {

	@Autowired
	private VwPsDao vwpsdao;
	public List<Vw_Xmap_ps> getVwPs() {
		// TODO Auto-generated method stub
		return vwpsdao.getVwPs();
		
	}

	public List<Vw_Xmap_ps>getBestVwPs() {
		// TODO Auto-generated method stub
		return vwpsdao.getBestVwPs();
	}
	
	public List<Vw_Xmap_ps> getAllSuppProducts(String pid) {		
		return vwpsdao.getAllSuppProducts(pid);
	}

}
