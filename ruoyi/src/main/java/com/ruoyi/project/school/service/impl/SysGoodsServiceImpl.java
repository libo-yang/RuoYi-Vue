package com.ruoyi.project.school.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.school.mapper.SysGoodsMapper;
import com.ruoyi.project.school.domain.SysGoods;
import com.ruoyi.project.school.service.ISysGoodsService;

/**
 * 商品Service业务层处理
 * 
 * @author lbyang
 * @date 2020-07-17
 */
@Service
public class SysGoodsServiceImpl implements ISysGoodsService 
{
    @Autowired
    private SysGoodsMapper sysGoodsMapper;

    /**
     * 查询商品
     * 
     * @param goodsId 商品ID
     * @return 商品
     */
    @Override
    public SysGoods selectSysGoodsById(Long goodsId)
    {
        return sysGoodsMapper.selectSysGoodsById(goodsId);
    }

    /**
     * 查询商品列表
     * 
     * @param sysGoods 商品
     * @return 商品
     */
    @Override
    public List<SysGoods> selectSysGoodsList(SysGoods sysGoods)
    {
        return sysGoodsMapper.selectSysGoodsList(sysGoods);
    }

    /**
     * 新增商品
     * 
     * @param sysGoods 商品
     * @return 结果
     */
    @Override
    public int insertSysGoods(SysGoods sysGoods)
    {
        return sysGoodsMapper.insertSysGoods(sysGoods);
    }

    /**
     * 修改商品
     * 
     * @param sysGoods 商品
     * @return 结果
     */
    @Override
    public int updateSysGoods(SysGoods sysGoods)
    {
        return sysGoodsMapper.updateSysGoods(sysGoods);
    }

    /**
     * 批量删除商品
     * 
     * @param goodsIds 需要删除的商品ID
     * @return 结果
     */
    @Override
    public int deleteSysGoodsByIds(Long[] goodsIds)
    {
        return sysGoodsMapper.deleteSysGoodsByIds(goodsIds);
    }

    /**
     * 删除商品信息
     * 
     * @param goodsId 商品ID
     * @return 结果
     */
    @Override
    public int deleteSysGoodsById(Long goodsId)
    {
        return sysGoodsMapper.deleteSysGoodsById(goodsId);
    }
}
