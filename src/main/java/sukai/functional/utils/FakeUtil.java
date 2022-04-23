package sukai.functional.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

/**
 * @description 仿真数据
 *
 * @author chengsukai
 *
 * @create 2022-04-18 17:41
 **/
public class FakeUtil {

    public static Faker createChineseFaker() {
        return new Faker(new Locale("zh", "CN"));
    }
}