-- This file creates some DB tables as an example.
CREATE TABLE cats
(
  id    int PRIMARY KEY AUTO_INCREMENT,
  name  varchar(32) NOT NULL,
  color varchar(32) NOT NULL,
  owner int
);
CREATE TABLE owners
(
  id   int PRIMARY KEY AUTO_INCREMENT,
  name varchar(32)
);
ALTER TABLE cats
  ADD CONSTRAINT cats_owners_id_fk
FOREIGN KEY (owner) REFERENCES owners (id)
  ON DELETE SET NULL
  ON UPDATE CASCADE;

INSERT INTO owners (name) VALUES ('Dries007');
INSERT INTO cats (name, color, owner) VALUES ('John Snow', 'White', 1);

