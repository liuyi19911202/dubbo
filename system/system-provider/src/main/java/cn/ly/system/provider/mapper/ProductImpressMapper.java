package cn.ly.system.provider.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.ly.common.service.dao.CrudDao;
import cn.ly.system.api.entity.ProductImpress;

/**
 * 商品
 *
 * @author liuyi
 */
@Mapper
public interface ProductImpressMapper extends CrudDao<ProductImpress> {
	
	/**
	 * 根据商品查询大家印象
	 *
	 * @param product
	 * @return the list
	 */
	List<ProductImpress> findListByProductId(String productId);
}
