package cn.ly.system.provider.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.ly.common.service.dao.CrudDao;
import cn.ly.system.api.entity.ProductPicture;

/**
 * 商品
 *
 * @author liuyi
 */
@Mapper
public interface ProductPictureMapper extends CrudDao<ProductPicture> {
	
	 /**
     * 根据商品查询商品图片
     *
     * @param product
     * @return the list
     */
    List<ProductPicture> findListByProductId(String productId);

}
