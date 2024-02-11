package com.school.workingtimeapi.service.implementation.userservice;

import com.school.workingtimeapi.entity.user.Role;
import com.school.workingtimeapi.entity.user.UserDetails;
import com.school.workingtimeapi.repository.userrepository.UserRepository;
import com.school.workingtimeapi.service.interfaceservice.userinter.UserInter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserInter {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDetails> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public List<UserDetails> getAllByRole(Role role) {
        return this.userRepository.findUserDetailsByRole(role);
    }

    @Override
    public UserDetails create(UserDetails userDetails) {
        return this.userRepository.save(userDetails);
    }

    @Override
    public UserDetails update(Long ig ,UserDetails userDetails) {
        UserDetails userDetailsExisting = this.userRepository.findById(ig).orElseThrow(() -> new RuntimeException("User not found with id: " + ig));
        BeanUtils.copyProperties(userDetails, userDetailsExisting, "id");
        return this.userRepository.save(userDetailsExisting);
    }

    @Override
    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }
}
