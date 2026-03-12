CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
    );

INSERT INTO users (name, email, password)
VALUES
    (
        'manoj',
        'manojmengani2@gmail.com',
        '$2a$12$P1fpK/CXWSJarAhG7Smvo.zCvimTP5mPD.YlQI5MlC1irY7MqcciG'
    );