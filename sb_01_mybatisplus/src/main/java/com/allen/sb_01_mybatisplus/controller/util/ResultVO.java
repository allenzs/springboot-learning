package com.allen.sb_01_mybatisplus.controller.util;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultVO {
    private Boolean flag;
    private Object data;
    private String msg;

    public ResultVO(String msg) {
        this.msg = msg;
    }

    public ResultVO(Boolean flag) {
        this.flag = flag;
    }

    public ResultVO(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public ResultVO(Boolean flag, String message) {
        this.flag = flag;
        this.msg = message;
    }
}
