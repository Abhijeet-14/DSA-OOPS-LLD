-- -- Custom Data Type -- --
-- CREATE TYPE <name_of_your_type> FROM <base_type> <nullability>

-- Example:
CREATE TYPE Spagetti FROM DECIMAL(5,2) NOT NULL
CREATE TYPE NameType FROM VARCHAR(20) NULL

-- USE
CREATE TABLE example (
    price Spagetti,
    FirstName NameType
)

-- Drop Type
DROP TYPE NameType

-- -- Custom Domain -- --
CREATE DOMAIN candidate_name AS 
VARCHAR NOT NULL CHECK (value !~ '\s');

-- use
CREATE TABLE candidate_data (
    last_name candidate_name,
)


-- EMAIL TYPE:
CREATE DOMAIN 
CUSTOM_EMAIL_TYPE AS VARCHAR 
NOT NULL 
CHECK(
   VALUE ~ '^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$'
)

-- ALTER table COLUMN
ALTER TABLE public."author"
ALTER COLUMN "author_email" TYPE custom_email_type

-- NOW TYPE:
CREATE DOMAIN 
CUSTOM_INDIA_NOW AS TIMESTAMPTZ 
DEFAULT Now();