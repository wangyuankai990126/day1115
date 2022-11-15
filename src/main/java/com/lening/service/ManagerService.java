package com.lening.service;

import com.github.pagehelper.PageInfo;
import com.lening.entity.CompanyBean;
import com.lening.entity.ManagerBean;

public interface ManagerService {
    ManagerBean toLogin(ManagerBean managerBean);

    PageInfo<CompanyBean> findAllConnAndPage(CompanyBean searchEntity, Integer pageNum, Integer pageSize);

    void deleteAll(Long[] cids);

    void saveOrUpdateGoods(CompanyBean companyBean);
}
