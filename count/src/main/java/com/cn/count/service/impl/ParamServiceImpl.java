package com.cn.count.service.impl;

import com.cn.count.dao.SysParamsMapper;
import com.cn.count.model.SysParams;
import com.cn.count.service.ParamService;
import com.gitee.fastmybatis.core.query.Query;
import com.gitee.fastmybatis.core.util.MapperUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.gitee.fastmybatis.core.util.MapperUtil.query;

/**
 * @Auther: Administrator
 * @Date: 2018/11/22/022 17:10
 * @Description:
 */
@Service
public class ParamServiceImpl implements ParamService {

    @Autowired
    SysParamsMapper paramsMapper;

    @Override
    public List<SysParams> findAll() {
        return paramsMapper.selectAll();
    }

    @Override
    public PageInfo<SysParams> findPage() {
        PageHelper.startPage(1,10);
        List<SysParams> list = findAll();
        PageInfo<SysParams> page = new PageInfo<>(list);
        return page;
    }
}
