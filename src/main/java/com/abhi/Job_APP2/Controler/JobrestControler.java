package com.abhi.Job_APP2.Controler;

import com.abhi.Job_APP2.Service.jobservice;
import com.abhi.Job_APP2.model.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")//to connect with frontent server
public class JobrestControler {
    @Autowired
    jobservice service;
    @GetMapping("jobPosts")
    @ResponseBody//to treate the data asa  json data mainly covert data to a file
    public List<JobPost> getjob(){
        return service.getjob();
    }
    @GetMapping("jobPost/{id}")
    public Optional<JobPost> getone(@PathVariable("id") int id){
        return service.getonejob(id);
    }

    @PostMapping ("jobPost")
    public Optional<JobPost> addjob(@RequestBody JobPost job){
        service.setjob(job);
//        return job;//throu that we can see the newly added job
        //we can do it by calling the job id
        return service.getonejob(job.getPostId());
    }
    @PutMapping("jobPosts")
    public Optional<JobPost> update(@RequestBody JobPost job){
        service.update(job);
        return service.getonejob(job.getPostId());
    }

    @DeleteMapping("jobPost/{id}")
    public String delete(@PathVariable int id){
        service.deleted(id);
        return "Deleted";
    }
    @PostMapping("/load")
    public String load(){
        service.load();
        return "succes";
    }
    @GetMapping("jobPosts/keyword/{key}")
    public List<JobPost> searchBykeyword(@PathVariable("key") String key){
        return service.search(key);
    }
}
