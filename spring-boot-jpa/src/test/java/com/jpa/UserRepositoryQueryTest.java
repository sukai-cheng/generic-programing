package com.jpa;

import com.jpa.entity.User;
import com.jpa.model.UserOnlyName;
import com.jpa.repository.UserRepository;
import com.jpa.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Resource;

@DataJpaTest
@Slf4j
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryQueryTest {
    @Resource
    private UserRepository userRepository;

    @Test
    @Rollback(value = false)
    public void testQueryAnnotation() {

        userRepository.save(User.builder().lastName("simon").email("simon@gmail.com").sex("man").address("shanghai").build());
        UserOnlyName res = userRepository.findByLastName("simon");

        log.warn("userRepository..save..response:{}", JsonUtil.toJson(res));
        log.warn("res" + " ==> " + res.getLastName() + " " + res.getEmail());

    }
}
