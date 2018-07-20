package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTestSuite {
    @Autowired
    TaskMapper taskMapper;

    @Test
    public void shouldMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "test task", "description");
        //When
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        assertNotNull(task);
        assertEquals(1L, task.getId().longValue());
        assertEquals("test task", task.getTitle());
        assertEquals("description", task.getContent());
    }
    @Test
    public void shouldMapToTaskDto() {
        //Given
        Task task = new Task(1L, "test task", "description");
        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //Then
        assertNotNull(taskDto);
        assertEquals(1L, taskDto.getId().longValue());
        assertEquals("test task", taskDto.getTitle());
        assertEquals("description", taskDto.getContent());
    }
    @Test
    public void shouldMapToTaskDtoList() {
        //Given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1L, "test task", "description"));
        //When
        List<TaskDto> taskDtos = taskMapper.mapToTaskDtoList(taskList);
        //Then
        assertNotNull(taskDtos);
        assertEquals(1, taskDtos.size());
        assertEquals(1L, taskDtos.get(0).getId().longValue());
        assertEquals("test task", taskDtos.get(0).getTitle());
        assertEquals("description", taskDtos.get(0).getContent());
    }
}
