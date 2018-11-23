package com.cn.count.service;

import com.cn.count.model.SysParams;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/11/22/022 17:10
 * @Description:
 */
public interface ParamService {

    List<SysParams> findAll();

    PageInfo<SysParams> findPage();
}
