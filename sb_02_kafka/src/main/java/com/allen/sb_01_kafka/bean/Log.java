package com.allen.sb_01_kafka.bean;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@Setter
@Getter
public class Log {
    private String userId;
    private String action;
    private String card;
    private String actionTime;
}
