package org.itbl.service;

import java.util.List;
import java.util.Optional;

import org.itbl.entity.ToDo;
import org.itbl.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {
	
	@Autowired
	private ToDoRepository toDoRepository;

	public List<ToDo> fetchAllToDoItems(){
		return  toDoRepository.fetchAllToDoItems();
		
	}
	
	
	public ToDo updateToDoItem(Long id, ToDo toDo){
		
		Optional<ToDo> toDoItem = toDoRepository.fetchAllToDoItems()
						.stream()
						.filter(item -> item.getId().equals(id))
						.findAny();
		
		if(toDoItem.isPresent()) {
			ToDo item = toDoItem.get();
			item.setIsDone(toDo.getIsDone());
			item.setTask(toDo.getTask());
			
			return item;
			
		}
						
		return null;
		
	}
	
	public List<ToDo> createToDoItem(ToDo toDo){
		
		ToDo toDoitem = new ToDo();
		
		toDoitem.setTask(toDo.getTask());
		toDoitem.setIsDone(false);
		
		List<ToDo> toDoitemList = toDoRepository.save(toDoitem);
		
		
		return toDoitemList;
		
	}
	
	public void deleteToDoItem(Long id){
		
		toDoRepository.delete(id);
		
		
		
		
	}
}
