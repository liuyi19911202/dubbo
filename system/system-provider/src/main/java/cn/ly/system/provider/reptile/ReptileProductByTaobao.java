package cn.ly.system.provider.reptile;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import cn.ly.system.api.vo.ReptileProductVo;

public class ReptileProductByTaobao {
	//static String url = "https://item.taobao.com/item.htm?spm=a21bo.2017.201867-rmds-0.1.5af911d9C4UBSm&scm=1007.12807.84406.100200300000004&id=569533096246&pvid=bbca8bff-e60e-4707-bb3f-1442c75e60d5";
	private static final Logger LOGGER = LoggerFactory.getLogger(ReptileProductByTaobao.class);
	
	public static ReptileProductVo beginReptile(String url) {
		Process proc;
		ReptileProductVo vo = null;
		try {
			LOGGER.info("python3开始执行,当前url: {}",url);
			//http请求获取到参数重包含&的请求,会处理,加上amp;
			//处理掉amp;
			if(!StringUtils.isBlank(url)) {
				url = url.replace("amp;", "");
				LOGGER.info("处理后url: {}",url);
			}
			 String[] args1 = new String[] { "python3", "python/QWebEnginePage.py", url };
			proc = Runtime.getRuntime().exec(args1);// 执行py文件
			// 用输入输出流来截取结果
			BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String line = null;
			String str = "";
			while ((line = in.readLine()) != null) {
				str += line;
			}
			in.close();
			proc.waitFor();
			LOGGER.info("python3 result: " + str);
			vo = JSON.parseObject(str, new TypeReference<ReptileProductVo>() {});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	public static void main(String[] args) {
		//beginReptile();
	}
}
