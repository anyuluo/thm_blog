package cn.thm.system.mapper;

import cn.thm.system.entity.SysArticle;
import cn.thm.system.entity.ArticleTag;
import cn.thm.system.entity.SysTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author TyCoding
 * @date 2018/10/22
 */
public interface ArticleTagMapper extends BaseMapper<ArticleTag> {

    List<SysTag> findByArticleId(long articleId);

    List<SysArticle> findByTagName(String name);
}
