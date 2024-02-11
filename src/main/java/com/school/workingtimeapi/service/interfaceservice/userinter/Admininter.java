package com.school.workingtimeapi.service.interfaceservice.userinter;

import com.school.workingtimeapi.entity.user.Admin;

import java.util.List;

public interface Admininter {

    List<Admin> findAll();

    Admin save(Admin a);

    Admin update(Long id, Admin a);

    void delete(Long id);

}
