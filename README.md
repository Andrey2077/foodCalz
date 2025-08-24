foodCalz — бэкенд-сервис учёта питания и калорий «как FatSecret»: 
 - поиск продуктов и блюд, 
 - добавление порций в дневник
 - подсчёт КБЖУ по дню/неделе/месяцу
 - цели (калории/макросы)
 - рецепты, избранное.


Postgres — основной персист;
Liquibase — миграции;
MapStruct — маппинг сущность↔️DTO;
Swagger (springdoc) — интерактивная API-документация.

Архитектура (монолит с асинхронными задачами):

 • Spring Boot 3 (MVC + Security + Validation)

 • Spring Data JPA (Hibernate) + Postgres

 • Liquibase: версионирование схемы.

 • MapStruct: DTO ↔️ Entity.

 • springdoc-openapi-starter-webmvc-ui: Swagger UI.

