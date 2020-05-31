package com.yunfei.util;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonUtil {
	protected static Logger logger = LoggerFactory.getLogger(JsonUtil.class);
	
private static volatile Boolean init = false;
	
	private static volatile ObjectMapper objectMapper;
	
	private JsonUtil() {
		
	}
	
	private static ObjectMapper getObjectMapper() {
		if(objectMapper != null) {
			return objectMapper;
		}
		synchronized (init) {
			if(objectMapper != null) {
				return objectMapper;
			}
			try {
				objectMapper = SpringUtils.get(ObjectMapper.class);
				if(objectMapper == null) {
					objectMapper = new ObjectMapper();
				}
			} catch (NoSuchBeanDefinitionException e) {
				objectMapper = new ObjectMapper();
			}
			if(!init) {
				init = true;
				CustomDateFormat dateFormat = new CustomDateFormat();
				objectMapper.setDateFormat(dateFormat);
				objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			}
			return objectMapper;
		}
	}
	
	public static ArrayNode createArrayNode() {
		return SpringUtils.get(ObjectMapper.class).createArrayNode();
	}
	
	public static ObjectNode createObjectNode() {
		return SpringUtils.get(ObjectMapper.class).createObjectNode();
	}
	
	public static ObjectNode valueToObjectNode(String str) {
		return (ObjectNode)valueToTree(str);
	}
	
	public static ArrayNode valueToArrayNode(String str) {
		return (ArrayNode)valueToTree(str);
	}
	
	public static JsonNode valueToTree(String str) {
		//ObjectMapper mapper = SpringUtils.get(ObjectMapper.class);
		ObjectMapper mapper = getObjectMapper();
		try {
			return mapper.readTree(str);
		} catch (Exception e) {
			logger.error("该json字符串[" + str + "]无法转换成对象");
			logger.info("", e);
		}
		return null;
	}
	
	public static JsonNode valueToTree(Object object) {
		ObjectMapper mapper = getObjectMapper();
		return mapper.valueToTree(object);
	}
	
	public static String objToJson(Object object) {
		ObjectMapper mapper = SpringUtils.get(ObjectMapper.class);
		try {
			return mapper.writeValueAsString(object);
		} catch (IOException e) {
			logger.error("该对象无法转换成json字符串");
			logger.info("", e);
		}
		return "";
	}

	public static <T> T jsonToObject(String str, Class<T> cls) {
		ObjectMapper mapper = getObjectMapper();
		try {
			return mapper.readValue(str, cls);
		} catch (Exception e) {
			logger.error("该json字符串[" + str + "]无法转换成对象");
			logger.info("", e);
		}
		return null;
	}

	public static <T extends Object> List<T> jsonToObject(String str, TypeReference<List<T>> typeReference) {
		ObjectMapper mapper = getObjectMapper();
		try {
			return mapper.readValue(str, typeReference);
		} catch (Exception e) {
			logger.error("该json字符串[" + str + "]无法转换成对象");
			logger.info("", e);
		}
		return null;
	}
	
	
	
}
