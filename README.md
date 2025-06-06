#  Microservice-Based  System


## 🚀 Technologies Used

| Area                | Technology                            |
|---------------------|----------------------------------------|
| Backend Framework   | Spring Boot                            |
| Authentication      | Spring Security, JWT                   |
| Database            | PostgreSQL, In-memory DB (H2)          |
| Microservice Comm.  | gRPC                                   |
| Event Streaming     | Apache Kafka                           |
| Containerization    | Docker                                 |
| API Management      | Spring Cloud Gateway                   |
| Documentation       | OpenAPI (Swagger)                      |
| Build Tool          | Maven                                  |

---

## 🧱 Architecture Overview

The system consists of the following microservices:

- **Patient Service**
  - Handles patient creation, update, deletion
  - Calls Billing Service via gRPC
  - Sends Kafka events for analytics
- **Billing Service**
  - Acts as a gRPC server
  - Handles billing logic triggered by patient events
- **Analytics Service**
  - Consumes Kafka events
  - Processes and stores analytical data
- **Auth Service**
  - Manages login and JWT token generation/validation
- **API Gateway**
  - Single entry point to all services
  - Includes authentication filters

---

## 🔁 Service Communication

```plaintext
[Client] → [API Gateway] → [Auth / Patient Service]
                                 ↓
                            [Billing Service] ← gRPC
                                 ↓
                            [Kafka Broker] → [Analytics Service]
