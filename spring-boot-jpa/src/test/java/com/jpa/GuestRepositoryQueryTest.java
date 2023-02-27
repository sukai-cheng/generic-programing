package com.jpa;

import com.jpa.entity.Guest;
import com.jpa.entity.Room;
import com.jpa.entity.Student;
import com.jpa.entity.Teacher;
import com.jpa.repository.GuestRepository;
import com.jpa.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;

@DataJpaTest
@Slf4j
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GuestRepositoryQueryTest {

    @Resource
    private GuestRepository guestRepository;

    @Resource
    private RoomRepository roomRepository;

    @BeforeAll
    @Rollback(value = false)
    @Transactional
    void init() {

        Guest guest1 = Guest.builder().name("John").build();
        Guest guest2 = Guest.builder().name("Lily").build();
        ArrayList<Guest> guests = Lists.newArrayList(guest1, guest2);
        Room room = Room.builder().title("Suzhou Hotel").guests(Lists.newArrayList(guest1, guest2)).build();
        guestRepository.saveAll(Lists.newArrayList(guest1, guest2));
        roomRepository.save(room);
    }

    @Test
    @Rollback(value = false)
    public void testGuestRelationships() {

        // jpa默认lazy loader
        // 查询room并不会把guest的信息查询出来
        Room room = roomRepository.getOne(6L);

        // 当调用room.getGuests时，则会去查询
        System.out.println(room.getGuests());
    }
}
