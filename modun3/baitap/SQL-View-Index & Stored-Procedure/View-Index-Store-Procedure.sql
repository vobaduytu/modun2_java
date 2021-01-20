SELECT * FROM demo.new_view;
create or replace view new_view as 
select productCode,productName,productStatus
from products;
drop view new_view; 
call new_procedure;
call add_product('10','nam',10,15,'no','con');
select * from products;
call edit_product(1,'14555','dat nguyen',10,15,'beo','con');
select * from products;
call remove(1);