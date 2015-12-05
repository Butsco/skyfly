//
//  main.cpp
//  facefly
//
//  Created by Bert Wijnants on 05/12/15.
//  Copyright (c) 2015 butsco. All rights reserved.
//

#include <iostream>
#import <opencv2/opencv.hpp>
#include <opencv2/highgui/highgui.hpp>
#include <unistd.h>
#include <stdio.h>
#include <errno.h>
#include <string>
#include <sstream>

using namespace std;
using namespace cv;

int main(int argc, char** argv)
{
    cout << "Init\n";
    
    stringstream ssIn;
    string framesDir = string("/Users/bert/Projects/skyfly/facefly/s01e01/frames/");
    string frameFilename = string("1313.png");
    ssIn << framesDir << frameFilename;
    string framePath = ssIn.str();
    
    cout << "frame: " << frameFilename << "\n";
    //cout << "framepath: " << framePath << "\n";
    
    stringstream ssOut;
    string outDir = string("/Users/bert/Projects/skyfly/facefly/s01e01/output/");
    ssOut << outDir << frameFilename;
    string outPath = ssOut.str();
    
    const char* cascadeFile = "/Users/bert/Projects/opencv-3.0.0/data/haarcascades/haarcascade_frontalface_default.xml";
    
    //cout << "outPath: " << outPath << "\n";
    
    Mat src = imread(framePath, 1 );
    Mat grey;
    cvtColor(src, grey, COLOR_BGR2GRAY);
    
    vector<Rect> faces;
    
    CascadeClassifier faceCascade = CascadeClassifier(cascadeFile);
    faceCascade.detectMultiScale(grey, faces, 1.1, 5, CV_HAAR_SCALE_IMAGE, Size(30, 30));
    
    printf("%zd face(s) are found.\n", faces.size());
    
    for (int i = 0; i < faces.size(); i++) {
        Rect r = faces[i];
        printf("a face is found at Rect(%d,%d,%d,%d).\n", r.x, r.y, r.width, r.height);
    }
    
    imwrite(outPath, grey);
    
    namedWindow(frameFilename, WINDOW_AUTOSIZE );
    imshow("Unprocessed Image",grey);
    waitKey(0);
    
    return 0;
}