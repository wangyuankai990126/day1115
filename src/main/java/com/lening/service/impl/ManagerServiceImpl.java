package com.lening.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lening.entity.CompanyBean;
import com.lening.entity.ManagerBean;
import com.lening.mapper.CompanyMapper;
import com.lening.mapper.ManagerMapper;
import com.lening.service.ManagerService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Resource
    private ManagerMapper managerMapper;

    @Resource
    private CompanyMapper companyMapper;


    @Override
    public void saveOrUpdateGoods(CompanyBean companyBean) {
        if(companyBean != null){
            if(companyBean.getId()!= null){
                companyMapper.updateByPrimaryKeySelective(companyBean);
            }else {
                companyMapper.insertSelective(companyBean);
            }
        }
    }

    @Override
    public ManagerBean toLogin(ManagerBean managerBean) {
        return managerMapper.toLogin(managerBean);
    }

    @Override
    public PageInfo<CompanyBean> findAllConnAndPage(CompanyBean searchEntity, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(CompanyBean.class);
        Example.Criteria criteria = example.createCriteria();

        List<CompanyBean> list = companyMapper.selectByExample(example);

        PageInfo<CompanyBean> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void deleteAll(Long[] cids) {
        if(cids != null&&cids.length>=1){
            for (Long cid : cids) {
                companyMapper.deleteByPrimaryKey(cid);
            }
        }
    }
}
