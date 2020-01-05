package cn.thm.system.controller;

import cn.thm.common.controller.BaseController;
import cn.thm.common.exception.GlobalException;
import cn.thm.common.utils.QueryPage;
import cn.thm.common.utils.R;
import cn.thm.system.entity.SysLog;
import cn.thm.system.service.LogService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author thm
 * @date 2019-03-13
 */
@RestController
@RequestMapping("/api/log")
@Api(value = "LogController", tags = {"日志管理接口"})
public class LogController extends BaseController {

    @Autowired
    private LogService logService;

    @PostMapping("/list")
    public R findByPage(@RequestBody SysLog log, QueryPage queryPage) {
        return new R<>(super.getData(logService.list(log, queryPage)));
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Long id) {
        try {
            logService.delete(id);
            return new R();
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
    }
}
