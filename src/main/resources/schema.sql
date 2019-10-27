CREATE TABLE users
(
    id       BIGINT       NOT NULL AUTO_INCREMENT,
    name     VARCHAR(255) NOT NULL,
    surname  VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE topics
(
    id        BIGINT       NOT NULL AUTO_INCREMENT,
    author_id BIGINT,
    title     VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (author_id) REFERENCES users (Id)
)