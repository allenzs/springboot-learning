package com.allen.sb_01_mybatisplus.controller.util;


import com.allen.sb_01_mybatisplus.consts.Constant;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: shenwei1
 * @date: 2018/8/28 14:31
 * @description:
 */
public class JsonResultVO extends BaseVo {

    private static final long serialVersionUID = 6951387531317713388L;

    /**
     * 成功状态码
     */
    public static final String SUCCESS_CODE = "10000";

    /**
     * 警告状态码
     */
    public static final String WARN_CODE = "1";

    /**
     * 错误状态码
     */
    public static final String ERROR_CODE = "0";

    /**
     * 服务器时间
     */
    protected Date serverTime = new Date();

    /**
     * 状态码
     */
    protected String status = SUCCESS_CODE;

    /**
     * 消息
     */
    protected String message;

    /**
     * 数据集
     */
    protected Map<String, Object> data = new HashMap<String, Object>();

    /**
     * 构建一个成功结果的对象
     *
     * @param message
     * @return
     */
    public static JsonResultVO success(String message) {
        JsonResultVO vo = new JsonResultVO();
        vo.setStatus(SUCCESS_CODE);
        vo.setMessage(message);
        return vo;
    }

    /**
     * 构建一个成功结果的对象
     *
     * @return
     */
    public static JsonResultVO success() {
        return success("success");
    }

    /**
     * 默认的错误异常
     *
     * @return
     */
    public static JsonResultVO error() {
        JsonResultVO vo = new JsonResultVO();
        vo.setStatus(ERROR_CODE);
        vo.setMessage("服务器异常");
        return vo;
    }

    /**
     * 构建一个失败结果的对象
     *
     */
    public static JsonResultVO error(Constant.ErrorCodeMsg errorCodeMsg) {
        JsonResultVO vo = new JsonResultVO();
        vo.setStatus(errorCodeMsg.getCode());
        vo.setMessage(errorCodeMsg.getMsg());
        return vo;
    }

    /**
     * 增加一个值
     */
    public JsonResultVO addData(String key, Object value) {
        if (value != null) {
            data.put(key, value);
        }
        return this;
    }

    /**
     * @description: 直接addData
     * @date 11:38 2018/9/27
     * @param [data]
     * @return com.yidian.dragon.base.JsonResultVO
     **/
    public JsonResultVO addData(Map<String, Object> data) {
        this.data = data;
        return this;
    }

    public static void main(String[] args) {
        JsonResultVO success = success();
        System.out.println(success);

        JsonResultVO error = error();
        System.out.println(error);

        JsonResultVO warn = warn(Constant.ErrorCodeMsg.REQUEST_PARAMETERS);
        System.out.println(warn);
    }
    /**
     * 通过code获取 返回参数
     * @param code
     * @return
     */
    public static JsonResultVO warn(Constant.ErrorCodeMsg errorCodeMsg) {
        JsonResultVO result = new JsonResultVO();
        result.setStatus(errorCodeMsg.getCode());
        result.setMessage(errorCodeMsg.getMsg());
        return result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Date getServerTime() {
        return serverTime;
    }

    public void setServerTime(Date serverTime) {
        this.serverTime = serverTime;
    }
}
