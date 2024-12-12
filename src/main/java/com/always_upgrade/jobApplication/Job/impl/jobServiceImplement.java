package com.always_upgrade.jobApplication.Job.impl;

import com.always_upgrade.jobApplication.Job.Jobs;
import com.always_upgrade.jobApplication.Job.JobRepository;
import com.always_upgrade.jobApplication.Job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class jobServiceImplement implements JobService {

   // private List<Jobs> jobs=new ArrayList<>();
    JobRepository jobRepository;

    public jobServiceImplement(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Jobs> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJobs(Jobs job) {
        jobRepository.save(job);
    }

    @Override
    public Jobs findById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean jobdDeleted(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean updatedJob(Long id, Jobs updatedjob) {
        Optional<Jobs> jobsOptional=jobRepository.findById(id);
            if(jobsOptional.isPresent()){
                Jobs job=jobsOptional.get();
                job.setTitle(updatedjob.getTitle());
                job.setDescription(updatedjob.getDescription());
                job.setMinSalary(updatedjob.getMinSalary());
                job.setMaxSalary(updatedjob.getMaxSalary());
                job.setLocation(updatedjob.getLocation());
                jobRepository.save(job);
                return true;
            }
        return false;
    }
}

