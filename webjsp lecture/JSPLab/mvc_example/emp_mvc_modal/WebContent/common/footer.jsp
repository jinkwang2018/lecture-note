<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%> 
<% application.getInitParameter("email"); application.getInitParameter("team"); %>
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-6 text-left copyright">
					관리자 이메일: <%= application.getInitParameter("email") %>
                    <div class="credits">
                      <%= application.getInitParameter("company") %> ©Copyright - Bocor. All Rights Reserved
						Bootstrap Themes by BootstrapMade
                    </div>
				</div>
			</div>	
		</div>
	</footer>