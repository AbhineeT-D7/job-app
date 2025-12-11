package com.abhi.Job_APP2.Repo;

import com.abhi.Job_APP2.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface jobrepo extends JpaRepository<JobPost,Integer>{
    List<JobPost> findByPostProfileContainingIgnoreCaseOrPostDescContainingIgnoreCase(String postProfile, String postDesc);

//    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
//            new JobPost(
//                    1,
//                    "Java Developer",
//                    "Responsible for building and maintaining RESTful services.",
//                    3,
//                    Arrays.asList("Java", "Spring Boot", "MySQL")
//            ),
//            new JobPost(
//                    2,
//                    "Frontend Developer",
//                    "Design and implement responsive UI components.",
//                    2,
//                    Arrays.asList("React", "JavaScript", "HTML", "CSS")
//            ),
//            new JobPost(
//                    3,
//                    "Data Analyst",
//                    "Analyze data trends to help business decision-making.",
//                    1,
//                    Arrays.asList("Python", "Pandas", "SQL", "Power BI")
//            )
//    ));
//
//    public void save(JobPost job) {
//        jobs.add(job);
//        System.out.println(jobs);
//    }
//
//    public List<JobPost> findall() {
//        return jobs;
//    }
//
//    public JobPost getone(int n) {
//        for(JobPost onejob:jobs){
//            if(onejob.postId==n){
//                return onejob;
//            }
//        }
//        return null;
//    }
//
//    public void update(JobPost job) {
//        for(JobPost job1:jobs){
//            if(job.getPostId()==job1.getPostId()){
//                job1.setPostId(job.getPostId());
//                job1.setPostDesc(job.getPostDesc());
//                job1.setPostProfile(job.getPostProfile());
//                job1.setReqExperience(job.getReqExperience());
//                job1.setPostTechStack(job.getPostTechStack());
//            }
//        }
//    }
//
//    public void deleted(int id) {
//        for(JobPost job:jobs){
//            if(job.getPostId()==id){
//                jobs.remove(job);
//            }
//        }
//    }
}
