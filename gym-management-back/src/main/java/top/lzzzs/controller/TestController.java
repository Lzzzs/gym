package top.lzzzs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lzzzs.common.R;

@RestController
public class TestController {

    @GetMapping("/test")
    public R test() {
        return R.success(null);
    }
}
