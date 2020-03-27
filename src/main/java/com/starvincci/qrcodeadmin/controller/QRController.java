package com.starvincci.qrcodeadmin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.starvincci.qrcodeadmin.pojo.*;
import com.starvincci.qrcodeadmin.service.ScandataService;
import com.starvincci.qrcodeadmin.service.ScandataServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

//运行时在pom文件中加入新的依赖需要重启项目，不重启重新编译会出现java.lang.NoClassDefFoundError

/**
 * @author jdp
 */
@Controller
public class QRController {

    @Resource
    private ScandataServiceImpl scandataService;

    @RequestMapping("/home")
    @ResponseBody
    public int show(@RequestBody String strs) {
        System.out.println("str---" + strs);
        QRParam qrParam = JSON.parseObject(strs, QRParam.class);
        System.out.println(qrParam.toString());
        //截取二维码信息
        String str = qrParam.getStrs();
        String[] splitstr = str.split("@");
        int splistlength = splitstr.length;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String time = df.format(new Date());// new Date()为获取当前系统时间

        Scandata scandata = null;
        if (splistlength == 5) {
            //截取工序信息
            String strfacno = qrParam.getFacnostr();
            String[] splitno = strfacno.split("\\+");
            int splitnolength = splitno.length;

            for (int i = 0; i < splitnolength; i++) {


                scandata = new Scandata();
                //二维码数据
                scandata.setPrdno(splitstr[0]);
                scandata.setFacno(splitstr[1]);
                scandata.setBedno(Integer.parseInt(splitstr[2]));
                scandata.setSeq(Integer.parseInt(splitstr[3]));
                scandata.setQty(Integer.parseInt(splitstr[4]));
                //循环添加工序
                scandata.setItem(splitno[i]);
                //工号
                scandata.setWorkno(qrParam.getJobNum());
                //日期
                scandata.setRecdate(time);
                scandata.setRecdate1(time);
                Scandata scan = scandataService.checkOnly(scandata);
                if (scan == null) {
                    //添加
                    int res = scandataService.addScandata(scandata);
                    if (res > 0) {
                        System.out.println("添加成功");
                    }
                    System.out.println(scandata.toString());
                } else {
                    System.out.println("该数据已存在");
                    return 0;
                }
            }


        } else if (splistlength == 6) {
            scandata = new Scandata();
            //二维码数据
            scandata.setPrdno(splitstr[0]);
            scandata.setFacno(splitstr[1]);
            scandata.setBedno(Integer.parseInt(splitstr[2]));
            scandata.setSeq(Integer.parseInt(splitstr[3]));
            scandata.setItem(splitstr[4]);
            scandata.setQty(Integer.parseInt(splitstr[5]));
            //工号
            scandata.setWorkno(qrParam.getJobNum());
            //日期
            scandata.setRecdate(time);
            scandata.setRecdate1(time);
            Scandata scan = scandataService.checkOnly(scandata);
            if (scan == null) {
                //添加
                int res = scandataService.addScandata(scandata);
                if (res > 0) {
                    System.out.println("添加成功");
                }
            } else {
                System.out.println("该数据已存在");
                return 0;
            }

        }
        return 1;
    }

    @RequestMapping("/get")
    @ResponseBody
    public String getinfo(@RequestBody String workno) {
        System.out.println(workno);
        Scandata scandata = new Scandata();
        scandata.setWorkno(workno);
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String time = df2.format(new Date());
        scandata.setRecdate(time);

        //前一天
        //Calendar calendar =new GregorianCalendar();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date zero = calendar.getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String zerotime = df.format(zero);
        scandata.setZerodate(zerotime);

        List<Scandata> list = scandataService.selectScandataByworkNo(scandata);
        String jsonstr = JSON.toJSONString(list);
        System.out.println(jsonstr);
        return jsonstr;
    }

    @RequestMapping("/getBydate")
    @ResponseBody
    public String getinfoBydate(@RequestBody String jsons) {
        QRParam qrParam = JSON.parseObject(jsons, QRParam.class);
        System.out.println(qrParam.toString());
        System.out.println(jsons);
        Scandata scandata = new Scandata();
        scandata.setZerodate(qrParam.getStartDate());
        String d=qrParam.getEndDate();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String nextDay=null;
        try {
            Date date=sdf.parse(d);
            Calendar cld = Calendar.getInstance();
            cld.setTime(date);
            cld.add(Calendar.DATE, 1);
            date = cld.getTime();
            //获得下一天日期字符串
            nextDay = sdf.format(date);
            System.out.println("-----"+nextDay);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(nextDay);

        scandata.setRecdate(qrParam.getEndDate());
        scandata.setWorkno(qrParam.getJobNum());
        List<Scandata> list = scandataService.selectScandaaByDate(scandata);
        for (Scandata sca:list) {
            System.out.println(sca.getRecdate1());
        }
        System.out.println(list.size());
        String jsonstr = JSON.toJSONString(list);
        System.out.println(jsonstr);
        return jsonstr;
    }

    @RequestMapping("/getmingxi")
    @ResponseBody
    public String getmingxi(@RequestBody String jsons) {
        Scandata scandata = JSON.parseObject(jsons, Scandata.class);
        System.out.println(scandata.toString());
        List<Scandata> list = scandataService.selectScandInfo(scandata);


        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        List<Scandata> list2=new ArrayList<>();
//        for (Scandata scan:list) {
//
//            Date date= null;
//            try {
//                date = df.parse(scan.getRecdate());
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//
//            String redate = df.format(date);
//            scan.setRecdate(redate);
//            list2.add(scan);
//        }
//        System.out.println(list2.size());


        String jsonstr = JSON.toJSONString(list);
        System.out.println(jsonstr);
        return jsonstr;
    }

    @RequestMapping("/getfacno")
    @ResponseBody
    public String getfacno(@RequestBody String facno) {
        System.out.println(facno);
        List<Process> list = scandataService.getPrdmoedl(facno);
        String jsonstr = JSON.toJSONString(list);
        System.out.println(jsonstr);
        return jsonstr;
    }

    @RequestMapping("/getname")
    @ResponseBody
    public String getname(@RequestBody String name){
//        System.out.println(name);
        Employee employee=scandataService.selectname(name);
        return employee.getName();
    }

    @RequestMapping("/getfac")
    @ResponseBody
    public String getfac(@RequestBody String prdno){
//        查出制单表的所有信息
        Prdno prd=scandataService.selectPrdByprdno(prdno);

        List<Scandata> list=scandataService.getdataByfacno(prd.getFacno());

        String jsonstr = JSON.toJSONString(list);

        return jsonstr;
    }

    @RequestMapping("/getfacother")
    @ResponseBody
    public String getother(@RequestBody String prdno){
        Prdno prd=scandataService.selectPrdByprdno(prdno);
        String jsonstr=JSON.toJSONString(prd);
        return jsonstr;
    }


    @RequestMapping("/getprd")
    @ResponseBody
    public String getprd(){
        List<Prdno> prdlist=scandataService.getAllprd();
        String jsonstr = JSON.toJSONString(prdlist);
        return jsonstr;
    }

}
