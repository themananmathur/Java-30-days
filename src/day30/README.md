# Day 30 — Dockerize Spring Boot app

Build jar:
mvn -B clean package -DskipTests

Build Docker image:
docker build -t day30-app:latest .

Run:
docker run --rm -p 8080:8080 day30-app:latest

Or with compose:
docker compose up --build

Endpoints:
GET /            -> simple text
GET /api/hello   -> api sample
GET /actuator/health -> health (actuator)
