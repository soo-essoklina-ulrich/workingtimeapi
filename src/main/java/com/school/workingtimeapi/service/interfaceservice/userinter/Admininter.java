package com.school.workingtimeapi.service.interfaceservice.userinter;

import com.school.workingtimeapi.entity.user.Admin;

import java.sql.SQLException;
import java.util.List;

public interface Admininter {

    List<Admin> findAll();

    Admin save(Admin a);

    Admin update(Long id, Admin a) throws SQLException;

    void delete(Long id);

}
