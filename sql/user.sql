-- create sequence
drop sequence seq_member;

create sequence seq_member
start with 1
increment by 1
maxvalue 9999999999;

-- insert
insert
  into member
values ( seq_member.nextval, '둘리', '1234', 'dooly@gmail.com', 'male', sysdate);

-- login
select no, name
  from member
 where email='kickscar@gmail.com'
   and password = '1234';
   
   
    

commit;
select * from member;