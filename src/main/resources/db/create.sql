--compile group: 'com.h2database', name: 'h2', version: '1.4.191'

SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS tasks (
  id int PRIMARY KEY auto_increment,
  description VARCHAR,
  completed BOOLEAN
);