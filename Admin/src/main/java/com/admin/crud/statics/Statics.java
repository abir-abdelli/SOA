package com.admin.crud.statics;

import com.admin.crud.model.Admins;
import com.admin.crud.repository.AdminsRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class Statics {
    private AdminsRepository adminsRepository;

    public Statics(AdminsRepository adminsRepository) {
        this.adminsRepository = adminsRepository;
    }

    public float tauxAbscence() {
        int sum = 0;
        List<Admins> admins =  adminsRepository.findAll();
        for (Admins All : admins) { sum += All.getAbscence(); }
        return (sum/admins.size());
    }

    public float SalairMoyen() {
        int sum = 0;
        List<Admins> admins =  adminsRepository.findAll();
        for (Admins All : admins) { sum += All.getSalair(); }
        return (sum/admins.size());
    }

}
