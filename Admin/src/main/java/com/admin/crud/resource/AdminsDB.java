package com.admin.crud.resource;

import com.admin.crud.model.Admins;
import com.admin.crud.repository.AdminsRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminsDB {

    private AdminsRepository adminsRepository;

    public AdminsDB(AdminsRepository adminsRepository) {
        this.adminsRepository = adminsRepository;
    }

    @GetMapping("/Admins")
    public List<Admins> getAllAdmins() {
        return adminsRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admins> getAdminById(@PathVariable(value = "id")
                                                           Integer id) throws ResourceNotFoundException {
        Admins Admin = adminsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Admin found!" + id));
        return ResponseEntity.ok().body(Admin);
    }



    @PostMapping("/Admins")
    public Admins createAdmin(@Valid @RequestBody Admins Admin) {
        return adminsRepository.save(Admin);
    }

    @PutMapping("/Admins/{id}")
    public ResponseEntity<Admins> updateAdmin(@PathVariable(value = "id") Integer id ,
                                                  @Valid @RequestBody Admins AdminInfo) throws ResourceNotFoundException {
        Admins Admin = adminsRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No Admin for this id" + id));

        Admin.setPrenom(AdminInfo.getPrenom());
        Admin.setNom(AdminInfo.getNom());
        Admin.setAbscence(AdminInfo.getAbscence());

        final Admins updatedAdmin = adminsRepository.save(Admin);
        return ResponseEntity.ok(updatedAdmin);
    }

    @DeleteMapping("/Admins/{id}")
    public Map<String, Boolean> deleteAdmin(@PathVariable Integer id) throws ResourceNotFoundException {
        Admins Admin = adminsRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No Admin found for " + id));
        adminsRepository.delete(Admin);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
