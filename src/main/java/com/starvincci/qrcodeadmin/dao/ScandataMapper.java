package com.starvincci.qrcodeadmin.dao;

import com.starvincci.qrcodeadmin.pojo.Prdmoedl;
import com.starvincci.qrcodeadmin.pojo.Scandata;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

}
