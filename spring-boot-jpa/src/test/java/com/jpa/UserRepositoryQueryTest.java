package com.jpa;

import com.jpa.entity.User;
import com.jpa.entity.UserExtend;
import com.jpa.model.UserDto;
import com.jpa.model.UserOnlyName;
import com.jpa.repository.UserExtendRepository;
import com.jpa.repository.UserRepository;
import com.jpa.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Resource;
import java.util.List;

@DataJpaTest
@Slf4j
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryQueryTest {
    @Resource
    private UserRepository userRepository;

    @Resource
    private UserExtendRepository userExtendRepository;

    @Test
    @Rollback(value = false)
    public void testQueryAnnotation() {

        userRepository.save(User.builder().firstName("simon").lastName("simon").email("simon@gmail.com").sex("man").address("shanghai").build());
        UserOnlyName res = userRepository.findByLastName("simon");

        log.warn("userRepository..save..response:{}", JsonUtil.toJson(res));
        log.warn("res" + " ==> " + res.getFirstName() + " " + res.getEmail());

    }

    @Test
    public void testQuery() {
        List<User> res = userRepository.findByLastNameEndsWith("sukai");
        System.out.println(res);
    }

    @Test
    public void testSortQuery() {
        List<User> res = userRepository.findByLastNameOrderByLastName("simon");
        System.out.println(res);
    }

    @Test
    public void testPageQuery() {
        Sort sort = Sort.by(Sort.Order.desc("lastName"));
        Pageable pageable = PageRequest.of(0, 10, sort);
        Page<User> res = userRepository.findByLastName("simon", pageable);
        System.out.println("res" + "\n:" + "\n elements: " + res.getTotalElements() + "\n total_pages: " + res.getTotalPages() + "\n content: " + res.getContent());
    }

    @Test
    @Rollback(value = false)
    public void testQueryAnnotationDto() {
        userRepository.save(User.builder().firstName("jack").email("jack@gmail.com").sex("man").address("shanghai").build());

        userExtendRepository.save(UserExtend.builder().userId(1L).idCard("china bank").ages(18).studentNumber("jack001").build());

        UserDto userDto = userRepository.findByUserDtoId(1L);

        System.out.println(userDto);
        System.out.println(userDto.getName() + ": " + userDto.getEmail() + ":" + userDto.getIdCard());

    }

    @Test
    @Rollback(value = false)
    public void testQueryDynamicDto() {
        userRepository.save(User.builder().firstName("Richard").email("richord@gmail.com").sex("man").address("suzhou").build());

        UserOnlyName userDto = userRepository.findByUser("Richard", null);
        System.out.println(userDto.getFirstName() + " : " + userDto.getEmail());

        UserOnlyName res = userRepository.findByUser(null, "richord@gmail.com");
        System.out.println(res.getFirstName() + " : " + res.getEmail());
    }


}
