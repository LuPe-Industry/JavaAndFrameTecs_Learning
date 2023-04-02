package project.springThreadPool;

import org.springframework.core.task.TaskExecutor;

public class test {
    public static void main(String[] args) {
        TaskExecutor taskExecutor = new TaskExecutor() {
            @Override
            public void execute(Runnable task) {

            }
        };
    }

}
