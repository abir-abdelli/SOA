package com.admin.crud.repository;

import com.admin.crud.model.Admins;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminsRepository extends JpaRepository<Admins, Integer> {
}
