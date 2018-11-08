package cn.ly.caotuan.admin.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import cn.ly.caotuan.admin.web.common.controller.BaseController;
import cn.ly.common.api.Paging;
import cn.ly.common.upload.util.FileManager;
import cn.ly.system.api.entity.TripUser;
import cn.ly.system.api.service.ITripUserService;

/**
 * Trip user controller
 * 
 * @ClassName: TripUserController
 * @author liuyi
 * @date 2018年8月13日
 */
@Validated
@RestController
@RequestMapping("/trip/user")
public class TripUserController extends BaseController {
	/**
	 * 用户服务
	 */
	@Autowired
	private ITripUserService tripUserService;
	/**
	 * 文件管理
	 */
	@Autowired
	private FileManager fileManager;

	/**
	 * List page info.
	 *
	 * @param page
	 *            the page
	 * @param query
	 *            the query
	 * @return the page info
	 */
	@PreAuthorize("hasAuthority('trip:user:view')")
	@GetMapping(value = "/list")
	public PageInfo<TripUser> list(Paging page, @RequestParam Map<String, Object> query) {
		return tripUserService.queryPage(page, query);
	}

	/**
	 * Get trip user.
	 *
	 * @param id
	 *            the id
	 * @return the trip user
	 */
	@PreAuthorize("hasAuthority('trip:user:view')")
	@GetMapping(value = "/{id}")
	public TripUser get(@PathVariable("id") String id) {
		TripUser user = tripUserService.get(id);
		user.setPhoto(fileManager.getFileUrlByRealPath(user.getPhoto()));

		return user;
	}

}
