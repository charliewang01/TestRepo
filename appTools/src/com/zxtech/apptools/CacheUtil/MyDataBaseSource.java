package com.zxtech.apptools.CacheUtil;



public enum  MyDataBaseSource  {

	INSTANCE;
	private  ServiceCache self;
	
	
    private MyDataBaseSource() {
    	self=new ServiceCache();
    }
    
    public  ServiceCache getMyDataBaseSource() {
    	return self;
    }
    
}
