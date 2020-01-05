package cn.thm.system.entity.dto;

import cn.thm.system.entity.SysArticle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 用于封装Article表按时间归档的DTO
 *
 * @author TyCoding
 * @date 2018/10/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArchivesWithArticle implements Serializable {

    private String date;
    private List<SysArticle> articles;
}
