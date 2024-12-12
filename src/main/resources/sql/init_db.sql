CREATE TABLE clients
(
    id   BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(128) NOT NULL
);

CREATE TABLE contacts
(
    id   BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    clients_id BIGINT NOT NULL,
    type varchar(10),
    contact_value varchar(256) UNIQUE,
    FOREIGN KEY (clients_id) REFERENCES clients(id)
);
