package cn.tycoding.system.controller;

import com.alibaba.excel.annotation.ExcelProperty;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MyTest2 {

	public static void main(String[] args) {
		Class<DownloadData2> aClass = DownloadData2.class;
		Field[] f = aClass.getDeclaredFields();
		List<String> list = new ArrayList<>();
		for (Field field : f) {
			boolean b = field.isAnnotationPresent(ExcelProperty.class);
			if (b) {
				ExcelProperty excelValue = field.getAnnotation(ExcelProperty.class);
				//输出注解属性
				String[] value = excelValue.value();
				list.add(value[0]);
			}
		}
		System.out.println(list);
/*
		Class<DownloadData> c = DownloadData.class;
		Field[] cd = c.getDeclaredFields();
		for (Field field : cd) {
			boolean fieldHasAnno = field.isAnnotationPresent(ExcelValue.class);
			if (fieldHasAnno) {
				ExcelValue excelValue = field.getAnnotation(ExcelValue.class);
				//输出注解属性
				String value = excelValue.value();
				System.out.println("-----------" + value);
			}
		}*/
	}
}
