//
// Created by darK on 13-04-2017.
//

#include "MyCppClass.h"

#if defined(__GNUC__) && __GNUC__ >= 4
#   define MYCPPLIB_EXPORT __attribute__((visibility("default")))
#elif defined(__SUNPRO_C) && (__SUNPRO_C >= 0x590)
#   define MYCPPLIB_EXPORT __attribute__((visibility("default")))
#else
#   define MYCPPLIB_EXPORT
#endif

MYCPPLIB_EXPORT int MyCppClass::fourtyTwo()
{
    const auto result = 42;
    return result;
}

MYCPPLIB_EXPORT long double MyCppClass::factorial(int n)
{
    int counter;
    long double fact = 1;

    //for Loop Block
    for ( counter = 1; counter <= n; counter++)
    {
        fact = fact * counter;
    }

    return fact;
}