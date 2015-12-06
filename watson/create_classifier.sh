#! /bin/bash

curl -u "USER":"PASS" \
     -X POST \
     -F "positive_examples=@/Users/sgillis/git/sky/scraper/watson/sansa_faces.zip" \
     -F "negative_examples=@/Users/sgillis/git/sky/scraper/watson/sansa_negative.zip" \
     -F "name=sansa" \
     "https://gateway.watsonplatform.net/visual-recognition-beta/api/v2/classifiers?version=2015-12-02"
