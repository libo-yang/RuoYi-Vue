package com.ruoyi.project.school.service;

import java.util.List;
import com.ruoyi.project.school.domain.SysGoods;

/**
 * 商品Service接口
 * 
 * @author lbyang
 * @date 2020-07-17
 */
public interface ISysGoodsService 
{
    /**
     * 查询商品
     * 
     * @param goodsId 商品ID
     * @return 商品
     */
    public SysGoods selectSysGoodsById(Long goodsId);

    /**
     * 查询商品列表
     * 
     * @param sysGoods 商品
     * @return 商品集合
     */
    public List<SysGoods> selectSysGoodsList(SysGoods sysGoods);

    /**
     * 新增商品
     * 
     * @param sysGoods 商品
     * @return 结果
     */
    public int insertSysGoods(SysGoods sysGoods);

    /**
     * 修改商品
     * 
     * @param sysGoods 商品
     * @return 结果
     */
    public int updateSysGoods(SysGoods sysGoods);

    /**
     * 批量删除商品
     * 
     * @param goodsIds 需要删除的商品ID
     * @return 结果
     */
    public int deleteSysGoodsByIds(Long[] goodsIds);

    /**
     * 删除商品信息
     * 
     * @param goodsId 商品ID
     * @return 结果
     */
    public int deleteSysGoodsById(Long goodsId);
}
