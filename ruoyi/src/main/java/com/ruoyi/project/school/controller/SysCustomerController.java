package com.ruoyi.project.school.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.school.domain.SysCustomer;
import com.ruoyi.project.school.service.ISysCustomerService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 客户Controller
 * 
 * @author lbyang
 * @date 2020-07-17
 */
@RestController
@RequestMapping("/school/customer")
public class SysCustomerController extends BaseController
{
    @Autowired
    private ISysCustomerService sysCustomerService;

    /**
     * 查询客户列表
     */
    @PreAuthorize("@ss.hasPermi('school:customer:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysCustomer sysCustomer)
    {
        startPage();
        List<SysCustomer> list = sysCustomerService.selectSysCustomerList(sysCustomer);
        return getDataTable(list);
    }

    /**
     * 导出客户列表
     */
    @PreAuthorize("@ss.hasPermi('school:customer:export')")
    @Log(title = "客户", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysCustomer sysCustomer)
    {
        List<SysCustomer> list = sysCustomerService.selectSysCustomerList(sysCustomer);
        ExcelUtil<SysCustomer> util = new ExcelUtil<SysCustomer>(SysCustomer.class);
        return util.exportExcel(list, "customer");
    }

    /**
     * 获取客户详细信息
     */
    @PreAuthorize("@ss.hasPermi('school:customer:query')")
    @GetMapping(value = "/{customerId}")
    public AjaxResult getInfo(@PathVariable("customerId") Long customerId)
    {
        return AjaxResult.success(sysCustomerService.selectSysCustomerById(customerId));
    }

    /**
     * 新增客户
     */
    @PreAuthorize("@ss.hasPermi('school:customer:add')")
    @Log(title = "客户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysCustomer sysCustomer)
    {
        return toAjax(sysCustomerService.insertSysCustomer(sysCustomer));
    }

    /**
     * 修改客户
     */
    @PreAuthorize("@ss.hasPermi('school:customer:edit')")
    @Log(title = "客户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysCustomer sysCustomer)
    {
        return toAjax(sysCustomerService.updateSysCustomer(sysCustomer));
    }

    /**
     * 删除客户
     */
    @PreAuthorize("@ss.hasPermi('school:customer:remove')")
    @Log(title = "客户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{customerIds}")
    public AjaxResult remove(@PathVariable Long[] customerIds)
    {
        return toAjax(sysCustomerService.deleteSysCustomerByIds(customerIds));
    }
}
