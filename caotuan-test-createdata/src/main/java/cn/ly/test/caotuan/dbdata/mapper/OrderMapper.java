package cn.ly.test.caotuan.dbdata.mapper;

import org.apache.ibatis.annotations.Mapper;

import cn.ly.test.caotuan.dbdata.entity.Orders;

/**
 * @author liuyi
 */
@Mapper
public interface OrderMapper {

	/**
	 * 插入订单数据
	 */
	void addOrder(Orders order);

}
