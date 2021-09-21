package MELT.TestDomain.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by melodist
 * User: MELT
 * Date: 2021-09-21 021
 * Time: 오후 5:07
 *
 * Test Controller
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "test_success";
    }
}
