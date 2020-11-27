package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.GokUser;

/**
 * GOK_用户相关操作Mapper接口
 * 
 * @author ruoyi
 * @date 2020-11-27
 */
public interface GokUserMapper 
{
    /**
     * 查询GOK_用户相关操作
     * 
     * @param id GOK_用户相关操作ID
     * @return GOK_用户相关操作
     */
    public GokUser selectGokUserById(Long id);

    /**
     * 查询GOK_用户相关操作列表
     * 
     * @param gokUser GOK_用户相关操作
     * @return GOK_用户相关操作集合
     */
    public List<GokUser> selectGokUserList(GokUser gokUser);

    /**
     * 新增GOK_用户相关操作
     * 
     * @param gokUser GOK_用户相关操作
     * @return 结果
     */
    public int insertGokUser(GokUser gokUser);

    /**
     * 修改GOK_用户相关操作
     * 
     * @param gokUser GOK_用户相关操作
     * @return 结果
     */
    public int updateGokUser(GokUser gokUser);

    /**
     * 删除GOK_用户相关操作
     * 
     * @param id GOK_用户相关操作ID
     * @return 结果
     */
    public int deleteGokUserById(Long id);

    /**
     * 批量删除GOK_用户相关操作
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGokUserByIds(String[] ids);
}
