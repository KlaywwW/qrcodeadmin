package com.starvincci.qrcodeadmin;

import com.starvincci.qrcodeadmin.pojo.Scandata;
import com.starvincci.qrcodeadmin.service.ScandataServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootTest
class QrcodeadminApplicationTests {

	private ScandataServiceImpl scandataService;

	@Test
	void contextLoads() {
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//		String nextDay=null;
//		try {
//			Date date=sdf.parse("2020-03-24 14:20:00");
//			Calendar cld = Calendar.getInstance();
//			cld.setTime(date);
//			cld.add(Calendar.DATE, 1);
//			date = cld.getTime();
//			//获得下一天日期字符串
//			nextDay = sdf.format(date);
//
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		System.out.println("时间------"+nextDay);
	}

}
