USE `geekbrains(lesson4)`;

SELECT * FROM auto;

CREATE VIEW lesson5 AS
SELECT *
FROM auto
WHERE COST > 25000;

SELECT * FROM lesson5;

ALTER VIEW lesson5 AS
SELECT mark, color, cost
FROM auto
WHERE cost > 30000;

SELECT * FROM lesson5;

CREATE VIEW `lesson5.1` AS
SELECT mark, color, cost
FROM auto
WHERE mark = "AUDI" OR mark = "VOLVO";

SELECT * FROM `lesson5.1`;

USE `geekbrains(lesson5)`;
SELECT * FROM analysis;
SELECT * FROM `groups`;
SELECT * FROM orders;

SELECT an_name, an_price
FROM analysis JOIN orders 
ON an_id = ord_an
WHERE ord_datetime >= '2020-02-05 00:00:00' AND ord_datetime <= '2020-02-12 23:59:59';

ALTER TABLE trains 
ADD COLUMN time_to_next_station TIME;

UPDATE trains AS t1
JOIN (
    SELECT train_id, station, station_time,
        TIMEDIFF(
            LEAD(station_time) OVER (PARTITION BY train_id ORDER BY station_time), station_time
        ) AS diff
    FROM trains
) AS t2 ON t1.train_id = t2.train_id AND t1.station = t2.station
SET t1.time_to_next_station = t2.diff;