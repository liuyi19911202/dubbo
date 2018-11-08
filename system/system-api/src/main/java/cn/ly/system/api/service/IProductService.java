package cn.ly.system.api.service;


import java.util.Map;

import com.github.pagehelper.PageInfo;

import cn.ly.common.api.Paging;
import cn.ly.system.api.entity.Product;
import cn.ly.system.api.entity.SysMenu;
import cn.ly.system.api.entity.SysUser;
import cn.ly.system.api.vo.ReptileProductVo;

/**
 * 商品接口
 *
 * @author liuyi
 */
public interface IProductService {

    /**
     * 查询商品列表
     *
     * @param page  分页信息
     * @param query 查询条件
     * @return 商品 page info
     */
    PageInfo<Product> queryPage(Paging page, Map<String, Object> query);

    /**
     * 通过id查询商品信息
     *
     * @param id 用户id
     * @return 商品
     */
    Product get(String id);

    /**
     * 更新商品
     *
     * @param entity 商品
     */
    void updateInfo(Product entity);
    
    /**
     * 根据名称码查询商品
     *
     * @param name
     */
    Product getByName(String name);
    
    /**
     * 爬虫
     * @param url 淘宝地址
     * @return
     */
    ReptileProductVo reptileProduct(String url);
    /**
     * 保存商品
     *
     * @param product
     * @return product
     */
    Product saveProduct(Product product);
    /**
     * 查询商品信息,包含sku,attu,imp
     *
     * @param productId 商品id
     * @return 商品
     */
    Product getProductById(String productId);
    
    /**
     * 删除商品
     *
     * @param productId 商品id
     */
    void deleteProductById(String productId);
}
