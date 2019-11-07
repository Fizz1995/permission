package cn.tycoding.jar;

import cn.tycoding.system.entity.User;
import org.springframework.beans.BeanUtils;

public class JavaTest {

	public static void main(String[] args) {
		User user = new User();
		user.setUsername("张三");
		user.setId(1L);
		User u = new User();
		BeanUtils.copyProperties(user, u);
		System.out.println(user);
		System.out.println("u" + "===========" + u);
	}
}
