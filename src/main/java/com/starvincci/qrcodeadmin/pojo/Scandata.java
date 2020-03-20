package com.starvincci.qrcodeadmin.pojo;


public class Scandata {

  private Integer id;
  private String workno;//工号
  private String prdno;//制单
  private String facno;//款号
  private Integer bedno;//床号
  private Integer seq;//扎号
  private String color;
  private String size;
  private String item;//工序
  private String descn;
  private Integer qty;//数量
  private Integer recqty;
  private String recdate;//日期
  private String zerodate;//当日0点
  private String sumqty;//总和

  @Override
  public String toString() {
    return "Scandata{" +
            "id=" + id +
            ", workno='" + workno + '\'' +
            ", prdno='" + prdno + '\'' +
            ", facno='" + facno + '\'' +
            ", bedno=" + bedno +
            ", seq=" + seq +
            ", color='" + color + '\'' +
            ", size='" + size + '\'' +
            ", item='" + item + '\'' +
            ", descn='" + descn + '\'' +
            ", qty=" + qty +
            ", recqty=" + recqty +
            ", recdate='" + recdate + '\'' +
            ", zerodate='" + zerodate + '\'' +
            ", sumqty='" + sumqty + '\'' +
            '}';
  }

  public String getSumqty() {
    return sumqty;
  }

  public void setSumqty(String sumqty) {
    this.sumqty = sumqty;
  }

  public String getZerodate() {
    return zerodate;
  }

  public void setZerodate(String zerodate) {
    this.zerodate = zerodate;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getWorkno() {
    return workno;
  }

  public void setWorkno(String workno) {
    this.workno = workno;
  }


  public String getPrdno() {
    return prdno;
  }

  public void setPrdno(String prdno) {
    this.prdno = prdno;
  }


  public String getFacno() {
    return facno;
  }

  public void setFacno(String facno) {
    this.facno = facno;
  }


  public Integer getBedno() {
    return bedno;
  }

  public void setBedno(Integer bedno) {
    this.bedno = bedno;
  }


  public Integer getSeq() {
    return seq;
  }

  public void setSeq(Integer seq) {
    this.seq = seq;
  }


  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }


  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
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


  public Integer getQty() {
    return qty;
  }

  public void setQty(Integer qty) {
    this.qty = qty;
  }


  public Integer getRecqty() {
    return recqty;
  }

  public void setRecqty(Integer recqty) {
    this.recqty = recqty;
  }


  public String getRecdate() {
    return recdate;
  }

  public void setRecdate(String recdate) {
    this.recdate = recdate;
  }

}
