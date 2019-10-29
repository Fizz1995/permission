package cn.tycoding.system.controller;

import com.alibaba.excel.annotation.ExcelProperty;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName Head
 * @Description 基于EasyExcel 生成Head并导出
 * @Author Lee
 * @Date 2019/10/28 16:06
 */
public class ExcelHead {

	/**
	 * @Description: 生成Head
	 * @Param: [fileName, startTime, endTime, clazz]
	 * @Return: java.util.List<java.util.List < java.lang.String>>
	 * @Author: Lee
	 * @Date: 2019/10/28 16:06
	 **/
	public static List<List<String>> getHead(String fileName, String startTime, String endTime,
			Class clazz) {
		List<List<String>> lists = new ArrayList<>();
		String name = getTitle(fileName, startTime, endTime);
		List<String> list = new ArrayList<>();
		for (Field field : clazz.getDeclaredFields()) {
			boolean flag = field.isAnnotationPresent(ExcelProperty.class);
			if (flag) {
				ExcelProperty excelValue = field.getAnnotation(ExcelProperty.class);
				//输出注解属性
				String[] value = excelValue.value();
				list.add(value[0]);
			}
		}
		//注解属性循环拼接 放入List<String>
		for (String s : list) {
			List<String> strings = new ArrayList<>();
			strings.add(name);
			strings.add(s);
			lists.add(strings);
		}
		return lists;
	}

	/**
	 * @Description: 生成Title
	 * @Param: [title, startTime, endTime]
	 * @Return: java.lang.String
	 * @Author: Lee
	 * @Date: 2019/10/28 16:06
	 **/
	public static String getTitle(String title, String startTime, String endTime) {
		String to = "至";
		String now = "今";
		if (startTime == null && endTime == null) {
			title = title + "";
		} else if (startTime == null) {
			title = title + to + endTime;
		} else if (endTime == null) {
			title = title + startTime + to + now;
		} else if (startTime != null && endTime != null) {
			title = title + startTime + to + endTime;
		}
		return title;
	}

	/**
	 * @Description: 设置response
	 * @Param: [response, fileName]
	 * @Return: void
	 * @Author: Lee
	 * @Date: 2019/10/29 10:22
	 **/
	public static void response(HttpServletResponse response, String fileName) {
		response.setContentType("application/vnd.ms-excel");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
	}

	/**
	 * 动态head
	 */
	public static List<List<String>> getListString(List<String> list) {
		List<List<String>> lists = new ArrayList<>();
		for (String s : list) {
			List<String> string = new ArrayList<>();
			string.add(s);
			lists.add(string);
		}
		return lists;
	}
}
