
./ffmpeg -i s01e01/video/Game.of.Thrones.S01E09.Baelor.HDTV.XviD-FQM.avi -vb 5M -ss 00:50:50 -t 00:01:00 -c:a copy -c:v copy s01e01/video/cut.avi

./ffmpeg -i s01e01/video/Game.of.Thrones.S01E09.Baelor.HDTV.XviD-FQM.avi -ss 00:50:54 -t 00:01:00 -vf fps=25 s01e01/frames/%d.png

./ffmpeg -i s01e01/video/cut.avi -vf fps=2 s01e01/frames/%d.jpg


./ffmpeg -framerate 25 -i s01e01/output/%d.png -c:v libx264 -r 25 -pix_fmt yuv420p s01e01/out.mp4



curl -u "ba47c6d0-d027-412a-a20d-77c9ebd171c5":"AFapyyEy04bH" \
    -X POST \
    -F "images_file=@/Users/bert/Projects/skyfly/facefly/s01e01/faces/250_2.png" \
    "https://gateway.watsonplatform.net/visual-recognition-beta/api/v2/classify?version=2015-12-02"