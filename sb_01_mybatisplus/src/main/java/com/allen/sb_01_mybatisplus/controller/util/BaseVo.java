package com.allen.sb_01_mybatisplus.controller.util;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author: shenwei1
 * @date: 2018/8/28 14:33
 * @description:
 */
public class BaseVo implements Serializable {

    private static final long serialVersionUID = -1386252154033007432L;

    @Override
    public String toString() {

        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
