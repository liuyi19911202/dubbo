package cn.ly.system.provider.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.ly.common.service.dao.CrudDao;
import cn.ly.system.api.entity.ProductAttribute;

/**
 * 商品
 *
 * @author liuyi
 */
@Mapper
public interface ProductAttributeMapper extends CrudDao<ProductAttribute> {

	/**
	 * 根据商品查询属性
	 *
	 * @param productId
	 * @return the list
	 */
	List<ProductAttribute> findListByProductId(String productId);

}
