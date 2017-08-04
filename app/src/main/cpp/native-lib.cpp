#include <jni.h>
#include "opencv2/core.hpp"
#include "opencv2/highgui.hpp"
#include "opencv2/imgproc.hpp"


using namespace cv;
using namespace std;

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_mukit_omrlab_scanned_1img_stringFromJNI(JNIEnv *env, jobject instance,
                                                        jlong inputImage) {

    Mat &inMatImage = *(cv::Mat *) inputImage;

    cvtColor(inMatImage, inMatImage, cv::COLOR_BGR2GRAY);
//    resultArray.add(String.valueOf(count-1) + "//" + "marks" + "//" + "111");
        string msg="111//333//555";
    return env->NewStringUTF(msg.c_str());
}




