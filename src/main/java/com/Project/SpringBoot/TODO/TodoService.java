package com.Project.SpringBoot.TODO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
@Service
public class TodoService {
	private static int todocount=0;
private static List<Todo> todos=new ArrayList<>();
static {
	todos.add(new Todo(++todocount,"hasini","learn java in  ",
			LocalDate.now().plusYears(1),false));
	todos.add(new Todo(++todocount,"hasini","learn spring in ",
			LocalDate.now().plusYears(2),false));
	todos.add(new Todo(++todocount,"hasini","learn sql in ",
			LocalDate.now().plusYears(3),false));
	
}
public List<Todo> findbyusername(String username){
	Predicate<? super Todo> predicate = todo ->todo.getUsername().equalsIgnoreCase(username) ;

	return todos.stream().filter(predicate).toList();
}
public void addTodo(String username,String description,LocalDate TargetDate,boolean done)
{
	Todo todo=new Todo(++todocount,username,description,TargetDate,done);
	todos.add(todo);
}

public void deleteById(int id) { 
	Predicate<? super Todo> predicate = todo ->todo.getId() == id ;
	todos.removeIf(predicate);
}
public Todo findById(int id) { 
	Predicate<? super Todo> predicate = todo ->todo.getId() == id ;
	Todo todo=todos.stream().filter(predicate).findFirst().get();
	return todo;
}
public void updateTodo(@Valid Todo todo) { 
	deleteById(todo.getId());
	todos.add(todo);
}

}
