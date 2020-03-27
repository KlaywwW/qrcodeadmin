package com.starvincci.qrcodeadmin.pojo;

/**
 * @author jdp
 */
public class Prdmoedl {

    private String facno;//款号
    private String item;//工序
    private String descn;//工序名称
    private double price;//价格

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescn() {
        return descn;
    }

    public void setDescn(String descn) {
        this.descn = descn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
