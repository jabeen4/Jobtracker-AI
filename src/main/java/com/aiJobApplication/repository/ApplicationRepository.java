package com.aiJobApplication.repository;

import com.aiJobApplication.model.Applications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Applications,Long> {
}
