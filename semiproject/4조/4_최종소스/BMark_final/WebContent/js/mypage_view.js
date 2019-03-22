
function pagelist(cpage, pagesize) {
	$.ajax(
			{
				url:"mypagegroupboardlistagain.mybmark",
				dataType:"HTML",
				data:{ cp:cpage , ps:pagesize },
				type:"POST",
				success:function(data){
					$('#mypageteamblist').empty();
					$('#mypageteamblist').append(data);
					
				}
			}
	)
}

function pagelist1() {
	var param =$("#pagesize").serialize();
	$.ajax(
			{
				url:"mypagegroupboardlistagain.mybmark",
				dataType:"HTML",
				data: param,
				type:"POST",
				success:function(data){
					$('#mypageteamblist').empty();
					$('#mypageteamblist').append(data);
					
				}
			}
	)
}

jQuery(function(){
	
		$(document).on('click', '.out-group', function() {
			var sessiosnGID = "${sessionScope.gid}"
			//console.log(sessiosnGID == 0);
			if(sessiosnGID != 0){ 
				BootstrapDialog.show({
					type: BootstrapDialog.TYPE_PRIMARY,
		            message: '그룹을 탈퇴하시겠습니까?',
		            buttons: [{
				                label: '탈퇴하기',
				                cssClass: 'btn-primary',
				                action: function(dialogItself){
				                	location.href = 'outGroupok.group';
				                }
				              },{
				                label: '취소',
				                cssClass: 'btn-warning',
			                	action: function(dialogItself){
				                    dialogItself.close();
				                }
			        }]
		        });
			}else {
				alert("가입하신 그룹이 없습니다.");
			}
		});
});