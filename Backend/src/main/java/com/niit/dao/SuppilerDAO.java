package com.niit.dao;

import java.util.List;

import com.niit.model.Suppiler;

public interface SuppilerDAO {
	public boolean addsuppiler(Suppiler suppiler);
	public Suppiler getsuppiler(int suppilerId);
	public boolean deletesuppiler(Suppiler suppiler);
	public boolean updatesuppiler(Suppiler suppiler);
    public List<Suppiler> getsuppiler();


}
