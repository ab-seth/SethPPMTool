package com.spring.boot.react.ppmtool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.react.ppmtool.domain.Project;
import com.spring.boot.react.ppmtool.exception.ProjectIdException;
import com.spring.boot.react.ppmtool.repository.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveOrUpdate(Project project) {
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return projectRepository.save(project);
			
		} catch (Exception e) {
			throw new ProjectIdException("Project Id"+
		project.getProjectIdentifier().toUpperCase()+"Alreday exists");
		}
		
		
	}
	
	public Project findByProjectIdentifier(String projectId) {
		
		Project project =projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		
		if(project==null) {
			throw new ProjectIdException("Project Id Not found");
		}
		
		return project;
	}

}
