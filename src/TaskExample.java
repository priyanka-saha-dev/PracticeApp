import java.util.Comparator;
import java.util.LinkedList;

public class TaskExample {

    static LinkedList<Task> TASKS = new LinkedList<>();

    public static void main(String[] args) {

        TaskExample taskExample = new TaskExample();

        Task task1 = taskExample.createTask(1);
        Task task2 = taskExample.createTask(2);
        Task task3 = taskExample.createTask(3);

        taskExample.addDependency(task3, task1);
        taskExample.addDependency(task3, task2);

        System.out.println("Before sort");
        TASKS.stream().map(Task::getId).forEach(System.out::println);

        taskExample.sortTasks();

        System.out.println("After sort");
        TASKS.stream().map(Task::getId).forEach(System.out::println);
    }

    class Task {
        private int id;
        private Task dependency;

        public Task(int id) {
            this.id = id;
            this.dependency = null;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Task getDependency() {
            return dependency;
        }

        public void setDependency(Task dependency) {
            this.dependency = dependency;
        }


    }

    public Task createTask(int id) {
        Task task = new Task(id);
        TASKS.add(task);
        return task;
    }

    private void addDependency(Task task, Task dependency) {
        TASKS.stream().filter(t -> t.getId() == task.getId()).forEach(t -> t.setDependency(dependency));
    }

    public void sortTasks() {
        TASKS.sort(Comparator.comparing(task -> {
            Task dependency = getDependencies(task);
            System.out.println("Task = " + task.getId() + " is dependent on task = " + dependency.getId());
            return dependency.getId() == task.getId();
        }));
    }

    private static Task getDependencies(Task task) {
        if(task.getDependency() != null) {
            return getDependencies(task.getDependency());
        } else {
            return task;
        }
    }


}


