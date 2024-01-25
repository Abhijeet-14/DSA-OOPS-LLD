CREATE TABLE One_2_One_Office(
    o_id INT,
    o_name VARCHAR(50),
    o_experience INT NOT NULL,
    primary key(o_id)
);

CREATE TABLE One_2_One_Department (
    d_id INT,
    d_name VARCHAR(60),
    o_id INT UNIQUE, 
    FOREIGN KEY(o_id) REFERENCES One_2_One_Office(o_id) 
    -- this 'unique' key make it one-2-one
    -- if we miss this key, it will be one-2-MANY
);

INSERT INTO One_2_One_Office(o_id, o_name, o_experience)
VALUES
(1, 'Ali', 4),
(2, 'kobe', 3),
(3, 'Tom', 5),
(4, 'Rehy', 6);


INSERT INTO One_2_One_Department
VALUES
(1, 'CS', 1),
(2, 'RF', 2),
(3, 'XY', 3),
(4, 'ME', 4);
(5, 'FP', 1) -- this will throw error

select * from One_2_One_Office;
select * from One_2_One_Department;

select o_name, o_experience, d_name from 
One_2_One_Office as o 
JOIN 
One_2_One_Department as d 
on d.o_id = o.o_id;

