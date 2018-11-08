package cn.ly.system.provider.serviceImpl;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;

import cn.ly.common.service.service.CrudService;
import cn.ly.common.utils.StringHelper;
import cn.ly.system.api.entity.Product;
import cn.ly.system.api.entity.ProductAttribute;
import cn.ly.system.api.entity.ProductImpress;
import cn.ly.system.api.entity.ProductPicture;
import cn.ly.system.api.entity.ProductSku;
import cn.ly.system.api.service.IProductService;
import cn.ly.system.api.vo.ReptileProductVo;
import cn.ly.system.provider.mapper.ProductAttributeMapper;
import cn.ly.system.provider.mapper.ProductImpressMapper;
import cn.ly.system.provider.mapper.ProductMapper;
import cn.ly.system.provider.mapper.ProductPictureMapper;
import cn.ly.system.provider.mapper.ProductSkuMapper;
import cn.ly.system.provider.reptile.ReptileProductByTaobao;

/**
 * 商品服务实现
 *
 * @author liuyi
 */
@Service
@Transactional(readOnly = true)
public class ProductService extends CrudService<ProductMapper, Product> implements IProductService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

	/**
	 * 商品mapper
	 */
	@Autowired
	private ProductMapper productMapper;

	/**
	 * 商品图片
	 */
	@Autowired
	private ProductPictureMapper productPictureMapper;

	/**
	 * 商品sku
	 */
	@Autowired
	private ProductSkuMapper productSkuMapper;

	/**
	 * 商品属性
	 */
	@Autowired
	private ProductAttributeMapper productAttributeMapper;

	/**
	 * 大家印象
	 */
	@Autowired
	private ProductImpressMapper productImpressMapper;

	@Override
	@Transactional(readOnly = false)
	public void updateInfo(Product product) {
		// 更新update时间
		product.preUpdate();
		getDao().updateInfo(product);
	}

	@Override
	public Product getByName(String name) {
		return getDao().getByName(name);
	}

	@Override
	public ReptileProductVo reptileProduct(String url) {
		return ReptileProductByTaobao.beginReptile(url);
	}

	@Override
	@Transactional(readOnly = false)
	public Product saveProduct(Product product) {
		if (StringHelper.isBlank(product.getId())) {
			product.preInsert();
			productMapper.insert(product);
			// 商品图片
			if (null != product.getImgs() && product.getImgs().size() > 0) {
				for (String img : product.getImgs()) {
					if (!StringHelper.isBlank(img)) {
						ProductPicture ppic = new ProductPicture();
						ppic.preInsert();
						ppic.setProductId(product.getId());
						ppic.setUrl(img);
						productPictureMapper.insert(ppic);
					}
				}
			}
			// 商品属性
			if (null != product.getAttributes() && product.getAttributes().size() > 0) {
				for (String attr : product.getAttributes()) {
					if (!StringHelper.isBlank(attr)) {
						ProductAttribute po = new ProductAttribute();
						po.preInsert();
						po.setProductId(product.getId());
						po.setName(attr.split(":")[0]);
						po.setValue(attr.split(":")[1]);
						productAttributeMapper.insert(po);
					}
				}
			}
			// 商品sku
			if (null != product.getSku() && product.getSku().size() > 0) {
				for (String sku : product.getSku()) {
					sku = sku.replace("[", "");
					sku = sku.replace("]", "");
					sku = sku.replaceAll("\"", "");
					LOGGER.info("split,{}", sku.split(",")[0]);
					String[] items = sku.split(",");
					// ["[\"尺码\",\"XS\",\"S\",\"M\",\"L\",\"XL\"]","[\"颜色分类\",\"白色\"]"]
					// 将每一项转换成list集合
					ProductSku po = new ProductSku();
					po.preInsert();
					po.setProductId(product.getId());
					int i = 0;
					String values = "";
					for (String item : items) {
						if (i == 0) {
							po.setName(item);
						} else {
							values += item + ",";
						}
						i++;
					}
					if (!StringHelper.isBlank(values)) {
						values = values.substring(0, values.lastIndexOf(","));
					}
					po.setValue(values);
					productSkuMapper.insert(po);
				}
			}

			// 大家印象
			if (null != product.getImpress() && product.getImpress().size() > 0) {
				// mvc处理不了带有转义的json字符串,不知道怎么设置,只能在这里反序列化
				// 将数组转换成字符串
				LOGGER.info("getImpress():{}", product.getImpress());
				// 把字符串转换成集合
				List<ProductImpress> list = JSONObject.parseArray(product.getImpress().toString(),
						ProductImpress.class);
				for (ProductImpress productImpress : list) {
					if (null != productImpress) {
						ProductImpress po = new ProductImpress();
						po.preInsert();
						po.setProductId(product.getId());
						po.setTitle(productImpress.getTitle());
						po.setCount(productImpress.getCount());
						productImpressMapper.insert(po);
					}
				}
			}
		} else {
			// 更新
		}
		return product;
	}

	@Override
	public Product getProductById(String productId) {
		Product product = productMapper.get(productId);
		if (null != product) {
			// 图片
			product.setListProductPicture(productPictureMapper.findListByProductId(productId));
			// 属性
			product.setListProductAttribute(productAttributeMapper.findListByProductId(productId));
			// sku
			product.setListProductSku(productSkuMapper.findListByProductId(productId));
			// 大家印象
			product.setListProductImpress(productImpressMapper.findListByProductId(productId));
		}
		return product;
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteProductById(String productId) {
		productMapper.deleteById(productId);
	}

}
