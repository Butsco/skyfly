var _ = require('underscore')._;
var fs = require('fs');  // file system
var path = require('path');
var logger = require('winston');
var express = require('express');

////////////////////////////////////////
// SETUP of webserver with websocket  //
////////////////////////////////////////

var app = express();
var http = require('http');

var server = http.Server(app).listen(9000, function () {
  var host = server.address().address;
  var port = server.address().port;
  logger.info('Express server at http://%s:%s', host, port);
});

app.use(express.static('./public'));
app.use(express.static('./s01e01'));
app.set('views', '.')
app.set('view engine', 'ejs')

app.get('/', function(req, res) {
  res.render('./src/templates/index.html.ejs', {});
});
