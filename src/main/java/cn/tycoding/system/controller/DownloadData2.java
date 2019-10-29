package cn.tycoding.system.controller;

import com.alibaba.excel.annotation.ExcelProperty;
import java.util.Date;
import lombok.Data;

/**
 * 基础数据类
 *
 * @author Jiaju Zhuang
 **/
@Data
public class DownloadData2 {
    @ExcelProperty(value = "字符")
    private String string;
    @ExcelProperty(value = "日期")
    private Date date;
    @ExcelProperty(value = "数字")
    private Double doubleData;
}
