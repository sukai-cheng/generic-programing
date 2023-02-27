package com.jpa.repository;

import com.jpa.entity.UserInfo;
import com.jpa.entity.UserInfoID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, UserInfoID> {

}
