package cn.thm.system.controller;

import cn.thm.common.annotation.Log;
import cn.thm.common.controller.BaseController;
import cn.thm.common.exception.GlobalException;
import cn.thm.common.utils.QueryPage;
import cn.thm.common.utils.R;
import cn.thm.system.entity.SysLoginLog;
import cn.thm.system.service.LoginLogService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author thm
 * @date 2019-03-13
 */
@RestController
@RequestMapping("/api/loginlog")
@Api(value = "LoginLogController", tags = {"登录日志管理接口"})
public class LoginLogController extends BaseController {

    @Autowired
    private LoginLogService loginLogService;

    @PostMapping("/list")
    public R findByPage(@RequestBody SysLoginLog sysLoginLog, QueryPage queryPage) {
        return new R<>(super.getData(loginLogService.list(sysLoginLog, queryPage)));
    }

    @Log("删除登录日志")
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Long id) {
        try {
            loginLogService.delete(id);
            return new R();
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
    }
}
