package com.cn.count.dao;

import com.cn.count.model.CwrProject;
import java.util.List;

public interface CwrProjectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cwr_project
     *
     * @mbg.generated
     */
    int insert(CwrProject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cwr_project
     *
     * @mbg.generated
     */
    List<CwrProject> selectAll();
}