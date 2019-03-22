var http = require('http');
var url = require('url');
var path = require("path");
var fs = require("fs");
var querystring = require('querystring');


var server = http.createServer(function (request, response) {

  var POST = {};
    if (request.method == 'POST') {
        request.on('data', function(data) {
            data = data.toString();
            data = data.split('&');
            for (var i = 0; i < data.length; i++) {
                var _data = data[i].split("=");
                POST[_data[0]] = _data[1];
            }
            console.log(POST);
        })
    }
    //query 획득
    var queryData = url.parse(request.url, true).query;

    if (queryData.name) {
        console.log(queryData.name);
    } 

    //path..
    var uri = url.parse(request.url).pathname
    , filename = path.join(process.cwd(), uri);
  
     var ext=path.extname(uri);
     console.log(uri+':'+ext);

     if(ext == '.jpg'){
        fs.readFile(filename, "binary", function(err, file) {
          if(err) {        
            response.writeHead(500, {"Content-Type": "text/plain;charset=UTF-8"});
            response.write(err + "\n");
            response.end();
            return;
          }

          response.writeHead(200);
          response.write(file, "binary");
          response.end();
        });
     }else {
       console.log('11');
        fs.readFile(filename, "utf8", function(err, file) {
          console.log(file);
          if(err) {        
            response.writeHead(500, {"Content-Type": "text/plain;charset=UTF-8"});
            response.write(err + "\n");
            response.end();
            return;
          }

          response.writeHead(200,{"Content-Type": "text/plain;charset=UTF-8"});
          response.write(file, "utf8");
          response.end();
        });
     }

    

});

server.listen(8000);