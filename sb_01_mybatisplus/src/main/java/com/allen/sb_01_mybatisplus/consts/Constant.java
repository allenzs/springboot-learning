package com.allen.sb_01_mybatisplus.consts;

import java.util.Arrays;
import java.util.List;

public class Constant {

    /**
     * @author shenwei1
     * @description: 返回值
     * @date 16:36 2018/8/28
     **/

    public static final List<String> ALGO_METRICS =
            Arrays.asList("frontPageViewRatio","immersiveViewRatio","frontPagePicDuration","frontPageShortVideoDuration",
                    "frontSmallPageVideoDuration","immersiveShortVideoDuration","immersiveSmallVideoDuration");
    public static final List<String> ALGO_KEYS = Arrays.asList("30s以下首页短视频的曝光占比","30s以下沉浸式短视频的曝光占比","首页图文单篇停留",
            "首页短视频单篇停留","首页小视频单篇停留","沉浸式短视频单篇停留","沉浸式小视频单篇停留");
    public static final List<String> ALGO_KEYS_RATIO = Arrays.asList("30s以下首页短视频的曝光占比","30s以下沉浸式短视频的曝光占比");
    public static final List<String> CALLBACK_KEYS_RATIO = Arrays.asList("曝光次数占比","点击次数占比","停留时长占比","rctr");
    public static final List<String> CALLBACK_METRICS = Arrays.asList("cntrviews","cntrviewRate","cntclicks","cntclickRate","dwells","dwellRate","rctrs","singleDuration");


    public enum ErrorCodeMsg {

        /**
         *  服务异常
         **/
        SERVICE_EXCEPTION("10001", "服务异常"),
        /**
         *  文件超过大小
         **/
        FILE_OVER_FIXED_SIZE("10002", "文件太大"),

        QUERY_RUNNING("10007", "正在查询中"),
        /**
         *  请求参数不完整
         **/
        REQUEST_PARAMETERS("10004", "请求参数不完整"),
        /**
         *  druid系统异常
         **/
        REQUEST_DRUID_EXCEPTION("10005", "query data from oak exception"),

        USERGROUP_HAS_NAME("10006","分群名已被使用");

        private String code;
        private String msg;

        private ErrorCodeMsg(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
