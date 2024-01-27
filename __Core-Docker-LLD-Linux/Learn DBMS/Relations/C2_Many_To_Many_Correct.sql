CREATE TABLE students (
    student_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    gender VARCHAR(20),
    age TINYINT,
    major VARCHAR(30),
    PRIMARY KEY (student_id)
);

CREATE TABLE teachers (
    teacher_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    gender VARCHAR(20),
    age TINYINT,
    class VARCHAR(30),
    PRIMARY KEY (teacher_id)
);


-- Here we add
-- Foreign Key - add proper reference
-- on Delete Cascade - this protect us from deleting any row. 
CREATE TABLE students_teachers (
    id INT NOT NULL AUTO_INCREMENT,
    student_id INT NOT NULL,
    teacher_id INT NOT NULL,
    FOREIGN KEY (student_id)
    REFERENCES students(student_id)
    ON DELETE CASCADE,
    FOREIGN KEY (teacher_id)
    REFERENCES teachers(teacher_id)
    ON DELETE CASCADE,
    PRIMARY KEY (id)
);