# 🐾 petstore-api-demo
A demo Spring Boot API implementing a simple Pet Store with support for API versioning, CRUD operations, and Swagger documentation. This project is inspired by the [Swagger Petstore API example](https://petstore.swagger.io/), and follows a similar structure for educational and testing purposes.
The application supports two operational modes — **Remote** and **Local** — which determine how it handles data sources.

---

# 🎯 Purpose
This project is designed for testing purposes and serves as a reference implementation for anyone looking to try out or experiment with building and testing RESTful APIs using Spring Boot.

---

## 🚀 Features

- **Two Operational Modes**:
  - **Remote Mode**: The API delegates pet-related operations to an **external API**.
  - **Local Mode**: The API interacts directly with an **embedded H2 database**.
- **RESTful API** for managing pets (`GET`, `POST`, `PUT`, `DELETE`)
- **Spring Data JPA** with H2 in-memory database
- **OpenAPI/Swagger UI** support via SpringDoc
- **Profile-based configuration**
- **Custom health check endpoint**
---

## 🔧 Prerequisites

- Java 17+
- Gradle
- IDE (e.g., IntelliJ, Eclipse) or command-line

---

## ⚙️ Setup & Build

```bash
# Clone the repo
git clone https://github.com/BathiyaL/petstore-api-demo.git
cd petstore-api-demo

# Build the project
./gradlew clean build
```

---

## ▶️ Run the Application

```bash
./gradlew bootRun
```

The API will be available at `http://localhost:8080/api/v1/pets`.

✔️ Swagger UI: `http://localhost:8080/api/v1/swagger-ui/index.html`  
📄 OpenAPI Spec: `http://localhost:8080/api/v1/api-docs`  
🩺 Custom Health Check: `http://localhost:8080/api/v1/health`

---

## 🤝 Contributing

Contributions, ideas, and enhancements are welcome! Please open a pull request or issue to discuss your suggestions.

---
