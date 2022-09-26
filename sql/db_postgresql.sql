CREATE TABLE employees (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  surname VARCHAR(45) NOT NULL,
  phone VARCHAR(45) NULL,
  email VARCHAR(45) NULL,
  salary DECIMAL(7,2) NULL,
  PRIMARY KEY (id)
)

INSERT INTO employees VALUES (1, 'Aleksey', 'Turkov', '+375291234567', 'alextur@cnet.com', 800.00);
INSERT INTO employees VALUES (2, 'Ivan', 'Usovich', '+375295896587', 'ivanu@cnet.com', 999.00);
INSERT INTO employees VALUES (3, 'Oleg', 'Starostin', '+375125896875', 'olegst@cnet.com', 640.00);
INSERT INTO employees VALUES (4, 'Maksim', 'Sokolov', '+375293658958', 'maskims@cnet.com', 302.00);
INSERT INTO employees VALUES (5, 'Bogdan', 'Timofeev', '+375291598758', 'bogdant@cnet.com', 1250.00);
INSERT INTO employees VALUES (6, 'Timur', 'Popov', '+375291112233', 'timurp@cnet.com', 2569.00);
INSERT INTO employees VALUES (7, 'Elena', 'Kashtanova', '+375293698521', 'elenak@cnet.com', 111.00);
INSERT INTO employees VALUES (8, 'Olga', 'Ivanova', '+375292859741', 'olgai@cnet.com', 789.00);
INSERT INTO employees VALUES (9, 'Irina', 'Simonova', '+3752598745897', 'irinas@cnet.com', 1020.00);
INSERT INTO employees VALUES (10, 'Aleksey', 'Menchuk', '+375291023699', 'alekseym@cnet.com', 555.00);
