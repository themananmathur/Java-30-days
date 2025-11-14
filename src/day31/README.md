$readme = @"
# Day 31 — Summary

## What
Short summary: added the Day31 feature which implements [brief description].

## How to run
1. `mvn clean package`
2. `mvn spring-boot:run` or `java -jar target/<jar>`
3. Health: `http://localhost:8080/actuator/health`
4. H2 console (if enabled): `http://localhost:8080/h2-console`

## Tests
- Run: `mvn test`

## Notes
- Seed data: `src/main/resources/data.sql`
- Main packages: `controller`, `service`, `repository`, `dto`, `config`
  "@

# write the README
$readme | Out-File -FilePath .\src\day31\README.md -Encoding UTF8

# show it
Get-Content .\src\day31\README.md

