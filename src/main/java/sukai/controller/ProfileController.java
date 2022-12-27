package sukai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * curl http://127.0.0.1:8099/api/profile/test
 *
 * @author chengsukai
 * @since 2022-10-08 09:54
 */
@RestController
@RequestMapping(value = "profile")
public class ProfileController {
    @GetMapping("test")
    public void test() {
        while (true) {
            System.out.println("666");
        }
    }

    /**
     * curl:http://127.0.0.1:8099/api/profile/highCpu
     */
    @GetMapping("highCpu")
    public void highCpu() {
        while (true) {
            System.out.println("↑↑↑ CPU过高 ↑↑↑");
        }
    }
}
