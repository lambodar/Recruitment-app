package com.acti.recruitment.dao;

import com.acti.recruitment.serviceloader.DaoServiceLoader;

public class ConnectionProviderFactory {
	public static DaoServiceLoader connectionProvider;
	static{
		connectionProvider=new ConnectionProvider();
	}
	public static DaoServiceLoader getConnectionProvider(){
		return connectionProvider;
	}
}
