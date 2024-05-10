-- CREATE
CREATE TABLE student (
    id INT PRIMARY KEY;
    f_name VARCHAR(20) NOT NULL;
    l_name VARCHAR(20);
);

-- CREATE One-2-One
CREATE TABLE student (
    id INT PRIMARY KEY,
    d_name VARCHAR(60),
    class_id INT UNIQUE, 
    FOREIGN KEY(class_id) REFERENCES One_2_One_Office(o_id)
)


-- CREATE One-2-Many
CREATE TABLE student (
    id INT PRIMARY KEY,
    d_name VARCHAR(60),
    class_id INT, -- removed UNIQUE, and it will work
    FOREIGN KEY(class_id) REFERENCES One_2_One_Office(o_id)
)

-- CREATE Many-2-Many - START
CREATE TABLE student (
    id INT PRIMARY KEY;
    name VARCHAR(20) NOT NULL;
)

CREATE TABLE teacher (
    id INT PRIMARY KEY;
    name VARCHAR(20) NOT NULL;
    course VARCHAR(20) NOT NULL;
)

CREATE TABLE students_teachers (
    id INT PRIMARY KEY;
    student_id INT NOT NULL;
    teacher_id INT NOT NULL;
    FOREIGN KEY (student_id) REFERENCES student(id)
    FOREIGN KEY (teacher_id) REFERENCES teacher(id)
)
-- END


-- INSERT
INSERT INTO student(id, name) VALUES(1, "CYZ");

-- ADD COLUMN
ALTER TABLE student ADD email_address VARCHAR(20);

-- ALTER COLUMN
ALTER TABLE student ALTER COLUMN email_address VARCHAR(45);

-- GET all rows
SELECT * FROM student;

-- ALL key word
SELECT * FROM student where task_no > ALL( SELECT tasks FROM student where age = 26);

-- AND
SELECT * FROM student where age > 25 AND marks < 60;

-- AS
SELECT months as M FROM student where M>10;

-- ASC
SELECT * FROM student ORDER BY country ASC

-- DESC
SELECT * FROM student ORDER BY country DESC

-- ORDER BY - MULTIPLE COLUMN -> if country colision, then orderby states
SELECT * FROM student ORDER BY country, states

-- BETWEEN
SELECT * FROM student WHERE marks BETWEEN 80 AND 90;

-- NOT BETWEEN
SELECT * FROM student WHERE marks NOT BETWEEN 80 AND 90;

-- CHECK
CREATE TABLE users(
    f_name VARCHAR(20);
    age INT;
    CHECK (age > 18);
)

-- CREATE DB
CREATE DATABASE new_db;

--  DEFAULT
CREATE TABLE users(
    f_name VARCHAR(20) DEFAULT "Robin";
)

-- DELETE
DELETE FROM student WHERE marks < 33;

-- DROP COLUMN
ALTER TABLE student DROP COLUMN likes;9



-- UPDATE
UPDATE your_table SET your_column = 2 WHERE id > 2;

-- WHERE - why?
-- Used to filter rows before they are grouped.
-- Operates on individual rows in the original table.
SELECT
    column1,
    COUNT(*)
FROM
    your_table
WHERE
    condition
GROUP BY
    column1;

-- HAVING -- WHY?
-- Used to filter after they have grouped query.
-- filter based on the result of grouped query.
SELECT
    column1,
    COUNT(*)
FROM
    your_table
GROUP BY
    column1
HAVING
    COUNT(*) > 1;