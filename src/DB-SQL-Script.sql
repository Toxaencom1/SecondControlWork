/*
 8. Создать таблицы с иерархией из диаграммы в БД
 9. Заполнить низкоуровневые таблицы именами(животных), командами
   которые они выполняют и датами рождения
 */

DROP DATABASE IF EXISTS human_friends;
CREATE DATABASE human_friends;
USE human_friends;


DROP TABLE IF EXISTS animal_type;
CREATE TABLE animal_type (	
	type_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,	
    animal_type TEXT    
);


INSERT INTO `animal_type` (`animal_type`) VALUES
	('pet'),
	('pack_animal');

DROP TABLE IF EXISTS dogs;
CREATE TABLE dogs (	
	species_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	species_name VARCHAR(50),
    animal_type INT UNSIGNED,
	name VARCHAR(50),
    birthday DATE,
    commands TEXT, 
    FOREIGN KEY (animal_type) REFERENCES animal_type (type_id)
);

INSERT INTO `dogs` (`species_name`,`animal_type`, `name`, `birthday`, `commands`) values
('dog', 1, 'Ressi', '2020-11-08', 'stroll|hold'),
('dog', 1, 'Rex', '2021-10-08', 'stroll|hold');

DROP TABLE IF EXISTS cats;
CREATE TABLE cats (	
	species_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	species_name VARCHAR(50),
    animal_type INT UNSIGNED,
	name VARCHAR(50),
    birthday DATE,
    commands TEXT, 
    FOREIGN KEY (animal_type) REFERENCES animal_type (type_id)
);

INSERT INTO `cats` (`species_name`,`animal_type`, `name`, `birthday`, `commands`) values
('cat', 1, 'Vasil', '2021-11-01', 'stroll|hold'),
('cat', 1, 'Luna', '2021-10-01', 'stroll|hold');

DROP TABLE IF EXISTS hamsters;
CREATE TABLE hamsters (	
	species_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	species_name VARCHAR(50),
    animal_type INT UNSIGNED,
	name VARCHAR(50),
    birthday DATE,
    commands TEXT, 
    FOREIGN KEY (animal_type) REFERENCES animal_type (type_id)
);

INSERT INTO `hamsters` (`species_name`,`animal_type`, `name`, `birthday`, `commands`) values
( 'hamster', 1, 'Frog', '2022-06-01', 'stroll|hold'),
( 'hamster', 1, 'Varyag', '2022-08-01', 'stroll|hold');

DROP TABLE IF EXISTS horses;
CREATE TABLE horses (	
	species_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	species_name VARCHAR(50),
    animal_type INT UNSIGNED,
	name VARCHAR(50),
    birthday DATE,
    commands TEXT, 
    FOREIGN KEY (animal_type) REFERENCES animal_type (type_id)
);

INSERT INTO `horses` (`species_name`,`animal_type`, `name`, `birthday`, `commands`) values
('horse', 2, 'Ginger', '2023-02-01', 'forward|hold'),
('horse', 2, 'Thunder', '2023-03-01', 'forward|hold');

DROP TABLE IF EXISTS camels;
CREATE TABLE camels (	
	species_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	species_name VARCHAR(50),
    animal_type INT UNSIGNED,
	name VARCHAR(50),
    birthday DATE,
    commands TEXT, 
    FOREIGN KEY (animal_type) REFERENCES animal_type (type_id)
);

INSERT INTO `camels` (`species_name`,`animal_type`, `name`, `birthday`, `commands`) values
('camel', 2, 'Sahara', '2017-01-01', 'forward|hold'),
('camel', 2, 'Caspian', '2017-06-01', 'forward|hold');

DROP TABLE IF EXISTS donkeys;
CREATE TABLE donkeys (	
	species_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	species_name VARCHAR(50),
    animal_type INT UNSIGNED,
	name VARCHAR(50),
    birthday DATE,
    commands TEXT, 
    FOREIGN KEY (animal_type) REFERENCES animal_type (type_id)
);

INSERT INTO `donkeys` (`species_name`,`animal_type`, `name`, `birthday`, `commands`) values
('donkey', 2, 'Eeyore', '2018-03-01', 'forward|hold'),
('donkey', 2, 'Daisy', '2018-09-01', 'forward|hold');

DROP TABLE IF EXISTS animals;
CREATE TABLE animals (	
	animal_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,	
    species_name VARCHAR(50),
	species_id BIGINT UNSIGNED NOT NULL,
    animal_type INT UNSIGNED,
	name VARCHAR(50),
    birthday DATE,
    commands TEXT,
    FOREIGN KEY (animal_type) REFERENCES animal_type (type_id)
);

/*
 12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
    прошлую принадлежность к старым таблицам.
 */

INSERT INTO animals (species_name, species_id, animal_type, name, birthday, commands)
SELECT species_name, species_id, animal_type, name, birthday, commands
FROM dogs
UNION
SELECT species_name, species_id, animal_type, name, birthday, commands
FROM cats
UNION
SELECT species_name, species_id, animal_type, name, birthday, commands
FROM hamsters
UNION
SELECT species_name, species_id, animal_type, name, birthday, commands
FROM horses
UNION
SELECT species_name, species_id, animal_type, name, birthday, commands
FROM camels
UNION
SELECT species_name, species_id, animal_type, name, birthday, commands
FROM donkeys;

SELECT * FROM animals a ;

DELIMITER //
CREATE TRIGGER after_dogs_insert
AFTER INSERT ON dogs
FOR EACH ROW
BEGIN
  INSERT INTO animals (species_name, species_id, animal_type, name, birthday, commands)
  VALUES (NEW.species_name, NEW.species_id, NEW.animal_type, NEW.name, NEW.birthday, NEW.commands);
END;
//
DELIMITER //
CREATE TRIGGER after_cats_insert
AFTER INSERT ON cats
FOR EACH ROW
BEGIN
  INSERT INTO animals (species_name, species_id, animal_type, name, birthday, commands)
  VALUES (NEW.species_name, NEW.species_id, NEW.animal_type, NEW.name, NEW.birthday, NEW.commands);
END;
//

DELIMITER //
CREATE TRIGGER after_hamsters_insert
AFTER INSERT ON hamsters
FOR EACH ROW
BEGIN
  INSERT INTO animals (species_name, species_id, animal_type, name, birthday, commands)
  VALUES (NEW.species_name, NEW.species_id, NEW.animal_type, NEW.name, NEW.birthday, NEW.commands);
END;
//
DELIMITER //
CREATE TRIGGER after_horses_insert
AFTER INSERT ON horses
FOR EACH ROW
BEGIN
  INSERT INTO animals (species_name, species_id, animal_type, name, birthday, commands)
  VALUES (NEW.species_name, NEW.species_id, NEW.animal_type, NEW.name, NEW.birthday, NEW.commands);
END;
//

DELIMITER //
CREATE TRIGGER after_camels_insert
AFTER INSERT ON camels
FOR EACH ROW
BEGIN
  INSERT INTO animals (species_name, species_id, animal_type, name, birthday, commands)
  VALUES (NEW.species_name, NEW.species_id, NEW.animal_type, NEW.name, NEW.birthday, NEW.commands);
END;
//

DELIMITER //
CREATE TRIGGER after_donkeys_insert
AFTER INSERT ON donkeys
FOR EACH ROW
BEGIN
  INSERT INTO animals (species_name, species_id, animal_type, name, birthday, commands)
  VALUES (NEW.species_name, NEW.species_id, NEW.animal_type, NEW.name, NEW.birthday, NEW.commands);
END;
//
DELIMITER ;

INSERT INTO `dogs` (`species_name`,`animal_type`, `name`, `birthday`, `commands`) values
('dog', 1, 'Hachiko', '2020-11-06', 'stroll|hold');

INSERT INTO `donkeys` (`species_name`,`animal_type`, `name`, `birthday`, `commands`) values
('donkey', 2, 'Ia', '2016-07-01', 'forward|hold');


/*
 10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
 питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
 */
DELETE FROM animals
WHERE species_name = 'camel';

SELECT * FROM animals a ;

DROP VIEW IF EXISTS only_horses_and_donkeys;
CREATE VIEW only_horses_and_donkeys AS 
	SELECT  at2.animal_type, a.species_name, a.species_id, a.name, a.birthday, a.commands
		FROM animals a
		JOIN animal_type at2 ON a.animal_type  = at2.type_id 
		WHERE species_name = 'horse' OR species_name = 'donkey';

SELECT *
	FROM only_horses_and_donkeys;


/*
 11. Создать новую таблицу “молодые животные” в которую попадут все
    животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
    до месяца подсчитать возраст животных в новой таблице
 */
DROP VIEW IF EXISTS young_animals;
CREATE VIEW young_animals AS 
	SELECT a.*, TIMESTAMPDIFF(MONTH, birthday, NOW()) AS age_in_months
		FROM animals a 
		WHERE TIMESTAMPDIFF(MONTH, birthday, NOW()) < 37 AND TIMESTAMPDIFF(MONTH, birthday, NOW()) > 11;
			

SELECT *
	FROM young_animals;















