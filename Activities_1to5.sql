create table salesman(
    salesman_id int primary key,
    salesman_name varchar2(20),
    salesman_city varchar2(20),
    commission int
);

desc salesman;

insert all
     into salesman VALUES(5001,'James Hog','New York',15)
     into salesman VALUES(5002,'Nail Knite','Paris',13)
     into salesman VALUES(5003,'Pit Alex','London',11)
     into salesman VALUES(5004,'Paul Adam','Rome',13)
     into salesman VALUES(5005,'Lauson Hen','San Jose',12)
 select 1 from dual;

 select * from salesman;

--Activity 3
 select salesman_id, salesman_city from salesman;

 select * from salesman where salesman_city ='Paris';

 select salesman_id,commission from salesman where salesman_name='Paul Adam';

 --Activity 4
 Alter table salesman add(grade int);

 update salesman set grade =100;
 --Activity 5

 update salesman set grade = 200 where salesman_city ='Rome';

 update salesman set grade = 300 where salesman_name ='James Hog';

update salesman set salesman_name = 'Pierre' where salesman_name ='Mclyon';