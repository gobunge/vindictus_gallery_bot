package io.github.gobunge.api.controller;

import io.github.gobunge.api.service.DcinsideBoardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dc")
public class DcinsideController {

    private final DcinsideBoardService dcinsideService;

    public DcinsideController(DcinsideBoardService dcinsideService) {
        this.dcinsideService = dcinsideService;
    }

    @GetMapping("")
    public void write() throws InterruptedException {
        dcinsideService.write();
    }
}
