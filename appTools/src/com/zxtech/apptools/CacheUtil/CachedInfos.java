package com.zxtech.apptools.CacheUtil;


import java.io.Serializable;
import java.util.List;
import java.util.Map;


@SuppressWarnings("serial")
public class CachedInfos implements Serializable {
 
	public Object key;
	public Object value;
	public Map<String,Object> map;
	public long time;
	public String ctiynamePY;
	public List <Map<String,Object>> CityList;

}
