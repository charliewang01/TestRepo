package com.zxtech.apptools.Smessage;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import redis.clients.jedis.ShardedJedis;

import com.zxtech.apptools.CacheUtil.RedisUtil;




@Controller
@RequestMapping("/Send")
public class SendShortMeaage {

	
	
	/**
	 * 联系人手机校验
	 * @param photoHR
	 * @return
	 */
	@RequestMapping("/sendShortMeaage")
	@ResponseBody
	public String sendShortMeaage(String phone,String type){
		String resful="fail";
		if(phone.length()==11){//校验手机
	  		   Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
	  	       Matcher matcher = p.matcher(phone);
	  	       if(matcher.matches()){
	  	    	Random rand= new Random();
	 			int tmp = Math.abs(rand.nextInt());
	 		    int rendString=tmp % (999999 - 100000 + 1) + 100000;
	 			TemplateSMS.CreateHr(phone,rendString+",5");   
	 			
//	 			CachedInfos infos = new CachedInfos();
//	 			infos.value=rendString;
//	 			infos.time=new Date().getTime();
//	 			ServiceCache.getInstance().put(phone+type, infos);
	 			
	 		    Map<String, String> redis = new HashMap<String, String>();    	
	   		    redis.put("key", rendString+"");
	   		    redis.put("Time", String.valueOf(new Date().getTime()));
	   		    ShardedJedis  jedis =RedisUtil.getJedis();
	   		    jedis.hmset(phone+type, redis);
   			    RedisUtil.returnResource(jedis);
	 			resful="success";
	 			return resful;
	  	       }else {
	  	    	 return resful;
			}
	  		}else {
				return resful;
			}
	}
	public static void main(String[] args) {
			new  SendShortMeaage().sendShortMeaage("13556463631","HR");
	}
	
	@RequestMapping("/checkYZM")
	@ResponseBody
	public boolean checkYZM(String key,String value){
		boolean flag=false;
		
		ShardedJedis  jedis =RedisUtil.getJedis();
  		 List<String> rsmap =jedis.hmget(key, "key","Time");
  		 if(rsmap.size()>0){
		if(value.equalsIgnoreCase(rsmap.get(0))){
			  if(new Date().getTime() / 1000 / 60 -(Long.valueOf(rsmap.get(1))) <6){	
				  	flag=true;
			  }
				jedis.del(key);
    			RedisUtil.returnResource(jedis);
		}}
		return flag;
	}
	
	
	/**
	 * 校验验证码
	 * @param key   shoujihaomao+1
	 * @param value  yanzm
	 * @return
	 */
	public boolean check(String key,String value){
		boolean flag=false;
		
		ShardedJedis  jedis =RedisUtil.getJedis();
 		 List<String> rsmap =jedis.hmget(key, "key","Time");
 		 if(rsmap.size()>0){
		if(value.equalsIgnoreCase(rsmap.get(0))){
			  if(new Date().getTime() / 1000 / 60 - (Long.valueOf(rsmap.get(1))) <6){	
				  	flag=true;
			  }else {
					jedis.del(key);
	    			RedisUtil.returnResource(jedis);
			}
			  }
		}
		return flag;
	}
	
	
}
