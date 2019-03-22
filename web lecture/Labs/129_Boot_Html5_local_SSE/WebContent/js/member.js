/**
 * 
 */

$(function(){
	
	
	
	
	
	
	$('.myung').click(function(){
			$( "#dialog" ).dialog( "open" );
	});
		
	  $( "#dialog" ).dialog({
      autoOpen: false,
      width : 700,
	  height : 500,
      show: {
        effect: "blind",
        duration: 1000
      },
      hide: {
        effect: "explode",
        duration: 1000
      }
    });

		
		//성준이 다이어 로그 띄움
		$('.park').click(function(){
			
			$( "#seungdialog" ).dialog( "open" );
	
			
		});

		$( "#seungdialog" ).dialog({
		      autoOpen: false,
		      width : 700,
			  height : 500,
		      show: {
		        effect: "blind",
		        duration: 1000
		      },
		      hide: {
		        effect: "explode",
		        duration: 1000
		      }
		    });


		
		
		$('.woo').click(function(){
			
			$('#myungdialog').dialog( "open" );
			
		});

		$( "#myungdialog" ).dialog({
		      autoOpen: false,
		      width : 700,
			  height : 500,
		      show: {
		        effect: "blind",
		        duration: 1000
		      },
		      hide: {
		        effect: "explode",
		        duration: 1000
		      }
		    });



		////////////////////////////////////////////////////
		//주희
		$('.kim').click(function(){
			
			$('#Judialog').dialog("open");
		
		});
		
		$( "#Judialog" ).dialog({
		      autoOpen: false,
		      width : 700,
			  height : 500,
		      show: {
		        effect: "blind",
		        duration: 1000
		      },
		      hide: {
		        effect: "explode",
		        duration: 1000
		      }
		    });

		$('#addF4').click(function(){
			
			var name = $('.mn4').text();
				$('#fname').text(name);
				
				var phone = $('.mp4').text();
				
				$('#fphone').text(phone);
				
				$( "#info" ).dialog( "open" );
			});
			
			
		
		
			
		///////////////////////////////////////////////
		
		$('.ha').click(function(){
			
			$('#Hadialog').dialog("open");
			
		});
		
		$( "#Hadialog" ).dialog({
		      autoOpen: false,
		      width : 700,
			  height : 500,
		      show: {
		        effect: "blind",
		        duration: 1000
		      },
		      hide: {
		        effect: "explode",
		        duration: 1000
		      }
		    });

		$('#addF5').click(function(){
			
			var name = $('.mn5').text();
				$('#fname').text(name);
				
				var phone = $('.mp5').text();
				
				$('#fphone').text(phone);
				
				$( "#info" ).dialog( "open" );
			});
			
			
		

		
		
		
		
		$('.mak').click(function(){
			$('#Makdialog').dialog("open");
		});

		
		
		$( "#Makdialog" ).dialog({
		      autoOpen: false,
		      width : 700,
			  height : 500,
		      show: {
		        effect: "blind",
		        duration: 1000
		      },
		      hide: {
		        effect: "explode",
		        duration: 1000
		      }
		    });

		$('#addF6').click(function(){
			
			var name = $('.mn6').text();
				$('#fname').text(name);
				
				var phone = $('.mp6').text();
				
				$('#fphone').text(phone);
				
				$( "#info" ).dialog( "open" );
			});
			
			

		
	/////////////////////////////////////////////////////
	//성준 친구추가
	$('#addF2').click(function(){
			
		var name = $('.mn2').text();
			$('#fname').text(name);
			
			var phone = $('.mp2').text();
			
			$('#fphone').text(phone);
			
			$( "#info" ).dialog( "open" );
		});
		
		
	
	//명철 친구추가
	$('#addF').click(function(){
		var name = $('.mn').text();
		$('#fname').text(name);
		
		var phone = $('.mp').text();
		
		$('#fphone').text(phone);
		
		$( "#info" ).dialog( "open" );
	});
	
	$( "#info" ).dialog(
		{
	      autoOpen: false,
	      width : 300,
		  height : 350  
	    },
	    
	    {
	    	
	    }
		
	);
	
	////////////////////////////////////////////////////////////
	
	
	$('#addF3').click(function(){
		var name = $('.mn3').text();
		$('#fname').text(name);
		
		var phone = $('.mp3').text();
		
		$('#fphone').text(phone);
		
		$( "#info" ).dialog( "open" );
	});
	
	
	
	
	
	//확인버튼
	$('#okbtn').click(function(){
		$('#fname').text('');
		$('#fphone').text('');
		$('#info').dialog("close");
	});
	
});