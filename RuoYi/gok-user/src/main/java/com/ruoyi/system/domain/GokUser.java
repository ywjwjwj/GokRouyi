package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * GOK_用户相关操作对象 gok_user
 * 
 * @author ruoyi
 * @date 2020-11-27
 */
public class GokUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private String userId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 用户生日 */
    @Excel(name = "用户生日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date userBirth;

    /** 用户状态（0为在线,1为离线） */
    @Excel(name = "用户状态", readConverterExp = "0=为在线,1为离线")
    private Integer userStatus;

    /** 伪删除（0为存在,1为隐藏） */
    @Excel(name = "伪删除", readConverterExp = "0=为存在,1为隐藏")
    private Integer flag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setUserBirth(Date userBirth) 
    {
        this.userBirth = userBirth;
    }

    public Date getUserBirth() 
    {
        return userBirth;
    }
    public void setUserStatus(Integer userStatus) 
    {
        this.userStatus = userStatus;
    }

    public Integer getUserStatus() 
    {
        return userStatus;
    }
    public void setFlag(Integer flag) 
    {
        this.flag = flag;
    }

    public Integer getFlag() 
    {
        return flag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("userBirth", getUserBirth())
            .append("userStatus", getUserStatus())
            .append("flag", getFlag())
            .toString();
    }
}
