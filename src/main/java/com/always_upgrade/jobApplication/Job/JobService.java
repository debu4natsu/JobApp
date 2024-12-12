package com.always_upgrade.jobApplication.Job;

import java.util.List;

public interface JobService {
    List<Jobs> findAll();
    void createJobs(Jobs jobs);
    Jobs findById(Long id);
    boolean jobdDeleted(Long id);
    boolean updatedJob(Long id, Jobs updatedjob);
}
