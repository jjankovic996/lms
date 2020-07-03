package com.lms.lms.service;

import com.lms.lms.enums.Role;
import com.lms.lms.model.Admin;
import com.lms.lms.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    /**
     * Method used for admin creation
     * @param username admin username
     */
    public void createAdmin(String username){
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setActive(true);
        admin.setRole(Role.ADMIN);

        adminRepository.save(admin);
    }

    /**
     * Method for deactivating admin
     * @param username admin username
     */
    public void deactivateAdmin(String username){
        Admin admin = adminRepository.findOneByUsername(username);

        admin.setActive(false);

        adminRepository.save(admin);
    }

    /**
     * Method for retrieving all admins
     * @return list of admins
     */
    public List<Admin> getAdmins(){

        return adminRepository.findByRole(Role.ADMIN);
    }
}
