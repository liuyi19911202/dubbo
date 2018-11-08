package cn.ly.caotuan.admin.web.controller;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import cn.ly.caotuan.admin.web.WebAdminApplication;
import cn.ly.caotuan.admin.web.common.controller.BaseController;
import cn.ly.common.api.Paging;
import cn.ly.common.upload.util.FileManager;
import cn.ly.common.utils.StringHelper;
import cn.ly.system.api.entity.Product;
import cn.ly.system.api.entity.SysUser;
import cn.ly.system.api.entity.TripUser;
import cn.ly.system.api.service.IProductService;
import cn.ly.system.api.vo.ReptileProductVo;

/**
 * 商品 controller
 * 
 * @author liuyi
 */
@Validated
@RestController
@RequestMapping("/product")
public class ProductController extends BaseController {
	/**
	 * 商品服务
	 */
	@Autowired
	private IProductService productService;
	/**
	 * 文件管理
	 */
	@Autowired
	private FileManager fileManager;

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	/**
	 * List page info.
	 */
	@PreAuthorize("hasAuthority('product:view')")
	@GetMapping(value = "/list")
	public PageInfo<Product> list(Paging page, @RequestParam Map<String, Object> query) {
		return productService.queryPage(page, query);
	}

	/**
	 * 淘宝爬虫
	 */
	@PreAuthorize("hasAuthority('product:view')")
	@GetMapping(value = "/reptile")
	public ReptileProductVo reptile(String url) {
		return productService.reptileProduct(url);
	}

	/**
	 * 保存商品信息
	 */
	@PreAuthorize("hasAuthority('product:view')")
	@PostMapping(value = "")
	public Product saveUser(@Valid @RequestBody Product product) {
		LOGGER.info("product:{}", product);
		LOGGER.info("product.imgs:{}", product.getImgs());
		LOGGER.info("product.impress:{}", product.getImpress());
		LOGGER.info("product.sku:{}", product.getSku());
		LOGGER.info("product.attributes:{}", product.getAttributes());
		// 保存用户信息
		return productService.saveProduct(product);
	}

	/**
	 * 详情
	 */
	@PreAuthorize("hasAuthority('product:view')")
	@GetMapping(value = "/{id}")
	public Product get(@PathVariable("id") String id) {
		Product product = productService.getProductById(id);
		return product;
	}

	/**
	 * 删除
	 *
	 */
	@PreAuthorize("hasAuthority('product:view')")
	@DeleteMapping(value = "/{productId}")
	public ResponseEntity delete(@PathVariable("productId") String productId) {
		productService.deleteProductById(productId);
		return new ResponseEntity(HttpStatus.OK);
	}
}
