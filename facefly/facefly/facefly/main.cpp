//
//  main.cpp
//  facefly
//
//  Created by Bert Wijnants on 05/12/15.
//  Copyright (c) 2015 butsco. All rights reserved.
//
#include "main.hpp"
#include <opencv2/opencv.hpp>
#include <opencv2/highgui/highgui.hpp>
#include <unistd.h>
#include <stdio.h>
#include <errno.h>
#include <string>
#include <sstream>

using namespace std;
using namespace cv;

const char* cascadeFile = "/Users/bert/Projects/opencv-3.0.0/data/haarcascades/haarcascade_frontalface_default.xml";

const char* frameDir = "/Users/bert/Projects/skyfly/facefly/s01e01/frames/";
const char* outDir = "/Users/bert/Projects/skyfly/facefly/s01e01/output/";


CascadeClassifier faceCascade;

Mat src;
Mat grey;
Mat output;

int main(int argc, char** argv)
{
    cout << "Init\n";
    faceCascade = CascadeClassifier(cascadeFile);
    
    for (int i=1; i<=3017; i++) {
        processFrame(i, false);
    }
    
    return 0;
}

void processFrame(int frameId, bool display) {
    char framePath[150];
    char outPath[150];
    sprintf(framePath, "%s%d.png", frameDir, frameId);
    sprintf(outPath, "%s%d.png", outDir, frameId);
    
    //cout << "frame: " << framePath << "\n";
    
    src = imread(framePath, 1);
    cvtColor(src, grey, COLOR_BGR2GRAY);
    
    vector<Rect> faces;
    
    faceCascade.detectMultiScale(grey, faces, 1.1, 5, CV_HAAR_SCALE_IMAGE, Size(30, 30));
    
    printf("frame %d: %zd faces.\n", frameId, faces.size());
    
    if (faces.size() > 0) {
        output = src.clone();
        
        for (int i = 0; i < faces.size(); i++) {
            Rect r = faces[i];
            //printf("a face is found at Rect(%d,%d,%d,%d).\n", r.x, r.y, r.width, r.height);
            
            rectangle(output,
                      Point(r.x, r.y),
                      Point(r.x+r.width, r.y+r.height),
                      CV_RGB(255,0,0),
                      2
                      );
        }
        
        imwrite(outPath, output);
        
        if (display) {
            namedWindow(framePath, WINDOW_AUTOSIZE );
            imshow(framePath, output);
            waitKey(0);
        }
    }
}