package cn.tycoding.system.controller;

import cn.tycoding.system.entity.User;
import cn.tycoding.system.service.UserService;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("excel")
public class ExcelApi {

	@Autowired
	private UserService service;

	@GetMapping("download")
	public void download(HttpServletResponse response, User user) {
		try {
			//待导出的List数据
			List<User> dataList = service.list(user);
			String fileName = URLEncoder.encode("测试", "UTF-8");
			//设置相关response参数
			ExcelHead.response(response,fileName);
			// 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
			String title = "测试时间";
			EasyExcel.write(response.getOutputStream())
					.head(ExcelHead.getHead(title, "2010-10-01", "2020-10-10", User.class))
					.registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()).sheet("模板")
					.doWrite(dataList);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
