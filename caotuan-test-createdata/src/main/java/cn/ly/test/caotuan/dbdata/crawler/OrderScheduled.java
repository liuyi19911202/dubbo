package cn.ly.test.caotuan.dbdata.crawler;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.ly.test.caotuan.dbdata.TestDBCreateApplication;
import cn.ly.test.caotuan.dbdata.entity.Orders;
import cn.ly.test.caotuan.dbdata.mapper.OrderMapper;

/**
 * 定时任务
 */
@Component
public class OrderScheduled {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestDBCreateApplication.class);

	@Autowired
	private OrderMapper orderMapper;

	// 测试,关闭
	@Scheduled(cron = "0 0/1 * * * ? ")
	public void BankOfChinaScheduled() {
		LOGGER.info("订单定时任务start");
		Orders order = new Orders();
		//我的账号
		order.setUserid(Long.valueOf("6531509327"));
		//（第二版）拯救老婆夏日限量套装
		order.setGoodsid(Long.valueOf("391"));
		//购买数量
		order.setAmount(1);
		//待发货
		order.setState(9);
		//预售
		order.setType(1);
		order.setCreatedate(new Date());
		orderMapper.addOrder(order);
	}

}
