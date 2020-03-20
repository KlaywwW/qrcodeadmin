package com.starvincci.qrcodeadmin.service;

import com.starvincci.qrcodeadmin.dao.ScandataMapper;
import com.starvincci.qrcodeadmin.pojo.Prdmoedl;
import com.starvincci.qrcodeadmin.pojo.Scandata;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
}
