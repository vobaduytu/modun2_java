SELECT * FROM classicmodels.customer_views;
CREATE OR REPLACE VIEW customer_views AS

SELECT customerNumber, customerName, contactFirstName, contactLastName, phone

FROM customers

WHERE city = 'Nantes';
SELECT * FROM classicmodels.customer_views;
drop view new_view;