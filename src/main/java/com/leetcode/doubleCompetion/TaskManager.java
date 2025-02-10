package com.leetcode.doubleCompetion;

import java.util.HashSet;
import java.util.List;

import java.util.*;

class TaskManager {
    private HashSet<Integer> taskSet = new HashSet<>();
    private List<List<Integer>> tasks = new ArrayList<>();
    private Map<Integer, List<Integer>> taskMap = new HashMap<>();

    public TaskManager(List<List<Integer>> tasks) {
        if (tasks == null) {
            this.tasks = new ArrayList<>();
        } else {
            this.tasks = tasks;
            for (List<Integer> task : tasks) {
                taskMap.put(task.get(1), task);
            }
        }
    }

    public void add(int userId, int taskId, int priority) {
        if (taskSet.contains(taskId)) {
            return;
        }
        taskSet.add(taskId);
        List<Integer> task = List.of(userId, taskId, priority);
        tasks.add(task);
        taskMap.put(taskId, task);
    }

    public void edit(int taskId, int newPriority) {
        if (!taskSet.contains(taskId)) {
            return;
        }
        List<Integer> task = taskMap.get(taskId);
        tasks.remove(task);
        task = List.of(task.get(0), taskId, newPriority);
        tasks.add(task);
        taskMap.put(taskId, task);
    }

    public void rmv(int taskId) {
        if (!taskSet.contains(taskId)) {
            return;
        }
        taskSet.remove(taskId);
        List<Integer> task = taskMap.get(taskId);
        tasks.remove(task);
        taskMap.remove(taskId);
    }

    public int execTop() {
        if (tasks.isEmpty()) {
            return -1;
        }
        int maxPriority = Integer.MIN_VALUE;
        int maxPriorityTaskId = -1;
        int userId = -1;

        for (List<Integer> task : tasks) {
            int priority = task.get(2);
            int taskId = task.get(1);
            if (priority > maxPriority || (priority == maxPriority && taskId > maxPriorityTaskId)) {
                maxPriority = priority;
                maxPriorityTaskId = taskId;
                userId = task.get(0);
            }
        }

        if (maxPriorityTaskId != -1) {
            taskSet.remove(maxPriorityTaskId);
            List<Integer> task = taskMap.get(maxPriorityTaskId);
            tasks.remove(task);
            taskMap.remove(maxPriorityTaskId);
        }

        return userId;
    }
}
