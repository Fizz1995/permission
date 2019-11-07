package cn.tycoding.system.controller;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;

public class MyTest {


	public static void main(String[] args) {
		String s = "[3d55f2a141e84394abf6e98b9de8f8fa,42cae3e0a96642c3ae5e373b8dfb330c,2]";
		//List<String> list = JSON.parseArray(s, String.class);
		//System.out.println(list);
		String a = "3d55f2a141e84394abf6e98b9de8f8fa";
		String a1 = "42cae3e0a96642c3ae5e373b8dfb330c";
		String a2 = "0";
		List<String> aList = new ArrayList<>();
		aList.add(a);
		aList.add(a1);
		aList.add(a2);
		System.out.println(aList);
		String s1 = JSON.toJSONString(aList);
		System.err.println(s1);


	}

}
