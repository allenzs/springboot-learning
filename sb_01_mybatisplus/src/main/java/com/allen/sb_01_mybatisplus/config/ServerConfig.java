package com.allen.sb_01_mybatisplus.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Component
@Data
@ConfigurationProperties(prefix = "server")
@Validated
public class ServerConfig {
    private String ipAddress;
    @Max(value = 10000,message = "最大端口10000")
    private int port;
    private long timeout;
    @DurationUnit(ChronoUnit.MILLIS)
    private Duration serverTimeOut;
//    @DataSizeUnit(DataUnit.BYTES)
    private DataSize dataSize;
}
