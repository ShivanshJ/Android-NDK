//
// Created by darK on 13-04-2017.
//
#include "com_example_mycompany_myndklibapp_MyNativeClass.h"

#include "../../../../MyNDKModule/src/main/cpp/MyCppLib/src/MyCppClass.h"

#ifdef __cplusplus
extern "C"
{
#endif

JNIEXPORT jint JNICALL Java_com_example_mycompany_myndklibapp_MyNativeClass_fourtyTwo
        (JNIEnv *, jclass)
{
    const auto result = MyCppClass::fourtyTwo(); // Call native method.
    return result;
}

JNIEXPORT jdouble JNICALL Java_com_example_mycompany_myndklibapp_MyNativeClass_factorial
        (JNIEnv *, jclass, jint fact)
{
    const auto result = MyCppClass::factorial(fact) ; // Call native method.
    return result;
}

#ifdef __cplusplus
}
#endif
