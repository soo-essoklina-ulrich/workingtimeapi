package com.school.workingtimeapi.service.implementation.userservice;

import com.school.workingtimeapi.entity.user.Admin;
import com.school.workingtimeapi.repository.userrepository.AdminRepository;
import com.school.workingtimeapi.service.interfaceservice.userinter.Admininter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminService implements Admininter {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public List<Admin> findAll() {
        return this.adminRepository.findAll();
    }

    @Override
    public Admin save(Admin a) {
        return this.adminRepository.save(a);
    }

    @Override
    public Admin update(Long id, Admin a) {
        Admin adminexisting = this.adminRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));
        BeanUtils.copyProperties(a, adminexisting, "id");
        return this.adminRepository.save(a);

    }

    @Override
    public void delete(Long id) {

    }
}
