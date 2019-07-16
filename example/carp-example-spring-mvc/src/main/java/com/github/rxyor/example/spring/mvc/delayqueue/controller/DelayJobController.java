package com.github.rxyor.example.spring.mvc.delayqueue.controller;

import com.github.rxyor.common.core.model.R;
import com.github.rxyor.common.core.util.RUtil;
import com.github.rxyor.distributed.redisson.delay.core.DelayClientProxy;
import com.github.rxyor.distributed.redisson.delay.core.DelayJob;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *<p>
 *
 *</p>
 *
 * @author liuyang
 * @date 2019-05-29 Wed 14:56:00
 * @since 1.0.0
 */
@RestController
@AllArgsConstructor
@RequestMapping("/delay")
public class DelayJobController {

    private final DelayClientProxy delayClientProxy;

    @PostMapping("/job/add")
    @ResponseBody
    public R addDelayJob(@RequestBody DelayJob<Map<String, Object>> delayJob) {
        if (delayJob.getExecTime() == null) {
            delayJob.setExecTime(System.currentTimeMillis() / 1000 + 10);
        }
        delayClientProxy.offer(delayJob);
        return RUtil.success(delayJob);
    }
}
