-- What is Database?
-- A database is an organized collection of data, so that it can be easily accessed and managed.

-- What is DBMS?
-- A Data Base Management System is a system software for 
-- easy, efficient and reliable data processing and management. 

-- Need for DBMS?
-- 1. Creation of a database.
-- 2. Retrieval of information from the database.
-- 3. Updating the database.
-- 4. Managing a database.

-- DBMS vs File System
--    File System - File based systems were an early attempt to computerize the manual system.
--                  decentralized approach, create the necessary computer file structures, and also manage the data within structures
-- 
--    DBMS - A database approach is a well-organized collection of data that are related 
--          in a meaningful way which can be accessed by different users 
--          but stored only once in a system.

-- What is Database Admin & its Function?
-- Database Administrator
-- 1. Schema deﬁnition: The DBA creates the original database schema by executing a set of data deﬁnition statements in the DDL. 
-- 2. Storage structure and access-method deﬁnition.
-- 3. Schema and physical-organization modiﬁcation:
--          The DBA carries out changes to the schema 
--          and physical organization to reﬂect the changing needs of the organization, 
--          or to alter the physical organization to improve performance.
--  4. Granting of authorization for data access: 
--          By granting different types of authorization, 
--          the database administrator can regulate which parts of the database 
--          various users can access. 
--          The authorization information is kept in a special system structure that the database 
--          system consults when ever someone attempts to access the data in the system.
-- 6. Routine maintenance:
--          - Periodically backing up the database
--          - Ensuring that enough free disk space is available for normal operations
--          - upgrading disk space as required.
--          - Monitoring jobs running on the database 

-- SQL Commands
-- 1. DDL: Data Definition Language [Create, Drop, Alter, Truncate]
-- 2. DQL: Data Query Language [Select]
-- 3. DML: Data Manipulation Language [Insert, Update, Delete, Call, Explain Call, Lock]
-- 4. DCL: Data Control Language [Grant, Revoke]
-- 5. TCL: Transaction Control Language [Commit, SavePoint, RollBack, SET Transaction, Set Constraint]

-- Instance, Schema
-- Instance: snapshot of DB at particular moment
-- Schema: Overall design of table in DB.

-- DB Abstraction and its 3 level:
-- DB ABSTRACTION: hiding irrelevant from USER. Example: Student see only marks, attendance. Faculty see class time table, exam etc.
-- 3 Level:
--  1. View Level:
--      i. how the data should be shown to the user 
--  2. Conceptual Level:
--      i. dividing into tables but keeping in same DB
--     ii. how tables are inter-related
--  3. Physical Level:
--      i. where data is stored
--     ii. which data should be kept at which particular disk