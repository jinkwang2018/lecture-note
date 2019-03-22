<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8">
	<title>사원관리페이지</title>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="assets/jquery/jquery-2.1.4.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/datatables/js/jquery.dataTables.min.js"></script>
	<script src="assets/datatables/js/dataTables.bootstrap.js"></script>
	<script src="assets/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
	
	<!-- CSS includes -->
	<link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="assets/datatables/css/dataTables.bootstrap.css" rel="stylesheet">
	<link href="assets/bootstrap-datepicker/css/bootstrap-datepicker3.min.css" rel="stylesheet">

</head>
<body>
<!-- 메인상단페이지 -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="navbar-header">
				<a class="navbar-brand" href="index.jsp">Admin PAGE</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="index.jsp">Home</a></li>
				<li class="active"><a href="AdminMain.jsp">DeptnoSelect</a></li>
				<li class="active"><a href="<%=request.getContextPath() %>/jsp/dynamicemp.jsp">DynamicEMP</a></li>
				<li class="active"><a href="<%=request.getContextPath() %>/jsp/highcharts.jsp">HighCharts</a></li>
			</ul>
			
	</nav>
	
	
<!-- 분홍색창 -->
	<div class="container" id="emplist">
		<div class="jumbotron" style="text-align: center; background-color: rgba(255, 41, 66, 0.54);">
			<h2 id="Userlist"><i><b>Emp List</b></i></h2>
		</div>
        <button class="btn btn-success" onclick="add_person()"><i class="glyphicon glyphicon-plus"></i> Add Person</button>
        <br />
        <br />
        <table id="table" class="table table-striped table-bordered" cellspacing="0" width="100%">
            <thead>
                <tr>
					<th>EmpNo</th>
					<th>Name</th>
					<th>Job</th>
					<th>Manager</th>
					<th>HireDate</th>
					<th>Salary</th>
					<th>Commission</th>
					<th>DeptNo</th>
                    <th style="width:180px;">Action</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>

<script type="text/javascript">
$(document).ready(function() {		//onload시 이건 알지?
    table = $('#table').DataTable({		//Datatable이라는 제이쿼리 플러그인이 있는데 그거 가져다 쓰겠다는거(https://datatables.net/)
    	"lengthMenu": [[-1,3,5,10,20],["ALL",3,5,10,20]],
    	"processing": true, //processing indicator 생성 로딩할때 멋있어 보이는거
        "order": [], //정렬하는 버튼 생성
        "ajax": {	//비동기로 뿌려주겠다는거
            "url": "EmpList",	//EmpList 서블릿주소
            "dataSrc": "",		//제이슨으로 받아올때 src
            "type":"POST",	//전송방식
            "search":"disabled"
            
        },
        "columns":[				//data:어떤값 받아올지
        { "data": "empno" },
        { "data": "ename" },
        { "data": "job" },
        { "data": "mgr" },
        { "data": "hiredate" },
        { "data": "sal" },
        { "data": "comm" },
        { "data": "deptno" },
		{ "data": "button"}
        ],
        "columnDefs": [			//이건 수정이랑 삭제버튼은 정렬버튼 없애려고 한거임
        { 
            "targets": [ -1 ], //마지막 컬럼
            "orderable": false, //정렬하는거 없앰
        },
        ],
 
    });
    
    //datepicker 달력
    $('.datepicker').datepicker({
        autoclose: true,	//자동닫기
        format: "yyyy-mm-dd",	//날짜형식
        todayHighlight: true,	//이건 찾아보자.. 솔찍히
        orientation: "top auto",
        todayBtn: true,
        todayHighlight: true,  
    });
});  
  

function add_person(){			//사람 추가하는 버튼을 누르면 실행되는 함수
    save_method = 'add';		//밑에서 save로 갈때 insert 서블릿으로 갈껀지 update로 갈껀지 정하기위해서 미리미리
    $('#form')[0].reset();		//form에 있는 값들을 리셋해주고
    $('.form-group').removeClass('has-error');		//부트스트랩에 오류가 있으면 class 제거해주고
    $('.help-block').empty();						//span태그(원래대로라면 데이터유효성검증이 들어갔을태그)에 있는 값도 비우고
    $('#modal_form').modal('show');					//modal형태로 dialog 창 띄우기
    $('.modal-title').text('Add Emp');				//타이틀값
    $('input[name=empno]').attr('readonly',false);	//이건 edit 했을때 readonly값 없애주기 위해서
    $('input[name=ename]').attr('readonly',false);
    $('input[name=hiredate]').attr('disabled',false);
}


function reload_table()
{
    table.ajax.reload(null,false); 					//저장된 테이블 다시 로드
}


function edit_person(empno)
{
    save_method = 'update';		//밑에서 save로 갈때 insert 서블릿으로 갈껀지 update로 갈껀지 정하기위해서 미리미리
    $('#form')[0].reset();
    $('.form-group').removeClass('has-error');
    $('.help-block').empty();
    $('input[name=empno]').attr('readonly',true);	//edit 눌렀을때 수정할수 없는 값들은 readonly로
    $('input[name=ename]').attr('readonly',true);
    $('input[name=hiredate]').attr('disabled',true);
 
    //저장된 데이터 로드
    $.ajax({
        url : "<%=request.getContextPath() %>/EmpUpdate_View?empno="+empno,
        type: "GET",
        dataType: "JSON",
        success: function(data)
        {
 			console.log(data);	//데이터 어떻게 넘어오는지 항상 찍어보라고 선생님께서 말씀하셨지
            $('[name="empno"]').val(data.empno);
            $('[name="ename"]').val(data.ename);
            $('[name="job"]').val(data.job);
            $('[name="mgr"]').val(data.mgr);
            $('[name="hiredate"]').val(data.hiredate);
            $('[name="sal"]').val(data.sal);
            $('[name="comm"]').val(data.comm);
            $('[name="deptno"]').val(data.deptno);
            $('#modal_form').modal('show');
            $('.modal-title').text('Edit Emp'); 
 
        },
        error: function (xhr)
        {
            alert('Error get data from ajax' + xhr.status);
        }
    });
}
 
//솔찍히 save 클래스는 add랑 eidt 2개로 따로 해도되는데 겹치는 코드는 없애는게 좋다고 배워서 합친거
function save()
{
    $('#btnSave').text('saving...');		//save버튼 누르면 바뀜
    $('#btnSave').attr('disabled',true);	//그리고 누르지못하게..
    var url;								//url 생성
 
    if(save_method == 'add') {				//add방식은 EmpInsert타고 다른것(update)는 EmpUpdate 타라고
        url = "EmpInsert";					//추가는 url값에 EmpInsert
    } else {
        url = "EmpUpdate";					//수정은 url값에 EmpUpdate
    }
    $.ajax({
        url : url,							//비동기로 보내는 url
        type: "POST",
        data: $('#form').serialize(),		//폼안에 있는 개체들과 값을 String으로 바꾸어 주는데 유용한 serialize 한국말로하면 직렬화 ajax를 사용해 비동기로 전달하는데 유용하게 사용됨 알아두면 언젠간 써먹지 않을까?
        dataType: "JSON",					//JSON 방식으로
        success: function(data)
        {
        	console.log(data);				//선생님은 말하셨지 데이터 찍어보라고 "이거 안찍히면 밑에꺼 할 이유가 없는거예요"
            if(data==true)					//서블릿에서 데이터 잘오면 true라고 찍히라고 서블릿에 넣어놨음 확인해보세요
            {
                $('#modal_form').modal('hide');		//완료됐으면 form은 사라지게
                reload_table();						//그리고 비동기 방식으로 table을 다시 로드해주자
            }
            alert('반영되었습니다.');					//alert 창 띄어서 반영되었는지 알려주고
            $('#btnSave').text('save');				//위에서 바뀐 버튼 원래대로 텍스트 바꿔주고
            $('#btnSave').attr('disabled',false);	//버튼 활성화 시켜주고
        },
        error: function (xhr)
        {	
            alert('Error' + xhr.status);
            $('#btnSave').text('save');
            $('#btnSave').attr('disabled',false);
        }
    });
}


function delete_person(empno){
    if(confirm('삭제된 데이터는 복구 불가능합니다. 계속하시겠습니까?')){	//바로지워지면 좀 그러니 alert창 한번 띄어주자
        $.ajax({
            url : "<%=request.getContextPath() %>/EmpDelete?empno="+empno,	//empno값을 받아와서 넘겨용
            type: "GET",													//post로해도 되고 get으로 해도됨
            dataType: "JSON",
            success: function(data)
            {
                $('#modal_form').modal('hide');
                reload_table();
            },
            error: function (xhr)
            {
                alert('Error deleting data' + xhr.status);
            }
        });
    }
}
</script> 
<!-- emplist add,edit할때 사용하는 dialog -->
<div class="modal fade" id="modal_form" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h3 class="modal-title">Emp insert</h3>
            </div>
            <div class="modal-body form">
                <form action="#" id="form" class="form-horizontal">
                    <input type="hidden" value="" name="id"/> 
                    <div class="form-body">
                        <div class="form-group">
                            <label class="control-label col-md-3">EmpNo</label>
                            <div class="col-md-9">
                                <input name="empno" placeholder="사번을 입력하세요." class="form-control" type="text">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Name</label>
                            <div class="col-md-9">
                                <input name="ename" placeholder="이름을 입력하세요." class="form-control" type="text">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Job</label>
                            <div class="col-md-9">
                                <select name="job" class="form-control">
                                    <option value="">--Select Job--</option>
                                    <option value="PRESIDENT">President</option>
                                    <option value="MANAGER">Manager</option>
                                    <option value="ANALYST">Analyst</option>
                                    <option value="SALESMAN">Salesman</option>
                                    <option value="CLERK">Clerk</option>
                                </select>
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Manager</label>
                            <div class="col-md-9">
                                <input name="mgr" placeholder="매니저번호를 입력하세요." class="form-control" type="text">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">HireDate</label>
                            <div class="col-md-9">
                                <input name="hiredate" placeholder="입사일을 입력하세요." class="form-control datepicker" type="text">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Salary</label>
                            <div class="col-md-9">
                                <input name="sal" placeholder="연봉정보를 입력하세요." class="form-control" type="text">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">Commission</label>
                            <div class="col-md-9">
                                <input name="comm" placeholder="추가수당을 입력하세요." class="form-control" type="text">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">DeptNo</label>
                            <div class="col-md-9">
                                <input name="deptno" placeholder="부서번호를 입력하세요." class="form-control" type="text">
                                <span class="help-block"></span>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" id="btnSave" onclick="save()" class="btn btn-primary">Save</button>
                <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>