// frontend-integration-example/api.js
// 既存の index.html / script.js に合わせて必要な部分だけコピーしてください。

const API_BASE_URL = "http://localhost:8080/api/tasks";

export async function fetchTasks() {
  const response = await fetch(API_BASE_URL);
  if (!response.ok) {
    throw new Error("タスク一覧の取得に失敗しました");
  }
  return await response.json();
}

export async function addTask(task) {
  const response = await fetch(API_BASE_URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(task)
  });

  if (!response.ok) {
    throw new Error("タスクの登録に失敗しました");
  }

  return await response.json();
}

export async function updateTask(id, task) {
  const response = await fetch(`${API_BASE_URL}/${id}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(task)
  });

  if (!response.ok) {
    throw new Error("タスクの更新に失敗しました");
  }

  return await response.json();
}

export async function deleteTask(id) {
  const response = await fetch(`${API_BASE_URL}/${id}`, {
    method: "DELETE"
  });

  if (!response.ok && response.status !== 204) {
    throw new Error("タスクの削除に失敗しました");
  }
}

export async function updateTaskOrder(taskIds) {
  const response = await fetch(`${API_BASE_URL}/order`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({ taskIds })
  });

  if (!response.ok) {
    throw new Error("並び順の更新に失敗しました");
  }

  return await response.json();
}
