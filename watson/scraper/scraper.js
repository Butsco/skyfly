var Scraper = require ('images-scraper')
, google = new Scraper.Google()
, bing = new Scraper.Bing()
, yahoo = new Scraper.Yahoo()
, pics = new Scraper.Picsearch()
, url = require('url')
, exec = require('child_process').exec;

var subject = 'Sansa Stark';
var num = 250;
var DOWNLOAD_DIR = 'sansa_stark/';

google.list({
	  keyword: subject,
	  num: num,
	  detail: true,
	  nightmare: {
		    show: true
	  }
})
    .then(function (res) {
	      log_res(res);
    }).catch(function(err) {
	      console.log('err', err);
    });

bing.list({
	  keyword: subject,
	  num: num,
	  detail: true,
	  nightmare: {
		    show: true
	  }
})
    .then(function (res) {
	      log_res(res);
    }).catch(function(err) {
	      console.log('err', err);
    });

yahoo.list({
	  keyword: subject,
	  num: num,
	  detail: true,
	  nightmare: {
		    show: true
	  }
})
    .then(function (res) {
	      log_res(res);
    }).catch(function(err) {
	      console.log('err', err);
    });

pics.list({
	  keyword: subject,
	  num: num,
	  detail: true,
	  nightmare: {
		    show: true
	  }
})
    .then(function (res) {
	      log_res(res);
    }).catch(function(err) {
	      console.log('err', err);
    });

function log_res(res){
    for(i=0; i<res.length; i++){
        if(res[i].format=='jpg' || res[i].format=='jpeg'){
            download_file_wget(res[i].url)
        }
    }
}

var download_file_wget = function(file_url) {

    // extract the file name
    var file_name = url.parse(file_url).pathname.split('/').pop();
    // compose the wget command
    var wget = 'wget -P ' + DOWNLOAD_DIR + ' ' + file_url;
    // excute wget using child_process' exec function

    var child = exec(wget, function(err, stdout, stderr) {
        if (err) throw err;
        else console.log(file_name + ' downloaded to ' + DOWNLOAD_DIR);
    });
};
