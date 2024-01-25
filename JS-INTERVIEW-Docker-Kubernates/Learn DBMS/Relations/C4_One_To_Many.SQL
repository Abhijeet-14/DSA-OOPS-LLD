CREATE TABLE one_2_Many_father(
    f_id INT,
    f_name varchar(50),
    PRIMARY KEY(f_id)
);

CREATE TABLE one_2_Many_kid (
    k_id INT,
    k_name VARCHAR(50),
    f_id INT, -- UNIQUE,  this will make it 1-to-1 relationship
    PRIMARY KEY(k_id),
    FOREIGN KEY(f_id)
    REFERENCES one_2_Many_father(f_id)
);


INSERT INTO one_2_Many_father
VALUES
(1, 'Ali'),
(2, 'Kobe'),
(3, 'Shaq'),
(4, 'Jord');

INSERT INTO one_2_Many_kid(k_id, k_name, f_id)
VALUES
(1, 'Smith', 3),
(2, 'John', 4),
(3, 'Rutg', 1),
(4, 'Cjok', 3),
(5, 'Mic', 4),
(6, 'Jop',3);

select * from one_2_Many_father;
select * from one_2_Many_kid;


select count(*) from 
one_2_Many_father as f
JOIN 
one_2_Many_kid as k
on f.f_id = k.f_id
where f.f_id=4;