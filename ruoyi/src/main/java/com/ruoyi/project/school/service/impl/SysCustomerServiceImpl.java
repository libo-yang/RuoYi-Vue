package com.ruoyi.project.school.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.school.mapper.SysCustomerMapper;
import com.ruoyi.project.school.domain.SysCustomer;
import com.ruoyi.project.school.service.ISysCustomerService;

/**
 * 客户Service业务层处理
 * 
 * @author lbyang
 * @date 2020-07-17
 */
@Service
public class SysCustomerServiceImpl implements ISysCustomerService 
{
    @Autowired
    private SysCustomerMapper sysCustomerMapper;

    /**
     * 查询客户
     * 
     * @param customerId 客户ID
     * @return 客户
     */
    @Override
    public SysCustomer selectSysCustomerById(Long customerId)
    {
        return sysCustomerMapper.selectSysCustomerById(customerId);
    }

    /**
     * 查询客户列表
     * 
     * @param sysCustomer 客户
     * @return 客户
     */
    @Override
    public List<SysCustomer> selectSysCustomerList(SysCustomer sysCustomer)
    {
        return sysCustomerMapper.selectSysCustomerList(sysCustomer);
    }

    /**
     * 新增客户
     * 
     * @param sysCustomer 客户
     * @return 结果
     */
    @Override
    public int insertSysCustomer(SysCustomer sysCustomer)
    {
        return sysCustomerMapper.insertSysCustomer(sysCustomer);
    }

    /**
     * 修改客户
     * 
     * @param sysCustomer 客户
     * @return 结果
     */
    @Override
    public int updateSysCustomer(SysCustomer sysCustomer)
    {
        return sysCustomerMapper.updateSysCustomer(sysCustomer);
    }

    /**
     * 批量删除客户
     * 
     * @param customerIds 需要删除的客户ID
     * @return 结果
     */
    @Override
    public int deleteSysCustomerByIds(Long[] customerIds)
    {
        return sysCustomerMapper.deleteSysCustomerByIds(customerIds);
    }

    /**
     * 删除客户信息
     * 
     * @param customerId 客户ID
     * @return 结果
     */
    @Override
    public int deleteSysCustomerById(Long customerId)
    {
        return sysCustomerMapper.deleteSysCustomerById(customerId);
    }
}
