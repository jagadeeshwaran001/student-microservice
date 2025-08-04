# student-microservice
### docker-compose.yml
``` yml
services:
  postgres:
    image: postgres:latest
    container_name: postgres
    ports:
      - "5435:5432"
    environment:
      POSTGRES_USER: jaga
      POSTGRES_PASSWORD: 123456
      POSTGRES_DB: demo
    volumes:
      - postgres_data:/var/lib/postgresql/data

volumes:
  postgres_data:

```
