package cn.tycoding.system.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MyTest {


	public static void main(String[] args) {
		Class<DownloadData> clz = DownloadData.class;
		Field[] fields = clz.getDeclaredFields();
		List<List<String>> lists = new ArrayList<>();
		String name = ExcelHead.getTitle("统计", "2010", "2020");
		String[] array = {"字符标题", "数字标题", "日期标题"};
		for (String s : array) {
			List<String> strings = new ArrayList<>();
			strings.add(name);
			strings.add(s);
			lists.add(strings);
		}
		System.out.println(lists);
		/*Class<DownloadData2> aClass = DownloadData2.class;
		Field[] f = aClass.getDeclaredFields();
		for (Field field : f) {
			boolean fieldHasAnno = field.isAnnotationPresent(ExcelProperty.class);
			if (fieldHasAnno) {
				ExcelProperty excelValue = field.getAnnotation(ExcelProperty.class);
				//输出注解属性
				String[] value = excelValue.value();
				List<String> list = Arrays.asList(value);

				System.out.println("-----------" + list + "长度" + list.size());
			}
		}*/
	}

}
