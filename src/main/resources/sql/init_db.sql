CREATE TABLE client
(
    id   BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(128) NOT NULL
);

CREATE TABLE contact
(
    id   BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    client_id BIGINT NOT NULL,
    type varchar(10),
    contact_value varchar(256) UNIQUE,
    FOREIGN KEY (client_id) REFERENCES client(id)
);