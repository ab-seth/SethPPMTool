package com.spring.boot.react.ppmtool.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.react.ppmtool.domain.Project;
import com.spring.boot.react.ppmtool.service.MapValidationErrorService;
import com.spring.boot.react.ppmtool.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	@PostMapping("")
	public ResponseEntity<?> createNewProject(
			@Valid @RequestBody Project project, BindingResult result){
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
		if(errorMap!=null) return errorMap;
		
		
		Project theProject = projectService.saveOrUpdate(project);
		return new ResponseEntity<Project>(project,HttpStatus.CREATED);
	}
	
	@GetMapping("/{projectId}")
	public ResponseEntity<?> getProjectById(@PathVariable String projectId){
		Project project = projectService.findByProjectIdentifier(projectId);
		
		return new  ResponseEntity<Project>(project,HttpStatus.OK);
	}

}
