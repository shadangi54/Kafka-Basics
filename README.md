# Kafka Event-Driven Microservices Demo

This project demonstrates a simple event-driven architecture using Apache Kafka and three Spring Boot microservices: **Order Service**, **Stock Service**, and **Email Service**.

---

## Prerequisites

- [Docker](https://www.docker.com/)
- [Java](https://www.java.com/)
- [Postman](https://www.postman.com/) (optional, for API testing)

---

## Quick Start (Recommended)

1. **Clone the repository** and navigate to the project directory.
2. **Run all services using Docker Compose:**
   ```sh
   docker compose -f docker/docker-compose.yml up
   ```
   This will start Kafka and all microservices.

---

## Manual Run (Using IDE)

1. **Clone the repository** and open it in your IDE.
2. **Start Kafka using Docker:**
   ```sh
   docker run -d --name kafka -p 9092:9092 apache/kafka:3.8.0
   ```
3. **Run each Spring Boot service** (`order-service`, `stock-service`, `email-service`) from your IDE.
4. **Test the API** using Postman or curl.

---

## API Example

Place an order using the following API:

```sh
curl --location 'http://localhost:8080/order/placeOrder' \
  --header 'Content-Type: application/json' \
  --data '{
    "name": "Laptop",
    "price": 10000,
    "qty": 1
  }'
```

---

## How It Works

- **Order Service** produces an event to Kafka when an order is placed.
- **Stock Service** and **Email Service** consume the event and process it.
- Check the logs of `stock-service` and `email-service` to verify message consumption.

---

## Notes

- Make sure Docker is running before starting the services.
- All services communicate via Kafka on port `9092`.
- For troubleshooting, check the logs of each service container.

---
