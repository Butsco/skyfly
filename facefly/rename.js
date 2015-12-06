var walk = require('walk');
var fs = require('fs');
var path = require('path');

var i=0;
walker = walk.walk("./ned_stark/", { followLinks: false });
walker.on("file", function(root, fileStat, next) {
  fs.rename(path.resolve(root, fileStat.name), path.resolve(root, i+".jpg"), function (err) {
    console.log("renamed " + path.resolve(root, fileStat.name));
    if (err) {
        console.error(err);
    }
    i++;
    next();
  });
});

//////////////////////////////////
// Read command line arguments  //
//////////////////////////////////

walker.on("end", function() {
  console.log("renamed " + i + " files.");
});