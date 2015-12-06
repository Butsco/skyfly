#! /bin/bash

curl -u "USER":"PASS" \
     -X POST \
     -F "images_file=@/Users/sgillis/git/sky/scraper/watson/test/joffrey.jpg" \
    -F "classifier_ids=@/Users/sgillis/git/sky/images/classifierlist.json" \
     "https://gateway.watsonplatform.net/visual-recognition-beta/api/v2/classify?version=2015-12-02"
