package com.yunfei.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import com.yunfei.util.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;



/**
 * @author 05578
 *
 */
/**
 * @author 05578
 *
 */
public class StringUtil {

	public static boolean isEmpty(String str) {
		return StringUtils.isEmpty(str);
	}

	/**
	 * 
	 * @Title: formateNumber
	 * @Description: 将数字变成字符串
	 * @param @param i
	 * @param @param scale
	 * @param @return 设定文件
	 * @return String 返回类型 例如，如果输入4,4，则返回0004
	 */
	public static String formateNumber(int number, int scale) {
		String str = "" + number;
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < scale - str.length(); i++) {
			sb.append("0");
		}
		sb.append(str);
		return sb.toString();
	}

	/**
	 * 
	 * @Title: toLowerCaseFirst
	 * @Description: 将第一个字母小写)
	 * @param @param str
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String toLowerCaseFirst(String str) {
		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}

	public static boolean isBlank(String str) {
		return StringUtils.isBlank(str);
	}

	// 将gbk的字符串转成utf-8
	public static String gbk2utf(String content) {
		String iso = "";
		String utf8 = "";
		try {
			iso = new String(content.getBytes("UTF-8"), "ISO-8859-1");
			utf8 = new String(iso.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new BusinessException("转utf8失败，无法转换！");
		}
		return utf8;
	}

	public static String replaceStr(String str, Map<String, String> filter) {
		/*
		 * if(str.contains("(")) System.out.println(str);
		 */
		if (isEmpty(str))
			return str;
		if (null == filter || filter.isEmpty())
			return str;
		Iterator<Entry<String, String>> it = filter.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> entry = it.next();
			String key = entry.getKey();
			String value = entry.getValue();
			str = str.replace(key, value);
		}
		return str;
	}

	/** 字符串list集合用指定分隔符拼接，默认使用,[一个半角逗号]，类似js的join方法 */
	public static String list2String(List<String> list, String opeartor) {
		StringBuffer str = new StringBuffer();
		if (StringUtil.isEmpty(opeartor))
			opeartor = ",";
		if (null == list || list.size() == 0)
			return str.toString();
		for (int i = 0; i < list.size(); i++) {
			if (i < list.size() - 1)
				str.append(list.get(i) + opeartor);
			else
				str.append(list.get(i));
		}
		return str.toString();
	}
	
	public static List<Long> StringToList(String str,String opeartor) {
		List<Long> list=new ArrayList<Long>();
		String[] strList=str.split(opeartor);
		for (String string : strList) {
			if(!StringUtil.isEmpty(string)){
				list.add(Long.parseLong(string));
			}
		}
		return list;
	}
	public static String listToString(List<Long> list,String opeartor) {
		StringBuffer string=new StringBuffer();
		for (Long long1 : list) {
			string.append(long1).append(opeartor);
		}
		String gString=string.toString().substring(0,string.lastIndexOf(opeartor));
		
		return gString;
	}
	public static List<String> StringToLists(String str,String opeartor) {
		List<String> list=new ArrayList<String>();
		String[] strList=str.split("\\"+opeartor);
		for (String string : strList) {
			if(!StringUtil.isEmpty(string)){
				list.add(string);
			}
		}
		return list;
	}
	
	/**
	 * 判断字符串是否为数字
	 * @param str
	 * @return
	 */
	public static boolean isInteger(String str) {  
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
        return pattern.matcher(str).matches();  
    }
	
	/**
	 * getStrSuffix:获取字符串后缀. <br/>
	 * @author Yunfei
	 * @param str
	 * @return .+后缀名: 如.txt
	 * @since JDK 1.8
	 */
	public static String getStrSuffix(String str){
		if(StringUtil.isBlank(str)){
			return "";
		}
		return str.substring(str.lastIndexOf("."), str.length());
	}
	
	/**
	 * getChinese:正则表达式过滤出中文字符. <br/>
	 * @author Yunfei
	 * @param str
	 * @return 中文字符串
	 * @since JDK 1.8
	 */
	public static String getChinese(String str){
		String reg = "[^\\u4e00-\\u9fa5]";
		str = str.replaceAll(reg, " ");
		return str;
	}
	
	/**根据html代码创建文件*/
	public static void createFileByString(File file,String html){
		FileOutputStream fileoutputstream = null;
		try {
			fileoutputstream = new FileOutputStream(file);
	        byte tag_bytes[] = html.getBytes();
	        fileoutputstream.write(tag_bytes);
	        fileoutputstream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(null!=fileoutputstream){
				try {
					fileoutputstream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
