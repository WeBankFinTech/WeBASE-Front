/*
 * Copyright 2014-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.webank.webase.front.monitor;

import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME;
import com.webank.webase.front.base.config.Web3Config;
import com.webank.webase.front.monitor.entity.GroupSizeInfo;
import com.webank.webase.front.performance.result.PerformanceData;
import com.webank.webase.front.util.CommonUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Node monitor controller distinguished from host monitor: performance
 */
@Slf4j
@RestController
@RequestMapping(value = "/chain")
public class MonitorController {

    @Autowired
    private MonitorService monitorService;
    @Autowired
    private Web3Config web3Config;

    @ApiOperation(value = "查询链上数据", notes = "查询链上数据")
    @ApiImplicitParams({@ApiImplicitParam(name = "beginDate", value = "开始时间"),
            @ApiImplicitParam(name = "endDate", value = "结束时间"),
            @ApiImplicitParam(name = "contrastBeginDate", value = "对比开始时间"),
            @ApiImplicitParam(name = "contrastEndDate", value = "对比结束时间"),
            @ApiImplicitParam(name = "gap", value = "时间间隔", dataType = "int")})
    @GetMapping
    public List<PerformanceData> getChainMonitor(
            @RequestParam(required = false) @DateTimeFormat(
                    iso = DATE_TIME) LocalDateTime beginDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DATE_TIME) LocalDateTime endDate,
            @RequestParam(required = false) @DateTimeFormat(
                    iso = DATE_TIME) LocalDateTime contrastBeginDate,
            @RequestParam(required = false) @DateTimeFormat(
                    iso = DATE_TIME) LocalDateTime contrastEndDate,
            @RequestParam(required = false, defaultValue = "1") int gap,
            @RequestParam(defaultValue = "1") int groupId) {
        log.info("getChainMonitor start. groupId:[{}]", groupId);

        Instant startTime = Instant.now();
        log.info("getChainMonitor start startTime:{}", startTime.toEpochMilli());

        List<PerformanceData> performanceList = monitorService.findContrastDataByTime(groupId,
                beginDate, endDate, contrastBeginDate, contrastEndDate, gap);

        log.info("getChainMonitor end  useTime:{}",
                Duration.between(startTime, Instant.now()).toMillis());
        return performanceList;
    }

    @ApiOperation(value = "检查节点进程连接")
    @GetMapping("/checkNodeProcess")
    public boolean checkNodeProcess() {
        log.info("checkNodeProcess start.");
        return CommonUtils.checkConnect(web3Config.getIp(),
                Integer.valueOf(web3Config.getChannelPort()));
    }

    @ApiOperation(value = "获取群组大小信息")
    @GetMapping("/getGroupSizeInfos")
    public List<GroupSizeInfo> getGroupSizeInfos() {
        log.info("getGroupSizeInfos start.");
        return monitorService.getGroupSizeInfos();
    }
}
