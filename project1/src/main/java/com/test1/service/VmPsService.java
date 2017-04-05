package com.test1.service;

import java.util.List;

import com.test1.model.Vw_Xmap_ps;

public interface VmPsService {
	public List<Vw_Xmap_ps>getVwPs();
	public List<Vw_Xmap_ps>getBestVwPs();
	public abstract List<Vw_Xmap_ps> getAllSuppProducts(String pid);
	

}
