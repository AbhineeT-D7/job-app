package com.subho.Job_APP2.Service;

import com.subho.Job_APP2.Repo.jobrepo;
import com.subho.Job_APP2.model.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class jobservice {

   private jobrepo repo;

    public jobrepo getRepo() {
        return repo;
    }
   @Autowired
    public void setRepo(jobrepo repo) {
        this.repo = repo;
    }

    public void setjob(JobPost job) {
        repo.save(job);
    }

    public List<JobPost> getjob() {

        return repo.findAll();
    }

    public Optional<JobPost> getonejob(int n) {
        return repo.findById(n);
    }

    public void update(JobPost job) {
        repo.save(job);
    }

    public void deleted(int id) {
        JobPost job=repo.getReferenceById(id);
        repo.delete(job);
    }
    public void load(){
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
                new JobPost(
                        1,
                        "Java Developer",
                        "Responsible for building and maintaining RESTful services.",
                        3,
                        Arrays.asList("Java", "Spring Boot", "MySQL")
                ),
                new JobPost(
                        2,
                        "Frontend Developer",
                        "Design and implement responsive UI components.",
                        2,
                        Arrays.asList("React", "JavaScript", "HTML", "CSS")
                ),
                new JobPost(
                        3,
                        "Data Analyst",
                        "Analyze data trends to help business decision-making.",
                        1,
                        Arrays.asList("Python", "Pandas", "SQL", "Power BI")
                )
        ));
        repo.saveAll(jobs);
    }

    public List<JobPost> search(String key) {
       return repo.findByPostProfileContainingIgnoreCaseOrPostDescContainingIgnoreCase(key,key);
    }


    //when we work with repo and manual add data not use database

//    public void setjob(JobPost job) {
//     repo.save(job);
//    }
//
//    public List<JobPost> getjob() {
//
//        return repo.findall();
//    }
//
//    public JobPost getonejob(int n) {
//        return repo.getone(n);
//    }
//
//    public void update(JobPost job) {
//        repo.update(job);
//    }
//
//    public void deleted(int id) {
//        repo.deleted(id);
//    }
}

