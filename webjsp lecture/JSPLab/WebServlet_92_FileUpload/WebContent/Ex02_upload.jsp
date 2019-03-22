<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--
cos.jar에서 다중 파일 업로드를 지원하는 객체가 바로 >> MultipartRequest >> request 객체를 넘겨준다.
***MultipartRequest 객체의 생성자**************************************************
      MultipartRequest(
      				javax.servlet.http.HttpServletRequest request,
      				java.lang.String saveDirectory,
      				int maxPostSize,
      				java.lang.String encoding,
      				FileRenamePolicy policy)

     request : MultipartRequest와 연결될 request객체를 의미한다.
     saveDirectiory : 서버측에 파일이 실질적으로 저당될 경로를 의미한다.
     maxPostSize : 한번에 업로드 할수있는 최대 파일 크기를 의미한다.
     encoding : 파일의 이름 인코딩 방식을 의미한다.
     policy : 파일이름 중복 처리를 위한 인자를 의미한다.  기본값 : 똑같은 파일 덮어쓰기

     ***MultipartRequest 객체의 메서드**************************************************
     getParameterNames() :  폼에서 전송된 파라미터의 타임이 file이 아닌 이름들을 Enumeration 타입으로 리턴한다.
     getParameterValues() : 폼에서 전송된 파라미터 값들을 배열로 받아온다.
     getParameter() : Request객체에 있는 해당 파라미터의 값을 가져온다.
     getFileNames() : 파일을 여러개 업로드 할 경우 타입이 file인 파라미터 이름들을 Enumeration 타입으로 리턴한다.
     getFileSystemName() : 서버에 실제로 업로드 된 파일의 이름을 의미한다.
     getOriginalFileName() : 클라이언트가 업로드 한 파일의 원본 이름을 의미한다.
     getContentType() : 업로드 된 파일의 컨텐트 타입을 얻을때 사용한다.
     getFile() :  서버에 업로드 된 파일 객체 자체를 반환하는 메소드이다.


      가상경로(웹) : http://localhost:8090/Web_jsp_fileupload_14/upload/
      물리적 경로(웹 서버 특정경로) :
  1. C:\kosta166\WebJSP\JSPLab\WebServlet_92_FileUpload\WebContent\upload
  2. 이클립스 톰켓 내장 :
 	  실제 파일 저장 경로(아래 있는 경로)
     C:\kosta166\WebJSP\JSPLab\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\WebServlet_92_FileUpload\upload

-->
<%
	String uploadpath = application.getRealPath("upload");
    //out.print(uploadpath + "<br>");

    //cos.jar 파일에서 제공하는 MultipartRequest 객체 사용
    int size = 10*1024*1024; //10M
    String name="";
    String title="";
    String filename1="";
    String filename2="";
    String orifilename1="";
    String orifilename2="";

    MultipartRequest multi = new MultipartRequest(
    			request,//기존 사용했던 request 객체 주소
    			uploadpath, //실 저장 경로
    			size,
    			"UTF-8",
    			new DefaultFileRenamePolicy() //파일 중복 (btn.jpg > 업로드 > btn1.jpg )
    		); //파일 업로드 완료

    //웹 서버의 특정 폴더에 업로드 완료
    //추가 작업 (자료실)
    //DB insert  작업
    //작성자 , 제목 , [파일명] , [파일 사이즈] Table 에  insert 작업


    name = multi.getParameter("name");
    title = multi.getParameter("title");
    String hid = multi.getParameter("hid");

    Enumeration filenames = multi.getFileNames();
    /*while(filenames.hasMoreElements()){
    	out.print(filenames.nextElement());
    }*/

    //filename2 , filename1
    String file2 = (String)filenames.nextElement();
    filename2 = multi.getFilesystemName(file2);
    orifilename2 = multi.getOriginalFileName(file2);
    //out.print("file2 : " + file2 + "<br>");
    //out.print("filename2 : " + filename2 + "<br>");
    //out.print("orifilename2 : " + orifilename2 + "<br>");

    String file1 = (String)filenames.nextElement();
    filename1 = multi.getFilesystemName(file1); //변경된 이름 : a1.jpg
    orifilename1 = multi.getOriginalFileName(file1); //원 이름 : a2.jpg

    out.print("name : " + name + "<br>");
    out.print("title : " + title + "<br>");
    out.print("hid : " + hid + "<br>");
    out.print("file2 : " + file2 + "<br>");
    out.print("filename2 : " + filename2 + "<br>");
    out.print("orifilename2 : " + orifilename2 + "<br>");
    out.print("<hr>");
    out.print("file1 : " + file1 + "<br>");
    out.print("filename1 : " + filename1 + "<br>");
    out.print("orifilename1 : " + orifilename1 + "<br>");

    //DB 에 저장했다고 가정하고
    //DB insert  작업 (boardupload 테이블에)
    //작성자 , 제목 , [파일명] , [파일 사이즈] Table 에  insert 작업


    //게시판 목록보기 구현
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	  <form action="Ex03_uploadlist.jsp" method="get" name="filelist">
	  	 <input type="hidden" name="name" value="<%=name %>">
	  	 <input type="hidden" name="title" value="<%=title %>">
	  	 <input type="hidden" name="filename1" value="<%=filename1 %>">
	  	 <input type="hidden" name="orifilename1" value="<%=orifilename1 %>">
	  	 <input type="hidden" name="filename2" value="<%=filename2 %>">
	  	 <input type="hidden" name="orifilename2" value="<%= orifilename2%>">
	  	 <a href="#" onclick="javascript:filelist.submit()">다운로드 리스트</a>
	  </form>
</body>
</html>
