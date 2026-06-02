-- Create a table named orders
create table orders(
    order_no int primary key, purchase_amount float, order_date date,
    customer_id int, salesman_id int);

-- Add values to the table
INSERT ALL
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005)
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001)
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003)
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002)
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001)
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001)
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006)
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003)
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002)
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007)
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001)
SELECT 1 FROM DUAL;

--Activity 6
select Distinct salesman_id from orders;

select order_no,order_date from orders order by order_date;

select order_no, purchase_amount from orders order by PURCHASE_AMOUNT desc;

select * from orders where purchase_amount < 500;

select * from orders where purchase_amount between 1000 and 2000;


--Activity 7
select sum(purchase_amount) from orders;
select avg(purchase_amount) from orders;
select max(purchase_amount) from orders;
select min(purchase_amount) from orders;
select count(Distinct salesman_id) from orders;

--Activity 8
SELECT customer_id,max(purchase_amount) as highest_purchase 
from orders group by customer_id;

select salesman_id,max(purchase_amount) as highest_purchase from orders 
where order_date = to_date('2012-08-17','yyyy-mm-dd')
group by salesman_id;

select order_id,order_date,max(purchase_amount)as highest_purchase 
from orders
where purchase_amount in (2030, 3450, 5760, 6000)
group by order_no,order_date;