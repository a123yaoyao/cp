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

    private void dealWithTable(List<TabelTree> list,List<TabelTree> list1 ){
       list1.forEach(m->{
           if (m.getParentId().equals("0")){

           }else {
               setChild(m,m.getId(),list);
           }
       });
    }

    private void setChild(TabelTree tabelTree,String id, List<TabelTree> list) {
        List<TabelTree> children = new ArrayList<>();
        list.forEach(m->{
            if (id.equals(m.getParentId())){
                children.add(m);
            }
        });

        children.forEach(m->{
            setChild(m,m.getId(),list);
        });
        List<TabelTree> list2 =new ArrayList<TabelTree>();
        if (children.size() == 0) {
            list2.add(new TabelTree());
            tabelTree.setProducts(list2);
            return;
        }
        tabelTree.setProducts(children);
    }

}
