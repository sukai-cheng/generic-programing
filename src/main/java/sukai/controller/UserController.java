package sukai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * curl http://127.0.0.1:8099/api/profile/user
 *
 * @author chengsukai
 * @since 2022-10-08 09:54
 */
@Controller
@RequestMapping(value = "profile")
public class UserController {
    @GetMapping("user")
    public User user(String str) {
        return User.builder()
                .id(1)
                .name("chengsukai")
                .build();
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
        test();
    }

    public static void test() {
        long total = 0L;
        for (int i = 0; i < 10000; i++) {
            total += i;
        }
        System.out.println("total == " + total);
    }
}