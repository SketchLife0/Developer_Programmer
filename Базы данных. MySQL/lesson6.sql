DELIMITER $$

CREATE FUNCTION format_seconds(secs INT)
RETURNS VARCHAR(39)
DETERMINISTIC
BEGIN
    DECLARE days INT;
    DECLARE hours INT;
    DECLARE minutes INT;
    DECLARE seconds INT;
    DECLARE formatted VARCHAR(39);
    
    SET days = FLOOR(secs / 86400);
    SET hours = FLOOR((secs - (days * 86400)) / 3600);
    SET minutes = FLOOR((secs - (days * 86400) - (hours * 3600)) / 60);
    SET seconds = secs - (days * 86400) - (hours * 3600) - (minutes * 60);
    SET formatted = CONCAT(
        IF(days > 0, CONCAT(days, ' days '), ''),
        IF(hours > 0, CONCAT(hours, ' hours '), ''),
        IF(minutes > 0, CONCAT(minutes, ' minutes '), ''),
        CONCAT(seconds, ' seconds')
    );
    
    RETURN formatted;
END$$

SELECT format_seconds(12345678)$$

CREATE PROCEDURE even_numbers (num INT)
BEGIN 
    DECLARE i INT DEFAULT 1;
    CREATE TEMPORARY TABLE even_nums (num INT);
    WHILE i <= num DO
        IF (i%2=0) THEN
            INSERT INTO even_nums (num) VALUES (i);
        END IF;
        SET i = i + 1;
    END WHILE;
    SELECT * FROM even_nums;
    DROP TEMPORARY TABLE even_nums;
END$$

CALL even_numbers(100)$$

DELIMITER ;