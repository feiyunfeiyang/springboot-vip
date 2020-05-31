package com.yunfei.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author yunfei
 * @since 2020-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TSysRoles extends Model<TSysRoles> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色编码
     */
    private String code;

    /**
     * 父code
     */
    private String pcode;

    /**
     * 查询code,用作查询用
     */
    private String findCode;

    /**
     * 角色类型
     */
    private String type;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 角色部门ID（用于控制数据权限）
     */
    private Long deptId;

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


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
