package com.chen.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.chen.entity.User;

public class JsonUtil {
	
	/**
	 * 将user对象转换为json格式并输出
	 * @param user
	 * @param response
	 * @throws Exception
	 */
	public static void userToJson(User user, HttpServletResponse response) throws Exception{
		response.setContentType("text/json");
		response.setHeader("Cache-Control", "no-cache");
	    response.setCharacterEncoding("UTF-8");
	    
	    PrintWriter writer = response.getWriter();
	    
	    String json = JSONObject.toJSONString(user, 
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteNullNumberAsZero,
				SerializerFeature.WriteNullListAsEmpty,
				SerializerFeature.WriteNullStringAsEmpty,
				SerializerFeature.WriteNullBooleanAsFalse,
				SerializerFeature.DisableCircularReferenceDetect);
    	writer.write(json);   	
    	writer.close();
	}

}
