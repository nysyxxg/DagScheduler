package com.wts.dag.scheduler;

import java.util.List;

/**
 * 封装任务对象
 */
public class Task implements Executor{
    private Long id; // 任务Id
    private String name; // 任务名称
    private int state = 0;  // 任务状态: 默认是0, 执行成功：1

    public Task(Long id, String name, int state) {
        this.id = id;
        this.name = name;
        this.state = state;
    }

    @Override
    public boolean execute() {
        try {
            Thread.sleep(2000);
            System.out.println(DateUtil.getFormatTimeStr()+ "  Task id: [" + id + "], " + "task name: [" + name +"] is running");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
        state = 1;
        return true;
    }

    public boolean hasExecuted() {
        return state == 1;
    }
}
