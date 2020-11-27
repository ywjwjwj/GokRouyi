package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.GokUserMapper;
import com.ruoyi.system.domain.GokUser;
import com.ruoyi.system.service.IGokUserService;
import com.ruoyi.common.core.text.Convert;

/**
 * GOK_用户相关操作Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-11-27
 */
@Service
public class GokUserServiceImpl implements IGokUserService 
{
    @Autowired
    private GokUserMapper gokUserMapper;

    /**
     * 查询GOK_用户相关操作
     * 
     * @param id GOK_用户相关操作ID
     * @return GOK_用户相关操作
     */
    @Override
    public GokUser selectGokUserById(Long id)
    {
        return gokUserMapper.selectGokUserById(id);
    }

    /**
     * 查询GOK_用户相关操作列表
     * 
     * @param gokUser GOK_用户相关操作
     * @return GOK_用户相关操作
     */
    @Override
    public List<GokUser> selectGokUserList(GokUser gokUser)
    {
        return gokUserMapper.selectGokUserList(gokUser);
    }

    /**
     * 新增GOK_用户相关操作
     * 
     * @param gokUser GOK_用户相关操作
     * @return 结果
     */
    @Override
    public int insertGokUser(GokUser gokUser)
    {
        return gokUserMapper.insertGokUser(gokUser);
    }

    /**
     * 修改GOK_用户相关操作
     * 
     * @param gokUser GOK_用户相关操作
     * @return 结果
     */
    @Override
    public int updateGokUser(GokUser gokUser)
    {
        return gokUserMapper.updateGokUser(gokUser);
    }

    /**
     * 删除GOK_用户相关操作对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGokUserByIds(String ids)
    {
        return gokUserMapper.deleteGokUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除GOK_用户相关操作信息
     * 
     * @param id GOK_用户相关操作ID
     * @return 结果
     */
    @Override
    public int deleteGokUserById(Long id)
    {
        return gokUserMapper.deleteGokUserById(id);
    }
}
