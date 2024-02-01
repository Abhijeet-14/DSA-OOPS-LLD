UPDATE your_table
SET your_column = 2
WHERE id > 2;

-- WHERE - why?
    -- Used to filter rows before they are grouped.
    -- Operates on individual rows in the original table.
SELECT column1, COUNT(*)
FROM your_table
WHERE condition
GROUP BY column1;

-- HAVING -- WHY?
    -- Used to filter the results of a grouped query.
    -- filter based on the result of grouped query.
SELECT column1, COUNT(*)
FROM your_table
GROUP BY column1
HAVING COUNT(*) > 1;
