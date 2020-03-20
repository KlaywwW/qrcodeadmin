package com.starvincci.qrcodeadmin.pojo;

public class QRParam {
    private String strs;//扫描的结果
    private String jobNum;//扫描时输入的工号
    private String  facnostr;//工序字符串
    private String startDate;//开始时间
    private String endDate;//结束时间

    @Override
    public String toString() {
        return "QRParam{" +
                "strs='" + strs + '\'' +
                ", jobNum='" + jobNum + '\'' +
                ", facnostr='" + facnostr + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }

    public String getFacnostr() {
        return facnostr;
    }

    public void setFacnostr(String facnostr) {
        this.facnostr = facnostr;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStrs() {
        return strs;
    }

    public void setStrs(String strs) {
        this.strs = strs;
    }

    public String getJobNum() {
        return jobNum;
    }

    public void setJobNum(String jobNum) {
        this.jobNum = jobNum;
    }
}
