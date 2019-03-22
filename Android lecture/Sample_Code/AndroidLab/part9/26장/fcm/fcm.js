var FCM = require('fcm-push');

var http = require('http');
var url = require('url');
var path = require("path");
var fs = require("fs");
var querystring = require('querystring');

//fcm console에서 획득하는 서버키
var serverKey="~~~~~~";
var appToken="~~~~~~~";

var fcm = new FCM(serverKey);

var server = http.createServer(function (request, response) {
    console.log('111');
    //path..
    var uri = url.parse(request.url).pathname;
    console.log(uri);
     if(uri == '/fcm.html'){
        
       console.log('11');
        fs.readFile('.'+uri, "utf8", function(err, file) {
          console.log(file);
          if(err) {        
            response.writeHead(500, {"Content-Type": "text/plain;charset=UTF-8"});
            response.write(err + "\n");
            response.end();
            return;
          }

          response.writeHead(200,{"Content-Type": "text/html;charset=UTF-8"});
          response.write(file, "utf8");
          response.end();
        });
     }else if(uri == '/fcm-send'){

         //query 획득
        var queryData = url.parse(request.url, true).query;

        var message = {
            //앱 Key
            to: appToken,

            collapse_key: '222',
            //실제 전달 메시지..
            data: {
                msg: queryData.message
            }
   
        };

        fcm.send(message, function(err, response){
            if (err) {
                console.log("Something has gone wrong!");
            } else {
            console.log("Successfully sent with response: ", response);
            }
        });
    }

    

});

server.listen(8000);

