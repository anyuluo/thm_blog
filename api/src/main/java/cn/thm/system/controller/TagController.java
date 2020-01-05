package cn.thm.system.controller;

import cn.thm.common.annotation.Log;
import cn.thm.common.controller.BaseController;
import cn.thm.common.exception.GlobalException;
import cn.thm.common.utils.QueryPage;
import cn.thm.common.utils.R;
import cn.thm.system.entity.SysTag;
import cn.thm.system.service.TagService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author TyCoding
 * @date 2018/10/18
 */
@RestController
@RequestMapping("/api/tag")
@Api(value = "TagController", tags = {"标签管理接口"})
public class TagController extends BaseController {

    @Autowired
    private TagService tagService;

    @GetMapping("/findAll")
    public R newList() {
        return new R<>(tagService.findAll());
    }

    @PostMapping("/list")
    public R findByPage(@RequestBody SysTag tag, QueryPage queryPage) {
        return new R<>(super.getData(tagService.list(tag, queryPage)));
    }

    @GetMapping("/{id}")
    public R findById(@PathVariable Long id) {
        return new R<>(tagService.getById(id));
    }

    @PostMapping
    @Log("新增标签")
    public R save(@RequestBody SysTag tag) {
        try {
            tagService.add(tag);
            return new R();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }

    @PutMapping
    @Log("更新标签")
    public R update(@RequestBody SysTag tag) {
        try {
            tagService.update(tag);
            return new R();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Log("删除标签")
    public R delete(@PathVariable Long id) {
        try {
            tagService.delete(id);
            return new R();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }
}
