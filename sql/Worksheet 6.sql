select a.*
  from (select no, 
			 	 name, 
			 	 content, 
			 	 to_char(reg_date, 'yyyy-mm-dd hh:mi:ss') as regDate 
		    from guestbook 
		   where no < 6 
		order by reg_date desc) a
 where rownum <= 5