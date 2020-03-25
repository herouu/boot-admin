package com.hb0730.boot.admin.commons.web.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * </P>
 *
 * @author bing_huang
 * @since V1.0
 */
@Data
public class BaseVO implements Serializable {
    private static final long serialVersionUID = -88L;
    /**
     * 创建人
     */
    private Long createUserId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private Long updateUserId;

    /**
     * 创建时间
     */
    private Date updateTime;

    /**
     * <p>
     * 是否启用
     * </p>
     */
    private Integer isEnabled;

    /**
     * 是否删除
     */
    private Integer delFlag;
    /**
     * 版本
     */
    private Integer version;
}