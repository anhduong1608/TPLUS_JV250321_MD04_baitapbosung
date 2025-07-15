CREATE DATABASE IF NOT EXISTS studentdb;
USE studentdb;

CREATE TABLE students (
 id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(100),
 age INT
);


DELIMITER &&
CREATE PROCEDURE add_Students(IN p_name VARCHAR(100),In p_age INT)
BEGIN
    INSERT INTO students(name, age) VALUE (p_name, p_age);
end &&
DELIMITER ;

SELECT * FROM students;