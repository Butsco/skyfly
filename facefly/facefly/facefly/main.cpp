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
    
    //cout << "outPath: " << outPath << "\n";
    
    Mat src = imread(framePath, 1 );
    
    imwrite(outPath, src);
    
    namedWindow(frameFilename, WINDOW_AUTOSIZE );
    imshow("Unprocessed Image",src);
    waitKey(0);
    
    return 0;
}