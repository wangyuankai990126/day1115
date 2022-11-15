package com.lening.mapper;

import com.lening.entity.ManagerBean;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface ManagerMapper extends Mapper<ManagerBean> {

    @Select("select*from tb_manager where username=#{username} and password=#{password}")
    ManagerBean toLogin(ManagerBean managerBean);
}
