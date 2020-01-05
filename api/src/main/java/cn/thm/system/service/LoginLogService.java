package cn.thm.system.service;


import cn.thm.common.utils.QueryPage;
import cn.thm.system.entity.SysLoginLog;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author thm
 * @date 2019-03-13
 */
public interface LoginLogService extends IService<SysLoginLog> {

    IPage<SysLoginLog> list(SysLoginLog log, QueryPage queryPage);

    void delete(Long id);

    void saveLog(SysLoginLog log);
}
