package com.cn.count.service;


import com.cn.count.model.TabelTree;

import java.util.List;
import java.util.Map;

public interface TableTreeService {

    public List<TabelTree> getTabelTree();

    List<Map<String ,Object>>  getTableByName(String tableName);
}
