package com.wts.dag.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 任务调度类
 */
public class Scheduler {
    public void schedule(Digraph digraph) {
        while (true) {
            List<Task> todo = new ArrayList<Task>();
            for (Task task : digraph.getTasks()) {
                if (!task.hasExecuted()) {
                    Set<Task> prevs = digraph.getMap().get(task);
                    if (prevs != null && !prevs.isEmpty()) {
                        boolean toAdd = true;
                        for (Task task1 : prevs) {
                            if (!task1.hasExecuted()) {
                                toAdd = false;
                                break;
                            }
                        }
                        if (toAdd) {
                            todo.add(task);
                        }
                    } else {
                        todo.add(task);
                    }
                }
            }
            System.out.println("Scheduler.schedule.....todo=" + todo.size());
            if (!todo.isEmpty()) {
                for (Task task : todo) {
                    if (!task.execute()) {
                        throw new RuntimeException();
                    }
                }
            } else {
                break;
            }
        }
    }
}
