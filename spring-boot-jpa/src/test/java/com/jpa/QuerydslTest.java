package com.jpa;

import com.jpa.entity.QRoom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;

@DataJpaTest
@Slf4j
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class QuerydslTest {
    @Autowired
    private EntityManager entityManager;

    @Test
    @Rollback(value = false)
    public void test() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QRoom qRoom = QRoom.room;
        queryFactory.update(qRoom).set(qRoom.title, "W Hotel").where(qRoom.id.eq(9L)).execute();
    }
}
