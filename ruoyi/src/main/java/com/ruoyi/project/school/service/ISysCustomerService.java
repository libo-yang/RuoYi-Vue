package com.ruoyi.project.school.service;

import java.util.List;
import com.ruoyi.project.school.domain.SysCustomer;

/**
 * 客户Service接口
 * 
 * @author lbyang
 * @date 2020-07-17
 */
public interface ISysCustomerService 
{
    /**
     * 查询客户
     * 
     * @param customerId 客户ID
     * @return 客户
     */
    public SysCustomer selectSysCustomerById(Long customerId);

    /**
     * 查询客户列表
     * 
     * @param sysCustomer 客户
     * @return 客户集合
     */
    public List<SysCustomer> selectSysCustomerList(SysCustomer sysCustomer);

    /**
     * 新增客户
     * 
     * @param sysCustomer 客户
     * @return 结果
     */
    public int insertSysCustomer(SysCustomer sysCustomer);

    /**
     * 修改客户
     * 
     * @param sysCustomer 客户
     * @return 结果
     */
    public int updateSysCustomer(SysCustomer sysCustomer);

    /**
     * 批量删除客户
     * 
     * @param customerIds 需要删除的客户ID
     * @return 结果
     */
    public int deleteSysCustomerByIds(Long[] customerIds);

    /**
     * 删除客户信息
     * 
     * @param customerId 客户ID
     * @return 结果
     */
    public int deleteSysCustomerById(Long customerId);
}
