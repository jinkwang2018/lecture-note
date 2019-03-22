<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
	//jquery 로 간단하게 유효성 check 하기
	$(function() {
/* 		$('#joinForm').submit(function() {
			//alert("가입");
			if ($('#id').val() == "") { // 아이디 검사
				alert('ID를 입력해 주세요.');
				$('#id').focus();
				return false;
			} else if ($('#pwd').val() == "") { // 비밀번호 검사
				alert('PWD를 입력해 주세요.');
				$('#pwd').focus();
				return false;
			} else if ($('#name').val() == "") { // 이름 검사
				alert('name를 입력해 주세요.');
				$('#name').focus();
				return false;
			} else if ($('#age').val() == "") { // 나이 검사
				alert('age를 입력해 주세요.');
				$('#age').focus();
				return false;
			} else if ($('#email').val() == "") { // 우편번호
				alert('email를 입력해 주세요.');
				$('#email').focus();
				return false;
			}

		}); 
*/
		var monthNames = [];
		for (var i = 1; i <= 12; i++) {
			monthNames.push(i + "월")
		}
		/* hiredate- datepicker */
		    $( "#hiredate" ).datepicker({
		    	dateFormat : "yy년mm월dd일",
				prevText : "이전달",
				nextText : "다음달",
				monthNames : monthNames,
				dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
				yearSuffix : '년',
				numberOfMonths : 1,
				onSelect : function(date) {
					var currentdate = $("#hiredate").datepicker('getDate');
					var date = new Date(currentdate);
					$("#inputdate").val(
							date.getFullYear() + "- "
									+ (date.getMonth() + 1) + "- "
									+ date.getDate());
				}
		    });
		/* deptno-spinner */
		    var spinner = $('#deptno').spinner({
				step : 10,
				numberFormat : "n",
				max : 30,
				min : 10
			});
	});
</script>
</head>
<body>
<jsp:include page="/common/Top.jsp"></jsp:include>
	<!-- container -->
	<div class="container">
		<div class="account-holder" style="border: 1px solid black;">
			<form action="Emp.do?cmd=Insert" method="post" name="InsertForm"
				id="InsertForm">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-6 col-xs-12">
						<div class="form-group">
							<label class="control-label required">사원번호<sup
								style="color: red">*</sup>
							</label> <input id="empno" name="empno" type="text" class="form-control"
								placeholder="Enter Your Empno">
						</div>
					</div>
					<div class="col-lg-12 col-md-12 col-sm-6 col-xs-12">
						<div class="form-group">
							<label class="control-label required">사원이름<sup
								style="color: red">*</sup></label> <input id="ename" name="ename"
								type="text" class="form-control"
								placeholder="Enter Your Empname">
						</div>
					</div>
					<div class="col-lg-12 col-md-12 col-sm-6 col-xs-12">
						<div class="form-group">
							<label class="control-label required">직종<sup
								style="color: red">*</sup></label> <select id="job" name="job"
								class="form-control">
								<option>직종을 선택하세요</option>
								<option value="CLERK">CLERK</option>
								<option value="SALESMAN">SALESMAN</option>
								<option value="MANAGER">MANAGER</option>
								<option value="ANALYST">ANALYST</option>
								<option value="PRESENT">PRESENT</option>
							</select>
						</div>
					</div>
					<div class="col-lg-12 col-md-12 col-sm-6 col-xs-12">
						<div class="form-group">
							<label class="control-label required">담당 매니저 번호<sup
								style="color: red">*</sup></label> <input id="mgr" name="mgr"
								type="text" class="form-control"
								placeholder="Enter Your Manager Number">
						</div>
					</div>
					<div class="col-lg-12 col-md-12 col-sm-6 col-xs-12">
						<div class="form-group">
							<label class="control-label required">입사일<sup
								style="color: red">*</sup></label>
							<div id="hiredate"></div>
							<input id="inputdate" name="hiredate"
								type="text" class="form-control">
						</div>
					</div>
					<div class="col-lg-12 col-md-12 col-sm-6 col-xs-12">
						<div class="form-group">
							<label class="control-label required">월급<sup
								style="color: red">*</sup></label> <input id="sal" name="sal"
								type="text" class="form-control"
								placeholder="Enter Your Salary">
						</div>
					</div>
					<div class="col-lg-12 col-md-12 col-sm-6 col-xs-12">
						<div class="form-group">
							<label class="control-label required">추가수당<sup
								style="color: red">*</sup></label> <input id="comm" name="comm"
								type="text" class="form-control"
								placeholder="Enter Your Commit">
						</div>
					</div>
					<div class="col-lg-12 col-md-12 col-sm-6 col-xs-12">
						<div class="form-group">
							<label class="control-label required" for="spinner" >부서번호<sup style="color: red">*</sup></label>
								<input style="width:84%; height: 85%;" id="deptno" name="deptno" value="0" class="form-control">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6">
						<input type="submit" class="btn btn-primary btn-block"
							value="JOIN">
					</div>
					<div class="col-sm-6">
						<input type="reset" class="btn btn-primary btn-block" value="취소">
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>