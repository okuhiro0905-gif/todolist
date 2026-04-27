# TodoList Backend

Spring Boot を使用した TodoList アプリのバックエンド API です。  
フロントエンドから REST API を呼び出し、タスク情報を DB に保存する構成を想定しています。

## 技術構成

- Java 17
- Spring Boot 3.2.5
- Spring Web
- Spring Data JPA
- MySQL
- Maven

## 主な機能

| 機能 | HTTP Method | URL |
|---|---|---|
| タスク一覧取得 | GET | `/api/tasks` |
| タスク新規登録 | POST | `/api/tasks` |
| タスク更新 | PUT | `/api/tasks/{id}` |
| タスク削除 | DELETE | `/api/tasks/{id}` |
| 並び順更新 | PUT | `/api/tasks/order` |

## セットアップ手順

### 1. MySQL に DB を作成

MySQL にログインして、以下を実行します。

```sql
CREATE DATABASE todolist_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

または `docs/schema.sql` を実行してください。

### 2. DB 接続情報を設定

`src/main/resources/application.properties` を自分の MySQL 環境に合わせて変更します。

```properties
spring.datasource.username=root
spring.datasource.password=password
```

### 3. 起動

```bash
mvn spring-boot:run
```

起動後、以下で API にアクセスできます。

```text
http://localhost:8080/api/tasks
```

## API 使用例

### タスク一覧取得

```http
GET http://localhost:8080/api/tasks
```

### タスク新規登録

```http
POST http://localhost:8080/api/tasks
Content-Type: application/json

{
  "title": "Javaの復習をする",
  "category": "study",
  "completed": false,
  "sortOrder": 1
}
```

### タスク更新

```http
PUT http://localhost:8080/api/tasks/1
Content-Type: application/json

{
  "title": "Spring Boot APIを作成する",
  "category": "study",
  "completed": true,
  "sortOrder": 1
}
```

### タスク削除

```http
DELETE http://localhost:8080/api/tasks/1
```

## フロントエンドから呼び出す例

```javascript
async function loadTasks() {
  const response = await fetch("http://localhost:8080/api/tasks");
  const tasks = await response.json();
  console.log(tasks);
}
```

```javascript
async function createTask(title) {
  const response = await fetch("http://localhost:8080/api/tasks", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      title: title,
      category: "general",
      completed: false,
      sortOrder: 1
    })
  });

  return await response.json();
}
```

## 面接での説明例

> 個人学習として、TodoList の PWA アプリを作成しました。  
> 最初は localStorage に保存する純フロントエンド構成でしたが、より実務に近づけるため、Spring Boot で REST API を作成し、タスク情報を MySQL に保存できるようにしました。  
> フロントエンドから fetch で API を呼び出し、タスクの登録・更新・削除・並び替えを行う構成にしています。

## 今後の改善案

- ログイン機能追加
- JWT 認証追加
- カテゴリ管理 API 追加
- 例外処理の共通化
- Docker 対応
- AWS へのデプロイ
