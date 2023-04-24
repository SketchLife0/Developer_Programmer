USE `geekbrains(lesson3)`;
SELECT city, sname, snum, comm FROM salespeople;

SELECT rating, cname
FROM customers
WHERE city = "San Jose";

SELECT DISTINCT snum FROM orders;

SELECT cname 
FROM customers 
WHERE cname LIKE 'G%';

SELECT *
FROM orders
WHERE amt > 1000;

SELECT MIN(amt) FROM orders;

SELECT *
FROM customers
WHERE rating > 100 AND NOT city = "Rome";

SELECT salary FROM staff ORDER BY salary DESC;

SELECT salary FROM staff ORDER BY salary ASC;

SELECT specialty, SUM(salary) AS total_salary 
FROM staff 
GROUP BY specialty 
HAVING total_salary > 100000;
