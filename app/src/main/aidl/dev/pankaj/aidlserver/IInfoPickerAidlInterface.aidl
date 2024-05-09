// IInfoPickerAidlInterface.aidl
package dev.pankaj.aidlserver;

// Declare any non-default types here with import statements

interface IInfoPickerAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
     int getColor();
     String getAndroidOSInfo();

}