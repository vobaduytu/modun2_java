call getCusById(175);
CALL GetCustomersCountByCity('Lyon',@total);
SELECT @total;
SET @counter = 1;
CALL SetCounter(@counter,1);	
CALL SetCounter(@counter,1);
CALL SetCounter(@counter,5);
select @counter;