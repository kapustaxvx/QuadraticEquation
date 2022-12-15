# QuadraticEquation
Приложение решает квадратное уровнение.

# Описание задачи
Реализовать веб приложение для вычисления корней квадратного уравнения вида ax^2 + bx + c = 0.

Описание процесса работы с программой.

Пользователь отправляет POST запрос на endpoint в формате JSON с полями: a, b, c - коэффициенты кв.уравнения.

Программа должна сохранить значения коэффициентов и рассчитанных корней уравнения в базу данных. 
Пользователю нужно вернуть значение корней уравнения в формате JSON с полями: x1, x2. 
Если найти корни уравнения нельзя, то необходимо вернуть пользователю ошибку.

# Требования к реализации

При разработке приложения необходимо использовать Spring, Maven, Java >8. Для работы с БД можно использовать любую ORM. 
Для сборки проекта нужно использовать Maven. Результаты нужно выложить на GitHub. 
Моменты, которые в задании явно не оговорены, можно реализовывать в соответствии с общепринятыми практиками. 

# Запуск

- Склонировать репозиторий и открыть проект
- Обновить все Maven dependencies
- Собрать проект с помощью Maven и запустить 
- Перед запуском можно запустить Unit тесты

# Тестирование API

- После запуска можно войти на http://localhost:8000/swagger-ui/ для просмотра доступных endpoint
  ![alt text](screenshots/swaggerscreen.png) 
- Для вычисления результата необходимо отправить POST запрос на адрес
  localhost:8000/api/calculate
  ![alt text](screenshots/postmancalculate.png) 
- Для отображения всех успешных запросов и ответов необходимо отправить GET запрос на адрес
  localhost:8000/api/all
  ![alt text](screenshots/postmanall.png) 



DOCKER

Собрать Dockerfile 
     
    docker build -t quadratic-app:1 . 

Создать кастомную сеть

    docker network create back_net

Создать volume

    docker volume create db_vol

Запустить Postgres

    docker run --rm -d \
    --name database \
    --net=back_net \
    -v db_vol:/var/lib/postgresql/data \
    -e POSTGRES_PASSWORD=admin \
    -e POSTGRES_USER=admin \
    -e POSTGRES_DB=test_db \
    postgres:14

Запустить 3 контейнера с приложением с названиями backend_1, backend_2 и backend_3

    docker run --rm -d \
    --name backend_3 \
    --net=back_net \
    -e PS_HOST=database \
    -e PS_DB=test_db \
    -e PS_USER=admin \
    -e PS_PASSWORD=admin \
    quadratic-app:1

Запустить балансировщик нагрузки nginx

    docker run --rm -d \
    --name nginx \
    --net=back_net \
    -p 80:80 \
    -v $(pwd)/nginx.conf:/etc/nginx/conf.d/default.conf \
    nginx


Можно пользоваться API без указания порта

    curl localhost/api/all

