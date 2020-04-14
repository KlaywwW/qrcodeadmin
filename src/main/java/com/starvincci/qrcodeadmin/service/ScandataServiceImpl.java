package com.starvincci.qrcodeadmin.service;

import com.starvincci.qrcodeadmin.dao.ScandataMapper;
import com.starvincci.qrcodeadmin.pojo.Employee;
import com.starvincci.qrcodeadmin.pojo.Prdmoedl;
import com.starvincci.qrcodeadmin.pojo.Prdno;
import com.starvincci.qrcodeadmin.pojo.Scandata;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jdp
 */
@Service
public class ScandataServiceImpl implements ScandataService {

    @Resource
    private ScandataMapper scandataMapper;

    @Override
    public int addScandata(Scandata scandata) {
        return scandataMapper.addScandata(scandata);
    }

    @Override
    public Scandata checkOnly(Scandata scandata) {
        return scandataMapper.checkOnly(scandata);
    }

    @Override
    public List<Scandata> selectScandataByworkNo(Scandata scandata) {
        return scandataMapper.selectScandataByworkNo(scandata);
    }

    @Override
    public List<Scandata> selectScandaaByDate(Scandata scandata) {
        return scandataMapper.selectScandaaByDate(scandata);
    }

    @Override
    public List<Scandata> selectScandInfo(Scandata scandata) {
        return scandataMapper.selectScandInfo(scandata);
    }

    @Override
    public List<Process> getPrdmoedl(String facno) {
        return scandataMapper.getPrdmoedl(facno);
    }

    @Override
    public Employee selectname(String workno) {
        return scandataMapper.selectname(workno);
    }

    @Override
    public Employee selectworkNo(String name) {
        return scandataMapper.selectworkNo(name);
    }

    @Override
    public Integer selectMaxWorkNo() {
        return scandataMapper.selectMaxWorkNo();
    }

    @Override
    public int insertEmp(Employee employee) {
        return scandataMapper.insertEmp(employee);
    }

    @Override
    public List<Prdno> getAllprd() {
        return scandataMapper.getAllprd();
    }

    @Override
    public Prdno selectPrdByprdno(String prdno) {
        return scandataMapper.selectPrdByprdno(prdno);
    }

    @Override
    public List<Scandata> getdataByfacno(Prdno prd) {
        return scandataMapper.getdataByfacno(prd);
    }

    @Override
    public List<Scandata> querySeq(String prdno, String seq, String bedno) {
        System.out.println("size------"+scandataMapper.querySeq(prdno,seq,bedno).size());
        return scandataMapper.querySeq(prdno,seq,bedno);
    }

}
