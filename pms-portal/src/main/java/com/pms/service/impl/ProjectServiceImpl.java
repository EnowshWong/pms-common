package com.pms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pms.mapper.PmsProjectMapper;
import com.pms.pojo.PageBean;
import com.pms.pojo.PmsProject;
import com.pms.pojo.PmsProjectExample;
import com.pms.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.EasyUIResult;
import pojo.PmsResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *     
 *   * @ProjectName:    pms
 *   * @Package:        com.pms.service.impl
 *   * @ClassName:      ${TYPE_NAME}
 *   * @Description:    
 *   * @Author:         Michoel
 *   * @CreateDate:     2018/3/10 21:56
 *   *
 **/
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private PmsProjectMapper pmsProjectMapper;

    @Override
    public PmsResult saveProject(PmsProject pmsProject) {
        pmsProjectMapper.insert(pmsProject);
        return PmsResult.ok();
    }

    @Override
    public EasyUIResult getProjectList(int page, int rows,long tutorId) {
        PmsProjectExample example=new PmsProjectExample();
        PmsProjectExample.Criteria criteria=example.createCriteria();
        criteria.andTutorIdEqualTo(tutorId);
        List<PmsProject> pmsProjects = pmsProjectMapper.selectByExampleWithBLOBs(example);
        PageHelper.startPage(page,rows);
        PageInfo<PmsProject> pageInfo=new PageInfo<PmsProject>(pmsProjects);
        long total=pageInfo.getTotal();
        EasyUIResult easyUIResult=new EasyUIResult(total,pmsProjects);
        return easyUIResult;
    }

    @Override
    public PmsResult updateProject(PmsProject pmsProject) {
        pmsProjectMapper.updateByPrimaryKeySelective(pmsProject);
        return PmsResult.ok();
    }

    @Override
    public PmsResult deleteProject(long id) {
        pmsProjectMapper.deleteByPrimaryKey(id);
        return PmsResult.ok();
    }

    @Override
    public PageBean<PmsProject> findByPage(int currPage) {
        Map<String,Object> map=new HashMap<>();
        PageBean<PmsProject> pageBean=new PageBean<>();
        pageBean.setCurrPage(currPage);
        int pageSize=10;
        pageBean.setPageSize(pageSize);
        PmsProjectExample example=new PmsProjectExample();
        int totalCount=pmsProjectMapper.countByExample(example);
        pageBean.setTotalCount(totalCount);
        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());
        map.put("start",(currPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        List<PmsProject> list = pmsProjectMapper.findByPage(map);
        pageBean.setLists(list);
        return pageBean;
    }
}
