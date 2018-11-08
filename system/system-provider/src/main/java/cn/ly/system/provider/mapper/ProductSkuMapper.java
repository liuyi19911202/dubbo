package cn.ly.system.provider.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.ly.common.service.dao.CrudDao;
import cn.ly.system.api.entity.ProductSku;

/**
 * 商品
 *
 * @author liuyi
 */
@Mapper
public interface ProductSkuMapper extends CrudDao<ProductSku> {
	/**
	 * 根据商品查询sku
	 *
	 * @param product
	 * @return the list
	 */
	List<ProductSku> findListByProductId(String productId);
}
