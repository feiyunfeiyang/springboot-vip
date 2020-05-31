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
 * 资源表
 * </p>
 *
 * @author yunfei
 * @since 2020-01-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TSysResource extends Model<TSysResource> {

    private static final long serialVersionUID = 1L;

    /**
     * 资源ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 菜单编码
     */
    private String code;

    /**
     * 父编码
     */
    private String pcode;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 方法路径
     */
    private String methodPath;

    /**
     * 资源类型(0：页面菜单；1:按钮；4：其他操作)
     */
    private String type;

    /**
     * 序号
     */
    private Integer seq;

    /**
     * 层级
     */
    private Integer level;

    /**
     * 资源说明
     */
    private String remark;

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
