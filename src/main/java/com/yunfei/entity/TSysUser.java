package com.yunfei.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author yunfei
 * @since 2020-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TSysUser extends Model<TSysUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 创建人
     */
    private Long creator;

    /**
     * 创建人
     */
    private String creatorName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private Long modifyBy;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 修改人
     */
    private String modifyName;

    /**
     *  对应角色
     */
    private List<TSysUserRoles> userRolesList;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
