package com.zxtech.apptools;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.commons.CommonsMultipartFile;







import com.zxtech.apptools.ConfigUtil;
import com.aliyun.openservices.ClientException;
import com.aliyun.openservices.ServiceException;
import com.aliyun.openservices.oss.OSSClient;
import com.aliyun.openservices.oss.OSSErrorCode;
import com.aliyun.openservices.oss.OSSException;
import com.aliyun.openservices.oss.model.CopyObjectResult;
import com.aliyun.openservices.oss.model.ObjectMetadata;



@Repository("OSSFileUpload")
public class OSSFileUpload {
	private static final String ACCESS_ID = ConfigUtil.getValue("alyACCESS_ID");
    private static final String ACCESS_KEY = ConfigUtil.getValue("alyACCESS_KEY");
    private static final String ALiYun =  ConfigUtil.getValue("alyALiYun");//阿里云访问路�?
    
    private static 	OSSClient client = new OSSClient(ConfigUtil.getValue("alyurl"),ACCESS_ID, ACCESS_KEY);	
    private static final String bucketName = ConfigUtil.getValue("alybucketName");;	
    
    	
    /**
     * 上传图片
     * @param key
     * @param content
     * @return
     * @throws NumberFormatException
     * @throws IOException
     */
	public  String putObject(String key, InputStream content)
			throws NumberFormatException, IOException {
	
		// 创建上传Object的Metadata
		ObjectMetadata meta = new ObjectMetadata();

		// 必须设置ContentLength
		meta.setContentLength(Integer.parseInt(String.valueOf(content
				.available())));
		// 用户自定义文件名�?
		meta.addUserMetadata("filename", key);
		
		String fileUrl = ALiYun + key;
		// 上传Object.
		client.putObject(bucketName, key, content,	meta);
		return fileUrl;
	}

    
	/**
	 * 将阿里云上object对象a复制�?��新的object 对象b出来
	 * @param srcKey   目标链接    eg."upload/papers13554463704_certificateImage20151205161220.png"
	 * @param destKey  新object链接  eg."upload/p0.png"
	 */
	public   void copyObject( String srcKey, String destKey) {
	    // 拷贝Object
	    CopyObjectResult result = client.copyObject(bucketName, srcKey, bucketName, destKey);
	    // 打印结果
	}
	
	/**
	 * 删除object对象，将图片删除
	 * @param key
	 */
	public   void deleteObject(String key) {
	    client.deleteObject(bucketName, key);
	}
	
	
	public static void main(String[] args) {
//		copyObject("upload/p0.png",  "upload/p0.png");
	//	deleteObject("upload/p0.jpg");
	}
	
    /**
     * 
     * @param KEY 文件访问�?
     * @param uploadFile		上传的文�?
     * @param maxSize		上传的文件大小限制，单位为MB
     * @return			文件上传成功，返回文件访问URL，上传失败，返回“error”，文件超出限制，返回�?exceed�?
     * @throws IOException
     */
    public String Upload(String KEY,CommonsMultipartFile uploadFile,int maxSize) throws IOException{
    	String fileUrl = null;
    	if(uploadFile.getSize() < maxSize * 1024 *1024){
    		try {
				InputStream content = uploadFile.getInputStream();				
				// 创建上传Object的Metadata
				ObjectMetadata meta = new ObjectMetadata();			
				// 必须设置ContentLength
				meta.setContentLength(uploadFile.getSize());		
				// 打印ETag
				System.out.println(client.putObject(bucketName, KEY, content, meta).getETag());
				//文件访问路径
				fileUrl = ALiYun + KEY;
			} catch (OSSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fileUrl = "error";
			} catch (ClientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fileUrl = "error";
			}		    
		}else{
			fileUrl = "exceed";
		}	
    	return fileUrl; 	
    }
    
    
	   // 阿里云服务器上传文件创建Bucket.
    private void ensureBucket(OSSClient client, String bucketName)throws OSSException, ClientException{
    	try {
         // 创建bucket
    		client.createBucket(bucketName);
    	}catch (ServiceException e) {
    		if (!OSSErrorCode.BUCKES_ALREADY_EXISTS.equals(e.getErrorCode())) {
    			// 如果Bucket已经存在，则忽略
    			throw e;
    		}
    	}
    }
}
