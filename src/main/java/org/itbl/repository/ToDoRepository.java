package org.itbl.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.itbl.entity.ToDo;
import org.springframework.stereotype.Repository;

@Repository
public class ToDoRepository {
	
	private Long counter = (long) 0;
	private List<ToDo> toDoList = new ArrayList<>();

	public List<ToDo> fetchAllToDoItems(){
		
		if(toDoList.size() == 0) {
			
			ToDo item = 
					ToDo.builder()
						.id(counter++)
						.task("task1")
						.isDone(true)
						.build();
			
			toDoList.add(item);
			
		}
		
		
					

		
		return toDoList;
	}
	
	public List<ToDo> save(ToDo toDoitem){
		
		toDoitem.setId(counter++);
		
//		toDoitem.setTask("task "+ toDoitem.getId());
					
		toDoList.add(toDoitem);
		
		return toDoList;
	}
	
	public void delete(Long id) {
		

		 toDoList = toDoList
						.stream()
						.filter(item -> item.getId().equals(id))
						.collect(Collectors.toList());
	}
}
