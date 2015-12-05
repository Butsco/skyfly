//
//  main.cpp
//  facefly
//
//  Created by Bert Wijnants on 05/12/15.
//  Copyright (c) 2015 butsco. All rights reserved.
//

#include <iostream>
#import <opencv2/opencv.hpp>
#include <unistd.h>
#include <stdio.h>
#include <errno.h>
#include <string>
#include <sstream>

using namespace std;
using namespace cv;

int main(int argc, char** argv)
{
    std::cout << "Init\n";
    
    stringstream ssIn;
    string framesDir = string("/Users/bert/Projects/skyfly/facefly/s01e01/frames/");
    string frameFilename = string("1313.png");
    ssIn << framesDir << frameFilename;
    string framePath = ssIn.str();
    
    std::cout << "framepath: " << framePath << "\n";
    
    stringstream ssOut;
    string outDir = string("/Users/bert/Projects/skyfly/facefly/s01e01/output/");
    ssOut << outDir << frameFilename;
    string outPath = ssOut.str();
    
    std::cout << "outPath: " << outPath << "\n";
    
    Mat src = imread(framePath, 1 );
    
    namedWindow(frameFilename, WINDOW_AUTOSIZE );
    imshow("Unprocessed Image",src);
    
    
    IplImage * pInpImg = 0;
    
    // Load an image from file - change this based on your image name
    pInpImg = cvLoadImage(framePath.c_str(), CV_LOAD_IMAGE_UNCHANGED);
    if(!pInpImg)
    {
        fprintf(stderr, "failed to load input image\n");
        return -1;
    }
    
    // Write the image to a file with a different name,
    // using a different image format -- .png instead of .jpg
    if( !cvSaveImage(outPath.c_str(), pInpImg) )
    {
        fprintf(stderr, "failed to write image file\n");
    }
    
    // Remember to free image memory after using it!
    cvReleaseImage(&pInpImg);
    
    return 0;
}