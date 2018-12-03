package com.cn.count.service.impl;

import com.cn.count.dao.TabelTreeMapper;
import com.cn.count.model.TabelTree;
import com.cn.count.service.TableTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TableTreeServiceImpl implements TableTreeService {

    @Autowired
    TabelTreeMapper tabelTreeMapper;

    @Override
    public List<TabelTree> getTabelTree() {
        int level =1;
        List<TabelTree> list = tabelTreeMapper.selectAll();
        List<TabelTree> root = tabelTreeMapper.selectAllLevelOne(level);
        //循环根节点 对每一个根节点进行递归设置子节点
        for (TabelTree m : root) {
            setChild(  m,m.getId(),list);
        }
        return root;
    }

    @Override
    public  List<Map<String ,Object>>  getTableByName(String tabelName) {
        List<Map<String ,Object>> list= tabelTreeMapper.getTableByName(tabelName);
        list.forEach(m->{
            if (!m.containsKey("CHARACTER_MAXIMUM_LENGTH")){
                m.put("CHARACTER_MAXIMUM_LENGTH","");
            }
            if (!m.containsKey("NUMERIC_PRECISION")){
                m.put("NUMERIC_PRECISION","");
            }
            if (!m.containsKey("COLUMN_DEFAULT")){
                m.put("COLUMN_DEFAULT","");
            }
        });
        return list;
    }


    /**
     * 递归设置子节点
     * @param tabelTree 树结构某个父节点
     * @param id       当前节点的id
     * @param list     树结构所有数据
     */
    private void setChild(TabelTree tabelTree,String id, List<TabelTree> list) {
        List<TabelTree> children = new ArrayList<>();
        //循环树结构 给当前id所属的节点设置子节点
        list.forEach(m->{
            if (id.equals(m.getParentId())){
                children.add(m);
            }
        });

        //循环当前节点的子节点 设置当前节点子节点的子孙节点
        children.forEach(m->{
            setChild(m,m.getId(),list);
        });

        //若当前节点的子节点为空 则new 一个新的对象
        List<TabelTree> list2 =new ArrayList<TabelTree>();
        if (children.size() == 0) {
            list2.add(new TabelTree());
            tabelTree.setProducts(list2);
            return;
        }
        //设置子节点
        tabelTree.setProducts(children);
    }

}
