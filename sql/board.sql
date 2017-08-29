-- create sequence
drop sequence seq_board;

create sequence seq_board
start with 1
increment by 1
maxvalue 9999999999;

select max(g_no) from board;

-- 새글
insert into board
values ( seq_board.nextval, 
         ?, 
		 ?, 
		 sysdate,
		 0,
		 nvl((select max(g_no) from board), 0) + 1,
		 1,
		 1,
		 ?);
		 
-- 답글
-- 부모글이 g_no=1, o_no=1, depth=1 인 경우,
-- 1)
   update board
      set o_no = o_no + 1
    where g_no = 1  -- g_no
	  and o_no > 1; -- o_no
-- 2)
insert into board
values ( seq_board.nextval, 
         '새글의 답글', 
		 '새글의 답글', 
		 sysdate,
		 0,
		 1,  -- g_no
		 2,  -- o_no + 1
		 2,  -- depth + 1
		 1); -- authUser.no
  
   		 
commit;		 
select * from board;		 
		 
		 
-- list
-- 페이지당 5개씩  3 페이지를 가져오는 경우 
select *
  from (select no, title, hit, reg_date, depth, 
	           member_no, name, rownum as rn
          from (   select a.no, a.title, a.hit,
		                  to_char(reg_date, 'yyyy-mm-dd hh:mi:ss') as reg_date,
	                      a.depth, a.member_no, b.name
                     from board a, member b
                    where a.member_no = b.no
                 order by g_no desc, o_no asc))
 where (3-1)*5+1 <= rn and rn <= 3*5;  

		 