package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HugeInteger {

    private int[] intArray;

    private int numDigits;  // stores the number of digits in intArray


    public HugeInteger(String s) {

        intArray = new int[40];

        numDigits = 0;

        parse(s);// call parse(s)

    }


    public HugeInteger() {

        intArray = new int[40];

        numDigits = 0;

    }


    public void parse(String s) {

        // number of digits in string
        int numLength = s.length();
        int digitIndexInString = numLength - 1;
        for (int arrayIndex = (intArray.length) - 1; arrayIndex >= (intArray.length - numLength); arrayIndex--) {
            char charDigit = s.charAt(digitIndexInString);
            int digit = Character.digit(charDigit, 10);
            intArray[arrayIndex] = digit;
            digitIndexInString--;
        }
        // Add each digit to the arrays

        numDigits = digitIndexInString;// update numDigits

    }


    public static HugeInteger add(HugeInteger hugeInt1, HugeInteger hugeInt2) {

        HugeInteger hugeInt3 = new HugeInteger();// Create hugeInt3
        int number = 0;
        for (int i = Array.getLength(hugeInt1.intArray) - 1; i >= 0; i--) {
            number = hugeInt1.intArray[i] + hugeInt2.intArray[i];
            if (number >= 10) {
                hugeInt3.intArray[i] += number % 10;
                hugeInt3.intArray[--i] += 1;
                i++;
            } else {
                hugeInt3.intArray[i] += number;
            }
        }
        return hugeInt3;// return hugeInt3
    }


    public static HugeInteger subtract(HugeInteger hugeInt1, HugeInteger hugeInt2) {

        HugeInteger hugeInt3 = new HugeInteger(); // Create hugeInt3
        int remainder = 0;
        for (int i = Array.getLength(hugeInt1.intArray) - 1; i >= 0; i--) {
            if ((hugeInt1.intArray[i] -remainder)- hugeInt2.intArray[i] < 0) {
                hugeInt3.intArray[i]= (10 + hugeInt1.intArray[i] -remainder)- hugeInt2.intArray[i];
                remainder = 1;
            }else {
                hugeInt3.intArray[i] = (hugeInt1.intArray[i] -remainder)- hugeInt2.intArray[i];
                remainder = 0;
            }

        }
        return hugeInt3;// return hugeInt3

    }


    public static boolean isEqualTo(HugeInteger hugeInt1, HugeInteger hugeInt2) {
        boolean isEqual = true;
        for (int i = Array.getLength(hugeInt1.intArray) - 1; i >= 0; i--) {
            if (hugeInt1.intArray[i] == hugeInt2.intArray[i]) {
                isEqual = true;
            } else {
                isEqual = false;
                break;
            }
        }
        return isEqual;

    }


    public static boolean isNotEqualTo(HugeInteger hugeInt1, HugeInteger hugeInt2) {

        boolean isNotEqual = false;
        for (int i = Array.getLength(hugeInt1.intArray) - 1; i >= 0; i--) {
            if (hugeInt1.intArray[i] != hugeInt2.intArray[i]) {
                isNotEqual = true;
                break;
            } else {
                isNotEqual = false;
            }
        }
        return isNotEqual;
        // return true if the value represented by

        // elements of hugeInt1.intArray is not equal to

        // value represented by elements of hughInt2.intArray


    }


    public static boolean isGreaterThan(HugeInteger hugeInt1, HugeInteger hugeInt2) {

        int array1 = 0;
        int array2 = 0;
        int value = 1;
        for (int i = Array.getLength(hugeInt1.intArray) - 1; i >= 0; i--) {
            if (hugeInt1.intArray[i] == 0 && hugeInt2.intArray[i] == 0) {
                continue;
            } else if (hugeInt1.intArray[i] > hugeInt2.intArray[i]) {
                array1 = value;
            } else {
                array2 = value;
            }
            value++;
        }
        if (array1 > array2) {
            return true;
        } else {
            return false;
        }

    }


    public static boolean isLessThan(HugeInteger hugeInt1, HugeInteger hugeInt2) {

        int array1 = 0;
        int array2 = 0;
        int value = 1;
        for (int i = Array.getLength(hugeInt1.intArray) - 1; i >= 0; i--) {
            if (hugeInt1.intArray[i] == 0 && hugeInt2.intArray[i] == 0) {
                continue;
            } else if (hugeInt1.intArray[i] == hugeInt2.intArray[i]) {
                continue;
            } else if (hugeInt1.intArray[i] < hugeInt2.intArray[i]) {
                array2 = value;
            } else {
                array1 = value;
            }
            value++;
        }
        if (array1 < array2) {
            return true;
        } else {
            return false;
        }

    }


    public static boolean isGreaterThanOrEqualTo(HugeInteger hugeInt1, HugeInteger hugeInt2) {

        int array1 = 0;
        int array2 = 0;
        int value = 0;
        for (int i = Array.getLength(hugeInt1.intArray) - 1; i >= 0; i--) {
            if (hugeInt1.intArray[i] == 0 && hugeInt2.intArray[i] == 0) {
                continue;
            } else if (hugeInt1.intArray[i] >= hugeInt2.intArray[i]) {
                array1 = value;
            } else {
                array2 = value;
            }
            value++;
        }
        if (array1 >= array2) {
            return true;
        } else {
            return false;
        } // return true if the value represented by

        // elements of hugeInt1.intArray is greater than or equal to

        // value represented by elements of hughInt2.intArray

    }


    public static boolean isZero(HugeInteger hugeInt1) {

        boolean isZero = true;
        int numberOfZeros = 0;
        for (int i = Array.getLength(hugeInt1.intArray) - 1; i >= 0; i--) {
            if (hugeInt1.intArray[i] == 0) {
                numberOfZeros++;
            }
        }
        if (numberOfZeros > 0) {
            return false;
        } else {
            return true;
        }
        //return isZero;
        // return true if the value represented by

        // elements of hugeInt1.intArray is 0
    }

    @Override
    public String toString() {
        String numberString = "";
        for (int i : intArray) {
            numberString += i;
        }
        return removeZero(numberString);// return string representation of this object

    }

    private static String removeZero(String numberString) {
        int i = 0;
        while (i < numberString.length() && numberString.charAt(i) == '0') {
            i++;
        }

        StringBuilder sb = new StringBuilder(numberString);

        sb.replace(0, i, "");
        return sb.toString();
    }


}
