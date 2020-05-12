访问:
http://127.0.0.1:8070/interface-ui

dataql查询的方式:
var query = @@sql()<%
    select * from interface_info
%>
return query()

sql查询的方式:
  select * from interface_info 
  
问题:
   1.异常:Unknown SqlMode.
     把注释去掉
     [图片](./images/20200512175916.jpg)
