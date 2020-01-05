package cn.thm.system.controller;

import cn.thm.common.annotation.Log;
import cn.thm.common.controller.BaseController;
import cn.thm.common.exception.GlobalException;
import cn.thm.common.utils.R;
import cn.thm.system.entity.SysUser;
import cn.thm.system.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author TyCoding
 * @date 2018/10/18
 */
@RestController
@RequestMapping("/api/user")
@Api(value = "UserController", tags = {"用户管理接口"})
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/info")
    public R getInfo() {
        SysUser user = this.getCurrentUser();
        return new R<>(user);
    }

    @GetMapping("/{id}")
    public R findById(@PathVariable Long id) {
        return new R<>(userService.getById(id));
    }

    @PostMapping
    @Log("新增用户")
    public R save(@RequestBody SysUser sysUser) {
        try {
            userService.add(sysUser);
            return new R();
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
    }

    @PutMapping
    @Log("更新用户")
    public R update(@RequestBody SysUser sysUser) {
        try {
            sysUser.setId(this.getCurrentUser().getId());
            userService.update(sysUser);
            return new R();
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Log("删除用户")
    public R delete(@PathVariable Long id) {
        try {
            userService.delete(id);
            return new R();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }
}
