package com.lening.controller;

import com.github.pagehelper.PageInfo;
import com.lening.entity.CompanyBean;
import com.lening.entity.ManagerBean;
import com.lening.service.ManagerService;
import com.lening.utils.ResultInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Resource
    private ManagerService managerService;



    @RequestMapping("/saveOrUpdateGoods")
    public ResultInfo saveOrUpdateGoods(@RequestBody CompanyBean companyBean){
        try{
            managerService.saveOrUpdateGoods(companyBean);
            return new ResultInfo(true,"编辑成功");
        }catch (Exception e){
            return new ResultInfo(false,"编辑失败");
        }
    }

    @RequestMapping("/deleteAll")
    public ResultInfo deleteAll(@RequestBody Long[] cids){
        try{
            managerService.deleteAll(cids);
            return new ResultInfo(true,"ok");
        }catch (Exception e){
            return new ResultInfo(false,"删除失败");
        }
    }

    @RequestMapping("/findAllConnAndPage")
    public PageInfo<CompanyBean> getCarList(@RequestBody CompanyBean searchEntity,
                                            @RequestParam(defaultValue = "1") Integer pageNum,
                                            @RequestParam(defaultValue = "2") Integer pageSize){
        return managerService.findAllConnAndPage(searchEntity,pageNum,pageSize);
    }

    @RequestMapping("/login")
    public String login(@RequestBody ManagerBean managerBean){
        ManagerBean manager=managerService.toLogin(managerBean);
        if(manager!=null){
            return "ok";
        }else{
            return "no";
        }
    }
}
