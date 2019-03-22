<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Navigation -->
    <div id="navigation">
        <nav class="navbar navbar-custom" role="navigation">
                              <div class="container">
                                    <div class="row">
                                          <div class="col-md-2">
                                                   <div class="site-logo">
                                                            <a href="index.jsp" class="brand">사원관리</a>
                                                    </div>
                                          </div>
                                          

                                          <div class="col-md-10">
                         
                                                      <!-- Brand and toggle get grouped for better mobile display -->
                                          <div class="navbar-header">
                                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#menu">
                                                <i class="fa fa-bars"></i>
                                                </button>
                                          </div>
                                                      <!-- Collect the nav links, forms, and other content for toggling -->
                                                      <div class="collapse navbar-collapse" id="menu">
                                                            <ul class="nav navbar-nav navbar-right">
                                                          
                                                            	
                                                                 	 <!--   login/logout show 처리-->
                                                                  <c:choose>
                                                                  <c:when test="${sessionScope.userid == null }">
                                                                  <li><a href="index.jsp">Home</a></li>
                                                                 	</c:when>
                                                                 	<c:when test="${sessionScope.userid != null }">
                                                                  <li><a href="EmpList">Member List</a></li>
																  <li><a href="memberinsert.jsp">Member Registration</a></li>
																  <li><a href="Dept">Dept List</a></li>
																    <li><a href="#">[${sessionScope.userid}]님 접속중</a></li>
																     <li><a href="logout">Logout</a></li> 
																  </c:when>
																  </c:choose>
																  <!--
                                                                  <li><a href="memberlist.jsp">MemberEdit</a></li>				                                                                  
                                                                  <li><a href="EmpDelete">MemberDelete</a></li>
                                                                 -->
                                                                 
                                                            </ul>
                                                      </div>
                                                      <!-- /.Navbar-collapse -->
                             
                                          </div>
                                    </div>
                              </div>
                              <!-- /.container -->
                        </nav>
    </div> 
    <!-- /Navigation -->  
