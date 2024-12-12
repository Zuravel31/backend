INSERT INTO clients (name)
VALUES ( 'Client A'),
       ( 'Client B'),
       ( 'Client C'),
       ( 'Client D'),
       ( 'Client E');

-- Вставка данных в таблицу contacts
INSERT INTO contacts (clients_id, type, contact_value)
VALUES (1, 'email', 'clientA@example.com'),
       (2, 'phone', '123-456-7890'),
       (3, 'email', 'clientC@example.com'),
       (4, 'phone', '987-654-3210'),
       (5, 'email', 'clientE@example.com');