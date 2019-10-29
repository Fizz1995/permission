package cn.tycoding.system.controller;

import java.util.Date;
import lombok.Data;

/**
 * 基础数据类
 *
 * @author Jiaju Zhuang
 **/
@Data
public class DownloadData {

	@ExcelValue(value = "字符标题,")
	private String string;
	@ExcelValue(value = "数字标题,")
	private Date date;
	@ExcelValue(value = "日期标题")
	private Double doubleData;
}
