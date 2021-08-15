package org.itbl.controller;

import java.util.List;

import org.itbl.entity.ToDo;
import org.itbl.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ToDoController {
	
	@Autowired
	private ToDoService toDoService;

	@GetMapping("/api/v1/toDoList")
	public ResponseEntity<?> fetchAllToDoItems(){
		
		 List<ToDo> toDoList = toDoService.fetchAllToDoItems();
		 
		 System.out.println(toDoList);
		 
		 return ResponseEntity.ok(toDoList);
		
		
	}
	
	@PutMapping("/api/v1//toDoItem/{id}")
	public ResponseEntity<?> updateToDoItem(@PathVariable("id")Long id, @RequestBody ToDo toDo){
		
		 ToDo updatedtoDoItem = toDoService.updateToDoItem(id, toDo);
		 
		 System.out.println(updatedtoDoItem);
		 
		 return ResponseEntity.ok(updatedtoDoItem);
		
		
	}
	
	
	@PostMapping("/api/v1/toDoItem")
	public ResponseEntity<?> createToDoItem(){
		
		List<ToDo> toDoItem = toDoService.createToDoItem();
		
		 return ResponseEntity.ok(toDoItem);
	}
}
