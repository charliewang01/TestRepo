package com.zxtech.apptools.CacheUtil;



import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ServiceCache {

	
	private ConcurrentMap<String ,CachedInfos> store;
	
	public ServiceCache() {
		store=new ConcurrentHashMap<String, CachedInfos>();
	}
	
	
	
	public   static ServiceCache  getInstance(){
		return MyDataBaseSource.INSTANCE.getMyDataBaseSource();
	}
	
	public  boolean containskey(String key){
		
		return store.containsKey(key);
	}
	
	
	public  CachedInfos get(String key){
		
		
		return store.get(key);
	}
	
	public  void put(String key,CachedInfos value){
		store.put(key, value);
	}
	
	public void remove(String key){
		store.remove(key);
	}
	
}
