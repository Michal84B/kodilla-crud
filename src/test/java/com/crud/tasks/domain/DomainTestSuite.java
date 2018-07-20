package com.crud.tasks.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DomainTestSuite {
    @Test
    public void shouldCreateTask() {
        //Given
        Task task = new Task(1L,"task_name", "description");
        //When&Then
        assertNotNull(task);
        assertEquals(1L, task.getId().longValue());
        assertEquals("task_name", task.getTitle());
        assertEquals("description", task.getContent());
    }
    @Test
    public void shouldCreateTaskDto() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "task_name", "description");
        //When&Then
        assertNotNull(taskDto);
        assertEquals(1L, taskDto.getId().longValue());
        assertEquals("task_name", taskDto.getTitle());
        assertEquals("description", taskDto.getContent());
    }
}
