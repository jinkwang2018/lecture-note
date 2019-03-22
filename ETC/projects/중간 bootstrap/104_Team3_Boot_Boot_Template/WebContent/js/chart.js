var i=j=k=l=m=0
var aa=ab=ac=ad=ae=af=ag=ah=ai=aj=ak=al=0
var datas =[]
$.ajax({
    url : 'http://openapi.gangnam.go.kr:8088/7842674c6b6a696e35336f50735752/json/GnModelRestaurantDesignate/1/1000/',
	dataType:"json", 
	success:function(responsedata){
    $.each(responsedata.GnModelRestaurantDesignate.row, function(index, obj) {
    	datas.push(obj)
    	
		if(obj.SNT_UPTAE_NM === '한식'){
			i++
		}else if(obj.SNT_UPTAE_NM ==='경양식'){
			j++
		}else if(obj.SNT_UPTAE_NM === '중국식'){
			k++
		}else if(obj.SNT_UPTAE_NM === '분식'){
			l++
		}else if(obj.SNT_UPTAE_NM === '일식'){
			m++
		}
		
        var adr = obj.ADMDNG_NM.substr(0, 2)
		
        if(adr == '청담'){
        	aa++
        }else if(adr == '논현'){
        	ab++
        }else if(adr == '대치'){
        	ac++
        }else if(adr == '삼성'){
        	ad++
        }else if(adr == '수서'){
        	ae++
        }else if(adr == '일원'){
        	af++
        }else if(adr == '역삼'){
        	ag++
        }else if(adr == '신사'){
        	ah++
        }else if(adr == '개포'){
        	ai++
        }else if(adr == '세곡'){
        	aj++
        }else if(adr == '도곡'){
        	ak++
        }else if(adr == '압구'){
        	al++
        }
    });
    $('body').show()
    }
})

$(function(){
	$('button').click(function() {
		$('#display').empty();
		$('#container').empty();
	})
	
	$('#btn').click(function(){
		var num = 1;
		var table = "<table id='myTable' class='tablesorter'>";
		table += "<thead><tr><th>num</th><th>지정일자</th><th>업소명</th><th>소재지도로명</th><th>업태명</th><th>주된음식</th><th>행정동명</th><th>소재지전화번호</th></tr></thead><tbody>"
		$.each(datas, function(index, obj) {
			if($("#line > option:selected").val() == '전체보기'){
				table += "<tr>";
				table += "<td>" + (num++) + "</td>";
				table += "<td>" + obj.ASGN_YMD + "</td>";
				table += "<td>" + obj.UPSO_NM + "</td>";
				table += "<td>" + obj.SITE_ADDR_RD + "</td>";
				table += "<td>" + obj.SNT_UPTAE_NM + "</td>";
				table += "<td>" + obj.MAIN_EDF + "</td>";
				table += "<td>" + obj.ADMDNG_NM + "</td>";
				table += "<td>" + obj.UPSO_SITE_TELNO + "</td>";
				table += "</tr>";
			}else if(obj.SNT_UPTAE_NM == $("#line > option:selected").val()){
		        table += "<tr>";
				table += "<td>" + (num++) + "</td>";
		        table += "<td>" + obj.ASGN_YMD + "</td>";
		        table += "<td>" + obj.UPSO_NM + "</td>";
		        table += "<td>" + obj.SITE_ADDR_RD + "</td>";
		        table += "<td>" + obj.SNT_UPTAE_NM + "</td>";
		        table += "<td>" + obj.MAIN_EDF + "</td>";
		        table += "<td>" + obj.ADMDNG_NM + "</td>";
		        table += "<td>" + obj.UPSO_SITE_TELNO + "</td>";
		        table += "</tr>";
		    }
		});
		table += "</tbody></table>";
		$('#display').html(table);
		$("#myTable").tablesorter(); 
	});
	
	
	$('#btn1').click(function() {
		if($('#chart > option:selected').val() =='spline'){
			$('#container').attr({style:"height:400px"})
			Highcharts.chart('container', {
			    chart: { type: 'spline' },
			    title: { text: '행정동별 음식점 수' },
			    subtitle: { text: 'Source: gangnam.go.kr' },
			    xAxis: { categories: ['개포', '논현', '대치', '도곡', '수서'
						,'신사', '삼성', '세곡', '일원', '역삼', '압구', '청담'] 
			    },
			    yAxis: { 
			    	title: { text: '음식점 수' },
			        labels: { 
			        	formatter: function () { 
			        		return this.value; 
		        		} 
			    	}
			    }, 
			    tooltip: { crosshairs: true, shared: true },
			    plotOptions: {
			        spline: {
			            marker: { 
			            	radius: 4, lineColor: '#777777', lineWidth: 1 
		            	}
			        }
			    },
			    series: [{ 
			    	name: '', 
			    	marker: { symbol: 'square' },
			        data: [ai, ab, ac, ak, ae, ah, ad, aj, af, ag, al, aa]
			    }]
			});
	}else if($('#chart > option:selected').val() == 'piechart'){
		$('#container').attr({style:"height:400px"})
		Highcharts.chart('container', {
		    chart: {
		        plotBackgroundColor: null,
		        plotBorderWidth: null,
		        plotShadow: false,
		        type: 'pie'
		    },
		    title: { text: '강남구 업종별 음식점 비율' },   
		    tooltip: { pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>' },
		    plotOptions: {
		        pie: {
		            allowPointSelect: true,
		            cursor: 'pointer',
		            dataLabels: {
		                enabled: true,
		                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
		                style: { color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black' },
		                connectorColor: 'silver'
		            }
		        }
		    },
		    series: [{
		        name: 'Share',
		        data: [
		            { name: '한식', y: i },
		            { name: '일식', y: m },
		            { name: '경양식', y: j },
		            { name: '중국식', y: k },
		            { name: '분식', y: l }
			        ]
			    }]
			});
		}else if($('#chart > option:selected').val() == 'Wordcloud'){
			$('#container').attr({style:"height:800px"})
			var text
			$.each(datas, function(index, obj) {
				text += obj.MAIN_EDF +","
			}); 
			var lines = text.split(/[,\. ]+/g)
			
			    data = Highcharts.reduce(lines, function (arr, word) {
			        var obj = Highcharts.find(arr, function (obj) {
			            return obj.name === word;
			        });
			        if (obj) {
			            obj.weight += 1;
			        } else {
			            obj = {
			                name: word,
			                weight: 1
			            };
			            arr.push(obj);
			        }
			        return arr;
			    }, []);
				Highcharts.chart('container', {
				    series: [{
				        type: 'wordcloud',
				        data: data,
				        name: 'Occurrences'
				    }],
				    title: {
				        text: 'Wordcloud of Lorem Ipsum'
				    }
			});
		}
	})
})