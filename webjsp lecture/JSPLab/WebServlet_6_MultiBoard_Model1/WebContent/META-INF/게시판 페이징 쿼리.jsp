SELECT * FROM ( SELECT ROWNUM rn , idx ,
                             writer , email, homepage, pwd , subject , content, writedate, readnum
                           , filename, filesize , refer , depth , step 
                             FROM ( SELECT * FROM jspboard ORDER BY refer DESC , step ASC ) ) 
                             WHERE rn BETWEEN 1 AND 5;
		     
		   
 select * from ( select rownum rn , idx ,
                        writer , email, homepage, pwd , subject , content, writedate, readnum
                        , filename, filesize , refer , depth , step 
                        from ( 
                                 SELECT * FROM jspboard 
                                 ORDER BY refer DESC , step ASC 
                                 ) where rownum <= 5 --endrow 
                        ) where rn >= 1; --firstrow