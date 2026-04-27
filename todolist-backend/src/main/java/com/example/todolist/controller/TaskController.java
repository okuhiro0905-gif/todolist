package com.example.todolist.controller;

import com.example.todolist.dto.TaskOrderRequest;
import com.example.todolist.dto.TaskRequest;
import com.example.todolist.entity.Task;
import com.example.todolist.repository.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * タスク一覧取得
     * GET /api/tasks
     */
    @GetMapping
    public List<Task> getTasks() {
        return taskRepository.findAllByOrderBySortOrderAscIdAsc();
    }

    /**
     * タスク新規登録
     * POST /api/tasks
     */
    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody TaskRequest request) {
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setCategory(request.getCategory());
        task.setCompleted(request.getCompleted() != null ? request.getCompleted() : false);
        task.setSortOrder(request.getSortOrder() != null ? request.getSortOrder() : 0);

        Task savedTask = taskRepository.save(task);
        return ResponseEntity.ok(savedTask);
    }

    /**
     * タスク更新
     * PUT /api/tasks/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(
            @PathVariable Long id,
            @Valid @RequestBody TaskRequest request
    ) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(request.getTitle());
                    task.setCategory(request.getCategory());
                    task.setCompleted(request.getCompleted() != null ? request.getCompleted() : false);
                    task.setSortOrder(request.getSortOrder() != null ? request.getSortOrder() : task.getSortOrder());

                    Task updatedTask = taskRepository.save(task);
                    return ResponseEntity.ok(updatedTask);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * タスク削除
     * DELETE /api/tasks/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        if (!taskRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        taskRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * タスク並び順更新
     * PUT /api/tasks/order
     *
     * Request body example:
     * {
     *   "taskIds": [3, 1, 2]
     * }
     */
    @PutMapping("/order")
    public ResponseEntity<Map<String, String>> updateTaskOrder(
            @Valid @RequestBody TaskOrderRequest request
    ) {
        List<Long> taskIds = request.getTaskIds();

        for (int i = 0; i < taskIds.size(); i++) {
            Long taskId = taskIds.get(i);
            int sortOrder = i + 1;

            taskRepository.findById(taskId).ifPresent(task -> {
                task.setSortOrder(sortOrder);
                taskRepository.save(task);
            });
        }

        return ResponseEntity.ok(Map.of("message", "task order updated"));
    }
}
