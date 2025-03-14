package com.aiJobApplication.service;

import com.aiJobApplication.model.Applications;
import com.aiJobApplication.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public Applications addApplication(Applications applications){
        return applicationRepository.save(applications);
    }
}
