# Stage 1: build
FROM maven:3.9.4-eclipse-temurin-17 AS builder
WORKDIR /workspace

COPY pom.xml .
RUN mvn -B -q dependency:go-offline

COPY src ./src
RUN mvn -B -q -DskipTests package

# Stage 2: runtime
FROM eclipse-temurin:17-jre-jammy
RUN useradd --create-home appuser
WORKDIR /app
COPY --from=builder /workspace/target/*.jar app.jar
EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=3s --start-period=10s --retries=3 \
  CMD curl -f http://localhost:8080/actuator/health || exit 1

USER appuser
ENTRYPOINT ["java","-jar","/app/app.jar"]
