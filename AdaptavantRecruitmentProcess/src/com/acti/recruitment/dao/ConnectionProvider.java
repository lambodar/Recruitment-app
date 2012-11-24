package com.acti.recruitment.dao;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import com.acti.recruitment.dto.UserDetails;
import com.acti.recruitment.serviceloader.DaoServiceLoader;

public class ConnectionProvider implements DaoServiceLoader{
	
	PersistenceManagerFactory presistenceManagerFactory=PMF.get();
	PersistenceManager persistenceManager=presistenceManagerFactory.getPersistenceManager();
	
	public void savePojo(UserDetails user){
		persistenceManager.makePersistent(user);
		}
	
	@SuppressWarnings("unchecked")
	public List<UserDetails> getPojo(String facebookId){
		Query query=persistenceManager.newQuery(UserDetails.class,"facebookId == '"+facebookId+"'");
		return (List<UserDetails>)query.execute();
		}
	
	@SuppressWarnings("unchecked")
	public List<UserDetails> getPojoByField(String field,String fieldValue){
		Query query=persistenceManager.newQuery(UserDetails.class,field+" == '"+fieldValue+"'");
		return (List<UserDetails>)query.execute();
		}
	/*@SuppressWarnings("unchecked")
	public List<UserDetails> changePassword(String username,String old_Password) {
		// TODO Auto-generated method stub
		Query query=persistenceManager.newQuery(UserDetails.class,"user_Name== '"+username+"' && passWord== '"+old_Password+"'");
		return (List<UserDetails>)query.execute();
		}*/
	@SuppressWarnings("unchecked")
	public List<UserDetails> getAll(){
		Query query=persistenceManager.newQuery(UserDetails.class);
		return (List<UserDetails>)query.execute();
		}
}
