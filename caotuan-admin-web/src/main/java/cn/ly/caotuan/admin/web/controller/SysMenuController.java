package cn.ly.caotuan.admin.web.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import cn.ly.caotuan.admin.web.common.controller.BaseController;
import cn.ly.caotuan.admin.web.security.model.AuthUser;
import cn.ly.common.web.util.WebUtils;
import cn.ly.system.api.entity.SysMenu;
import cn.ly.system.api.service.ISystemService;

/**
 * Sys menu
 * @ClassName: SysMenuController
 * @author liuyi
 * @date 2018年8月13日
 */
@Validated
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends BaseController {
    /**
     * 系统菜单服务
     */
    @Autowired
    private ISystemService systemService;

    /**
     * Gets menu nav.
     *
     * @return the menu nav
     */
    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/nav")
    public List<SysMenu> getMenuNav() {

        AuthUser user = WebUtils.getCurrentUser();

        return systemService.getMenuNav(user.getId());
    }

    /**
     * Gets menu tree.
     *
     * @return the menu tree
     */
    @PreAuthorize("hasAuthority('sys:menu:view')")
    @GetMapping(value = "/tree")
    public List<SysMenu> getMenuTree() {

        AuthUser user = WebUtils.getCurrentUser();

        return systemService.getMenuTree(user.getId());
    }

    /**
     * Gets menu list.
     *
     * @return the menu list
     */
    @PreAuthorize("hasAuthority('sys:menu:view')")
    @GetMapping(value = "/list")
    public List<SysMenu> getMenuList() {

        AuthUser user = WebUtils.getCurrentUser();

        return systemService.getMenuList(user.getId());
    }

    /**
     * Delete menu response entity.
     *
     * @param menuId the menu id
     * @return the response entity
     */
    @PreAuthorize("hasAuthority('sys:menu:edit')")
    @DeleteMapping(value = "/{menuId}")
    public ResponseEntity deleteMenu(@PathVariable("menuId") String menuId) {

        systemService.deleteMenuById(menuId);

        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Gets menu.
     *
     * @param menuId the menu id
     * @return the menu
     */
    @PreAuthorize("hasAuthority('sys:menu:view')")
    @GetMapping(value = "/{menuId}")
    public SysMenu getMenu(@PathVariable("menuId") String menuId) {

        return systemService.getMenuById(menuId);

    }

    /**
     * Save menu sys menu.
     *
     * @param menu the menu
     * @return the sys menu
     */
    @PreAuthorize("hasAuthority('sys:menu:edit')")
    @PostMapping(value = "")
    public SysMenu saveMenu(@Valid @RequestBody SysMenu menu) {

        return systemService.saveMenu(menu);
    }

}
