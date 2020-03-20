package com.starvincci.qrcodeadmin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.starvincci.qrcodeadmin.pojo.Prdmoedl;
import com.starvincci.qrcodeadmin.pojo.QRParam;
import com.starvincci.qrcodeadmin.pojo.Scandata;
import com.starvincci.qrcodeadmin.service.ScandataService;
import com.starvincci.qrcodeadmin.service.ScandataServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

//运行时在pom文件中加入新的依赖需要重启项目，不重启重新编译会出现java.lang.NoClassDefFoundError
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
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:MM");//设置日期格式
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
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
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
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
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

        Scandata scandata = new Scandata();
        scandata.setZerodate(qrParam.getStartDate());
        scandata.setRecdate(qrParam.getEndDate());
        scandata.setWorkno(qrParam.getJobNum());
        List<Scandata> list = scandataService.selectScandaaByDate(scandata);
        System.out.println(list.size());
        String jsonstr = JSON.toJSONString(list);
        System.out.println(jsonstr);
        return jsonstr;
    }

    @RequestMapping("/getmingxi")
    @ResponseBody
    public String getmingxi(@RequestBody String jsons) {
        Scandata scandata = JSON.parseObject(jsons, Scandata.class);
        List<Scandata> list = scandataService.selectScandInfo(scandata);
        System.out.println(list.size());
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

}
