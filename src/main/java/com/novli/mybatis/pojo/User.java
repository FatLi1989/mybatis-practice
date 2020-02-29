package com.novli.mybatis.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * [STRATO MyBatis Generator]
 * Table: user
@mbggenerated do_not_delete_during_merge 2020-02-28 16:21:23
 */
public class User implements Serializable {
    /**
     *   ��ʶ
     * Column: user.id
    @mbggenerated 2020-02-28 16:21:23
     */
    private String id;

    /**
     *   ΢��id
     * Column: user.wx_id
    @mbggenerated 2020-02-28 16:21:23
     */
    private String wxId;

    /**
     *   ΢���ǳ�
     * Column: user.wx_nickname
    @mbggenerated 2020-02-28 16:21:23
     */
    private String wxNickname;

    /**
     *   ��ɫ
     * Column: user.roles
    @mbggenerated 2020-02-28 16:21:23
     */
    private String roles;

    /**
     *   ͷ���ַ
     * Column: user.avatar_url
    @mbggenerated 2020-02-28 16:21:23
     */
    private String avatarUrl;

    /**
     *   ����ʱ��
     * Column: user.create_time
    @mbggenerated 2020-02-28 16:21:23
     */
    private Date createTime;

    /**
     *   �޸�ʱ��
     * Column: user.update_time
    @mbggenerated 2020-02-28 16:21:23
     */
    private Date updateTime;

    /**
     *   ����
     * Column: user.bonus
    @mbggenerated 2020-02-28 16:21:23
     */
    private Integer bonus;

    /**
     * Table: user
    @mbggenerated 2020-02-28 16:21:23
     */
    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getWxId() {
        return wxId;
    }

    public void setWxId(String wxId) {
        this.wxId = wxId == null ? null : wxId.trim();
    }

    public String getWxNickname() {
        return wxNickname;
    }

    public void setWxNickname(String wxNickname) {
        this.wxNickname = wxNickname == null ? null : wxNickname.trim();
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles == null ? null : roles.trim();
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", wxId='" + wxId + '\'' +
                ", wxNickname='" + wxNickname + '\'' +
                ", roles='" + roles + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", bonus=" + bonus +
                '}';
    }
}
