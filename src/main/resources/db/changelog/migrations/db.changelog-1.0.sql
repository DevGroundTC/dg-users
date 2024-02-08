--changeset ekoregin:1
CREATE TABLE IF NOT EXISTS users
(
    id BIGSERIAL PRIMARY KEY,
    nickname VARCHAR(64) NOT NULL UNIQUE,
    firstname VARCHAR(64) NOT NULL,
    lastname VARCHAR(64) NOT NULL,
    location VARCHAR(64),
    birth_place VARCHAR(64),
    birth_date TIMESTAMP,
    sex VARCHAR(16) NOT NULL,
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified TIMESTAMP,
    married_status VARCHAR(32) NOT NULL,
    education_level VARCHAR(16)
);
--rollback DROP TABLE users;

--changeset ekoregin:2
CREATE TABLE IF NOT EXISTS photo
(
    id BIGSERIAL PRIMARY KEY,
    link VARCHAR(255) NOT NULL,
    user_id BIGINT NOT NULL REFERENCES users(id)
);
--rollback DROP TABLE photo;

--changeset ekoregin:3
INSERT INTO users(nickname, firstname, lastname, location, birth_place, birth_date, sex, created, married_status, education_level)
VALUES ('ivanov', 'Ivan', 'Ivanov', 'Moscow', 'Moscow', '1990-01-10T00:00:00', 'MALE', '2024-02-08T00:00:00', 'SINGLE', 'UNIVERSITY'),
        ('petrov', 'Grigory', 'Petrov', 'Ekaterinburg', 'Ekaterinburg', '2010-05-16T00:00:00', 'MALE', '2024-02-08T00:00:00', 'SINGLE', 'SCHOOL'),
        ('sidorov', 'Semen', 'Sidorov', 'Moscow', 'Moscow', '1985-03-27T00:00:00', 'MALE', '2024-02-08T00:00:00', 'MARRIED', 'UNIVERSITY'),
        ('smirnova', 'Svetlana', 'Smirnova', 'Novgorod', 'Novgorod', '1995-12-18T00:00:00', 'FEMALE', '2024-02-08T00:00:00', 'MARRIED', 'COLLEGE'),
        ('markova', 'Elena', 'Markova', 'Sankt Petersburg', 'Pskov', '1978-06-13T00:00:00', 'FEMALE', '2024-02-08T00:00:00', 'CIVIL_PARTNERSHIP', 'UNIVERSITY'),
        ('panteleev', 'Michail', 'Panteleev', 'Vladimir', 'Sudogda', '1987-04-30T00:00:00', 'MALE', '2024-02-08T00:00:00', 'MARRIED', 'UNIVERSITY'),
        ('koroleva', 'Victoria', 'Koroleva', 'Moscow', 'Bryansk', '2004-01-10T00:00:00', 'FEMALE', '2024-02-08T00:00:00', 'SINGLE', 'COLLEGE'),
        ('amundsen', 'Raul', 'Amundsen', 'Kaliningrad', 'Oslo', '1955-10-21T00:00:00', 'MALE', '2024-02-08T00:00:00', 'SINGLE', 'UNIVERSITY'),
        ('scott', 'John', 'Scott', 'London', 'London', '1964-02-12T00:00:00', 'MALE', '2024-02-08T00:00:00', 'SINGLE', 'UNIVERSITY'),
        ('frankl', 'Viktor', 'Frankl', 'Vena', 'Frankfurt', '1973-01-10T00:00:00', 'MALE', '2024-02-08T00:00:00', 'MARRIED', 'UNIVERSITY');