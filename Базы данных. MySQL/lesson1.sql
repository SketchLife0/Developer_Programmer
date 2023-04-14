USE `geekbrains(lesson1)`;

SELECT * FROM mobile_phones;

SELECT product_name, manufacturer, price
FROM mobile_phones
WHERE product_count > 2;

SELECT *
FROM mobile_phones
WHERE manufacturer = "Samsung";