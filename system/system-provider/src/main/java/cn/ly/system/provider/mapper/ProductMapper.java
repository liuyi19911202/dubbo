package cn.ly.system.provider.mapper;


import org.apache.ibatis.annotations.Mapper;

import cn.ly.common.service.dao.CrudDao;
import cn.ly.system.api.entity.Product;
import cn.ly.system.api.vo.ReptileProductVo;

/**
 * 商品
 *
 * @author liuyi
 */
@Mapper
public interface ProductMapper extends CrudDao<Product> {

    /**
     * 根据名称码查询商品
     *
     * @param name
     */
    Product getByName(String name);

    /**
     * 更新商品信息
     *
     * @param entity the product
     * @return the int
     */
    int updateInfo(Product entity);
    
    /**
     * 爬虫
     */
    ReptileProductVo reptileProduct(String url);
}
