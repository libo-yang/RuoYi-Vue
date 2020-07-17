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
import com.ruoyi.project.school.domain.SysGoods;
import com.ruoyi.project.school.service.ISysGoodsService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 商品Controller
 * 
 * @author lbyang
 * @date 2020-07-17
 */
@RestController
@RequestMapping("/school/goods")
public class SysGoodsController extends BaseController
{
    @Autowired
    private ISysGoodsService sysGoodsService;

    /**
     * 查询商品列表
     */
    @PreAuthorize("@ss.hasPermi('school:goods:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysGoods sysGoods)
    {
        startPage();
        List<SysGoods> list = sysGoodsService.selectSysGoodsList(sysGoods);
        return getDataTable(list);
    }

    /**
     * 导出商品列表
     */
    @PreAuthorize("@ss.hasPermi('school:goods:export')")
    @Log(title = "商品", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysGoods sysGoods)
    {
        List<SysGoods> list = sysGoodsService.selectSysGoodsList(sysGoods);
        ExcelUtil<SysGoods> util = new ExcelUtil<SysGoods>(SysGoods.class);
        return util.exportExcel(list, "goods");
    }

    /**
     * 获取商品详细信息
     */
    @PreAuthorize("@ss.hasPermi('school:goods:query')")
    @GetMapping(value = "/{goodsId}")
    public AjaxResult getInfo(@PathVariable("goodsId") Long goodsId)
    {
        return AjaxResult.success(sysGoodsService.selectSysGoodsById(goodsId));
    }

    /**
     * 新增商品
     */
    @PreAuthorize("@ss.hasPermi('school:goods:add')")
    @Log(title = "商品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysGoods sysGoods)
    {
        return toAjax(sysGoodsService.insertSysGoods(sysGoods));
    }

    /**
     * 修改商品
     */
    @PreAuthorize("@ss.hasPermi('school:goods:edit')")
    @Log(title = "商品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysGoods sysGoods)
    {
        return toAjax(sysGoodsService.updateSysGoods(sysGoods));
    }

    /**
     * 删除商品
     */
    @PreAuthorize("@ss.hasPermi('school:goods:remove')")
    @Log(title = "商品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{goodsIds}")
    public AjaxResult remove(@PathVariable Long[] goodsIds)
    {
        return toAjax(sysGoodsService.deleteSysGoodsByIds(goodsIds));
    }
}
