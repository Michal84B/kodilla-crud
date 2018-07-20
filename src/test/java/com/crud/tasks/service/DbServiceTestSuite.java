package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbServiceTestSuite {
    @InjectMocks
    DbService dbService;
    @Mock
    TaskRepository taskRepository;

    @Test
    public void testGetAllTasks() {
        //Given
        List<Task> taskList = new ArrayList<>();
        Task task = new Task(1L, "test task", "description");
        taskList.add(task);
        when(taskRepository.findAll()).thenReturn(taskList);
        //When
        List<Task> fetchedTaskList = dbService.getAllTasks();
        //Then
        assertNotNull(fetchedTaskList);
        assertEquals(1, fetchedTaskList.size());
        assertEquals(1L, fetchedTaskList.get(0).getId().longValue());
        assertEquals("test task", fetchedTaskList.get(0).getTitle());
        assertEquals("description", fetchedTaskList.get(0).getContent());
    }
    @Test
    public void testGetTask() {
        //Given
        Task task = new Task(1L, "test task", "description");
        when(taskRepository.findById(1L)).thenReturn(Optional.ofNullable(task));
        //When
        Optional<Task> fetchedTask = dbService.getTask(1L);
        //Then
        assertNotNull(fetchedTask);
    }
    @Test
    public void testSaveTask() {
        //Given
        Task task = new Task(1L, "test task", "description");
        when(taskRepository.save(task)).thenReturn(task);
        //When
        Task savedTask = dbService.saveTask(task);
        //Then
        assertEquals(1L, savedTask.getId().longValue());
    }
}
