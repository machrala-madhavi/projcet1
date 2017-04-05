package com.test1.dao;

import java.util.List;

import com.test1.model.Vw_Xmap_ps;

public interface VwPsDao {
public abstract List<Vw_Xmap_ps>getVwPs();
public abstract List <Vw_Xmap_ps>getBestVwPs();
public abstract List<Vw_Xmap_ps> getAllSuppProducts(String pid);

	
	
}
