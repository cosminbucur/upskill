package com.sda.spring.aop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OutputService {

    private static final Logger log = LoggerFactory.getLogger(OutputService.class);

    private final VersionService versionService;
    private final TimeService timeService;
    @Value("${app.name}")
    private String appName;

    @Autowired
    public OutputService(VersionService versionService, TimeService timeService) {
        this.versionService = versionService;
        this.timeService = timeService;
    }

    public void generateOutput() {
        // current time + version
        String output = timeService.getCurrentTime() + " " + versionService.getVersion(appName);
        log.info("output: {}", output);
    }
}
