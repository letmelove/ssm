package com.accp.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.accp.pojo.User;

public class Excel {
	public void exportexcel(List<User> list,HttpServletResponse resp) throws IOException {
		OutputStream os = null;
		os = resp.getOutputStream();
		resp.reset();

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("数据表");
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell = row.createCell(0);
		cell.setCellValue("编号");
		cell =  row.createCell(1);
		cell.setCellValue("姓名");
		cell =  row.createCell(2);
		cell.setCellValue("性别");
		for(int i=0;i<list.size();i++) {
			row = sheet.createRow(i+1);
			cell = row.createCell(0);
			cell.setCellValue(list.get(i).getId());
			cell = row.createCell(1);
			cell.setCellValue(list.get(i).getName());
			cell = row.createCell(2);
			cell.setCellValue(list.get(i).getSex());
		}
		
		String fileName = "用户信息.xlsx";
		
		//resp.setContentType(fileName);
		
		fileName = new String(fileName.getBytes("utf-8"),"ISO8859-1");
		//s以下载的形式打开文件
		resp.setHeader("Content-Disposition","attachment;filename="+fileName);
		wb.write(os);
		wb.close();
		/* 直接将文件导入到本地
		 * FileOutputStream fos=null;
		try {
			 fos = new FileOutputStream("d://test.xlsx");
			wb.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			fos.close();
		}*/
	}
}
