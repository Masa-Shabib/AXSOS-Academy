package com.projectManager.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.projectManager.modeles.Project;
import com.projectManager.modeles.User;


@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{
	List <Project> findAll();
	Optional <List<Project>> findByTeamMembersNotContains(User user);
	Optional <List<Project>> findByTeamMembersContains(User user);
	
}
