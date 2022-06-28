package com.kodilla.stream.portfolio;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTestSuite {

    private Board prepareTestData() {

        User user1 = new User("developer1", "John Smith");
        User user2 = new User("projectmanager1", "Nina White");
        User user3 = new User("developer2", "Emilia Stephanson");
        User user4 = new User("developer3", "Konrad Bridge");

        Task task1 = new Task("Microservice for taking temperature",
                "Write and test the microservice taking\n" +
                        "the temperaure from external service",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(30));
        Task task2 = new Task("HQLs for analysis",
                "Prepare some HQL queries for analysis",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().minusDays(5));
        Task task3 = new Task("Temperatures entity",
                "Prepare entity for temperatures",
                user3,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(15));
        Task task4 = new Task("Own logger",
                "Refactor company logger to meet our needs",
                user3,
                user2,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(25));
        Task task5 = new Task("Optimize searching",
                "Archive data searching has to be optimized",
                user4,
                user2,
                LocalDate.now(),
                LocalDate.now().plusDays(5));
        Task task6 = new Task("Use Streams",
                "use Streams rather than for-loops in predictions",
                user4,
                user2,
                LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(2));

        TaskList taskListToDo = new TaskList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);
        TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);

        Board project = new Board("Project Weather Prediction");
        project.addTaskList(taskListToDo);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);

        return project;
    }

    @Test
    public void testAddTaskList() {

        Board project = prepareTestData();

        assertEquals(3, project.getTaskLists().size());
    }

    @Test
    public void testAddTaskListFindUsersTasks() {

        Board project = prepareTestData();

        User user = new User("developer1", "John Smith");

        List<Task> listOfTasks = project.getTaskLists().stream()
                .flatMap(list -> list.getTasks().stream())
                .filter(task -> task.getAssignedUser().equals(user))
                .collect(toList());

        assertEquals(2, listOfTasks.size());
        assertEquals(user, listOfTasks.get(0).getAssignedUser());
        assertEquals(user, listOfTasks.get(1).getAssignedUser());
    }

    @Test
    void testAddTaskListFindOutdatedTasks() {

        Board project = prepareTestData();

        List<Task> listOfTasks = project.getTaskLists().stream()
                .filter(date -> date.getName().equals("In progress") || date.getName().equals("To do"))
                .flatMap(list -> list.getTasks().stream())
                .filter(task -> task.getDeadline().isBefore(LocalDate.now()))
                .collect(Collectors.toList());

        assertEquals(1, listOfTasks.size());
        assertEquals("HQLs for analysis", listOfTasks.get(0).getTitle());
    }

    @Test
    void testAddTaskListFindLongTasks() {

        Board project = prepareTestData();

        List<TaskList> listInProgress = new ArrayList<>();
        listInProgress.add(new TaskList("In progress"));

        long tasks = project.getTaskLists().stream()
                .filter(listInProgress::contains)
                .flatMap(list -> list.getTasks().stream())
                .map(task -> task.getCreated())
                .filter(d -> d.compareTo(LocalDate.now().minusDays(10)) <= 0)
                .count();

        assertEquals(2,tasks);
    }

    @Test
    public void testAddTaskListAverageWorkingOnTask() {

        Board project = prepareTestData();

        List<TaskList> listInProgress = new ArrayList<>();
        listInProgress.add(new TaskList("In progress"));

        List<Long> listOfDays = project.getTaskLists().stream()
                .filter(listInProgress::contains)
                .flatMap(list -> list.getTasks().stream())
                .map(task -> task.getCreated())
                .map(date -> ChronoUnit.DAYS.between(date,LocalDate.now()))
                .collect(toList());

        OptionalDouble average = LongStream.range(0, listOfDays.size())
                .map(i -> listOfDays.get((int)i))
                .average();
        assertEquals(OptionalDouble.of(10.0),average);


    }
}
