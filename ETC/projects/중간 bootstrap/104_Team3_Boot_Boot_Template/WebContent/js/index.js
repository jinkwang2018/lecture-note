$(function() { //$(documnet).ready(function() {...})
  //계절 이미지 정보 JSON(봄, 여름, 가을, 겨울)
  var seasonArr = {
    jumboSpring: 
      {
          image: 'url("images/spring.jpg")', //이미지 주소
          menuColor: '#d25386', //메뉴바 컬러
          hoverColor: '#ff0080' //마우스 호버 컬러
      },
    jumboSummer: 
      {
          image: 'url("images/summer.jpg")',
          menuColor: '#01dddd',
          hoverColor: '#00bfaf'
      },
    jumboFall: 
      {
          image: 'url("images/fall.jpg")',
          menuColor: '#a32a2a',
          hoverColor: '#d83000'
      },
    jumboWinter: 
      {
          image: 'url("images/winter.jpg")',
          menuColor: '#c8d3e5',
          hoverColor: '#9e94a5'
      }
  };
  //계절 버튼 클릭 시
  $('button.season').click(function() {
    var seasonId = $(this).attr('id'); //button id속성 변수 선언
    $.each(seasonArr, function(key, value) { //each로 반복문 실행
      if(key === seasonId) { //계절이미지 JSON의 key값과 버튼 클릭의 ID값이 같으면
        //상위 스크린 배경화면 css설정
        $('.jumbotron-imgs').css({ 'background-image': value.image });
        //메뉴바 배경, 보더 색 css설정
        $('.navbar-default').css({
            'background-color': value.menuColor,
            'border-color': value.menuColor
        });
        //메뉴바의 메인 제목 마우스 호버 css설정
        $('.navbar-brand').hover(function() {
            $(this).css({'color': value.hoverColor});
        }, function() {
            $(this).css({'color': ''});
        });
        //링크 마우스 호버 css설정 
        $('.navbar-nav > li > a').hover(function() {
            $(this).css({'color': value.hoverColor});
        }, function() {
            $(this).css({'color': ''});
        });  
        //링크 활성화되었을 때, 마우스 호버 css설정 
        $('.navbar-nav > .active > a').hover(function() {
            $(this).css({'color': value.hoverColor});
        }, function() {
            $(this).css({'color': ''});
        });
        //하단바 배경색 css설정
        $('.footer').css({ 'background-color': value.menuColor });    
      }; //end if
    }); //end each
  }); //end click

}); //end jQuery

// iframe 자동 사이즈 조절
// 해당 html파일의 사이즈를 받아 조절
function autoResize(i) {
    var iframeHeight = i.contentWindow.document.body.scrollHeight;
    i.height = iframeHeight + 500;
};