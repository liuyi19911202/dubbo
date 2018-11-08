package cn.ly.caotuan.admin.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ly.caotuan.admin.web.common.controller.BaseController;

/**
 * Dashboard控制器
 * @ClassName: DashboardController
 * @author liuyi
 * @date 2018年8月13日
 */
@Validated
@RestController
@RequestMapping("/dashboard")
public class DashboardController extends BaseController {

    /**
     * Get map.
     *
     * @return the map
     */
    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "")
    public Map<String, Object> get() {
        return new HashMap<>();
    }

}
