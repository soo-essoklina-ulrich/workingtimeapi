package com.school.workingtimeapi.service.interfaceservice.userinter;

import com.school.workingtimeapi.entity.user.Role;
import com.school.workingtimeapi.entity.user.UserDetails;

import java.sql.SQLException;
import java.util.List;

public interface UserInter {

    List<UserDetails> getAll();

    List<UserDetails> getAllByRole(Role role);

    UserDetails create(UserDetails userDetails);
    UserDetails update(Long id, UserDetails userDetails) throws SQLException;
    void delete(Long id);
}
