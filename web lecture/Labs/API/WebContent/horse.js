/*

 * HTML5 Web Worker

 * 2012.10.17

 * http://blog.naver.com/necrosis

 */

 

//초기값 100



 

//반복 호출 함수

function run() {
	for(var i = 100 ; i < 10 ; i++){
		  i += 1;
		 
		};
 
		 postMessage(i);
  


};
