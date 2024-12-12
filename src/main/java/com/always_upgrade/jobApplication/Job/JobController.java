package com.always_upgrade.jobApplication.Job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private JobService jobservice;

    public JobController(JobService jobservice) {
        this.jobservice = jobservice;
    }

    @GetMapping
    public ResponseEntity<List<Jobs>> findAllJobs(){
        return new ResponseEntity<>(jobservice.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Jobs job){
        jobservice.createJobs(job);
        return new ResponseEntity("Job Addded Successfully",HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jobs> getJobByID(@PathVariable Long id){
     Jobs job=jobservice.findById(id);
     if(job!=null) {
         return new ResponseEntity<>(job,HttpStatus.OK);
     }
     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean deleted=jobservice.jobdDeleted(id);
        if(deleted==true){
            return new ResponseEntity<>("Job Deleted Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Can't Delete the specific Job",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id,@RequestBody Jobs updatedjob){
       boolean updated=jobservice.updatedJob(id,updatedjob);
       if(updated){
           return new ResponseEntity<>("Job Updated",HttpStatus.OK);
       }
       return new ResponseEntity<>("Job Not Updated",HttpStatus.NOT_FOUND);
    }
}
