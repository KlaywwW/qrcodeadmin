package com.starvincci.qrcodeadmin.dao;

import com.starvincci.qrcodeadmin.pojo.Employee;
import com.starvincci.qrcodeadmin.pojo.Prdmoedl;
import com.starvincci.qrcodeadmin.pojo.Prdno;
import com.starvincci.qrcodeadmin.pojo.Scandata;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jdp
 */
@Mapper
public interface ScandataMapper {

    /**
     * 添加扫描结果到数据库中
     * @param scandata
     * @return
     */
    int addScandata(Scandata scandata);

    /**
     * 查询是否已经在数据库中避免重复扫码
     * @param scandata
     * @return
     */
    Scandata checkOnly(Scandata scandata);

    /**
     * 查询扫描者所描出的结果展示，分组查询
     * @param scandata
     * @return
     */
    List<Scandata> selectScandataByworkNo(Scandata scandata);

    /**
     * 查询指定时间段的特定工号的信息集合
     * @param scandata 开始时间 结束时间 工号
     * @return
     */
    List<Scandata> selectScandaaByDate(Scandata scandata);

    /**
     * 查询明细
     * @param scandata
     * @return
     */
    List<Scandata> selectScandInfo(Scandata scandata);

    /**
     * 获取工序号
     * @param facno 款号
     * @return
     */
    List<Process> getPrdmoedl(@Param("facno") String facno);

    /**
     * 查询用户姓名
     * @param workno 工号
     * @return
     */
    Employee selectname(String workno);

    /**
     * 查询所有制单信息
     * @return
     */
    List<Prdno> selectPrd();

    /**
     * 查询款号
     * @param prdno 制单号
     * @return
     */
    Prdno selectPrdByprdno(String prdno);

    /**
     * 查询扫码数据中的
     * @param facno 款号
     * @return
     */
    List<Scandata> getdataByfacno(String facno);

    /**
     * 获取所有制单数据
     * @return
     */
    List<Prdno> getAllprd();

    /**
     * 根据制单号查询工序，查询名字等
     * @param prdno 制单号
     * @return
     */
    List<Scandata> querySeq(@Param("prdno") String prdno,@Param("seq")String seq,@Param("bedno")String bedno);



}
