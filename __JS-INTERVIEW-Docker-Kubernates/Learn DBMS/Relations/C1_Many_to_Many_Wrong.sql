CREATE TABLE students (
    student_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    gender VARCHAR(20),
    age TINYINT,
    major VARCHAR(30),
    PRIMARY KEY (student_id)
);

INSERT INTO students (student_id, name, gender, age, major)
VALUES
(1, "Alex", "Male", 15, "Computer Science"),
(2, "Caroline", "Female", 34, "Liberal Arts"),
(3, "Mary", "Female", 19, "Nutrition"),
(4, "Jay", "Male", 20, "Electrical Engineering"),
(5, "Moe", "Male", 24, "Underwater Welding"),
(6, "Curtis", "Male", 18, "Psychology"),
(7, "Judy", "Female", 44, "Computer Science"),
(8, "Alex", "None ya bizness", 22, "Liberal Arts"),
(9, "Lucy", "Female", 23, "Liberal Arts"),
(10, "Chris", "Male", 56, "Nutrition"),
(11, "Faith", "Female", 18, "Electrical Engineering"),
(12, "Giovanni", "Male", 30, "Music"),
(13, "John", "Male", 40, "Music"),
(14, "Allison", "Female", 20, "Performing Arts"),
(15, "Kate", "Female", 22, "Nutrition"),
(16, "Mary", "None ya bizness", 26, "Nutrition"),
(17, "Thomas", "Male", 21, "Computer Science"),
(18, "Owen", "Male", 26, "Structural Engineering"),
(19, "Sreehari", "Male", 38, "Nutrition"),
(20, "Zena", "Female", 25, "Underwater Welding"),
(21, "Jason", "Male", 39, "Writing"),
(22, "Edwina", "Female", 29, "Archaeology")

CREATE TABLE teachers (
    teacher_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    gender VARCHAR(20),
    age TINYINT,
    class VARCHAR(30),
    PRIMARY KEY (teacher_id)
);

INSERT INTO teachers (teacher_id, name, gender, age, class)
VALUES
(1, "Mrs. Troper", "Female", 43, "Assembly Language"),
(2, "Mr. Smith", "Male", 29, "Painting101"),
(3, "Mr. Edwards", "Male", 47, "Calulus II"),
(4, "Mrs. Roosevelt", "Female", 51, "Music Theory"),
(5, "Mrs. Rogers", "Female", 51, "Chemistry 201"),
(6, "Mrs. Falor", "Female", 51, "Welding"),
(7, "Mr. Bell", "Male", 51, "Play Writing"),
(8, "Mrs. Hawking", "Female", 51, "Physics 101")


-- MANY To MANY Mapping -- 
CREATE TABLE students_teachers (
    student_id INT NOT NULL,
    teacher_id INT NOT NULL
);

INSERT INTO students_teachers ( student_id, teacher_id)
VALUES
(1, 1),
(1, 3),
(2, 5),
(2, 4),
(18, 3),
(3, 6),
(1, 2),
(5, 5),
(5, 4),
(4, 8),
(7, 8),
(8, 8),
(4, 7),
(6, 2),
(9, 3),
(9, 7),
(10, 2),
(9, 4),
(19, 4),
(5, 2),
(11, 3),
(12, 4),
(9, 2),
(14, 2),
(19, 6),
(13, 1),
(9, 8),
(16, 5),
(13, 7),
(19, 2),
(14, 6),
(16, 3),
(18, 1),
(15, 1),
(17, 4),
(16, 7),
(17, 8),
(18, 5),
(18, 7),
(19, 8)



-- QUERY --
SELECT name, students.student_id, teacher_id
FROM students
INNER JOIN students_teachers
ON students.student_id = students_teachers.student_id
ORDER BY students_teachers.student_id
LIMIT 10;

-- Also joining teachers
SELECT students.name, students.student_id, teachers.teacher_id, teachers.name, class
FROM students
INNER JOIN students_teachers
ON students.student_id = students_teachers.student_id
INNER JOIN teachers
ON students_teachers.teacher_id = teachers.teacher_id
ORDER BY students.student_id
LIMIT 11;

-- Let’s grab all the students in the class ‘Welding’.
SELECT students.name, class, teachers.name
FROM students
INNER JOIN students_teachers
ON students.student_id = students_teachers.student_id
INNER JOIN teachers
ON students_teachers.teacher_id = teachers.teacher_id
WHERE teachers.class = 'Welding';


-- Let’s try something a little more challenging: 
-- Get all the classes the students are taking for those who have some sort of “engineering” 
-- or “Computer science” Major. 
-- There’s two or three different kinds of “engineering” in the database, 
-- and “Computer Science”, so we’ll need to check for both of those. 
-- Get the students name, major, class, and teacher’s name.
SELECT students.name, students.major, teachers.class, teachers.name
FROM students
INNER JOIN students_teachers
ON students.student_id = students_teachers.student_id
INNER JOIN teachers
ON students_teachers.teacher_id = teachers.teacher_id
WHERE students.major LIKE '%engineer%' OR students.major LIKE '%Computer%';