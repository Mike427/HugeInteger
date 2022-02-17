package com.company;

import static com.company.HugeInteger.*;

public class HugeIntegerTest {

    public static void main(String[] args) {
        HugeInteger int1 = new HugeInteger("77");
        HugeInteger int2 = new HugeInteger("544");


        System.out.printf("String 1 = %s, String 2 = %s%n", int1, int2);
        System.out.printf("Strings Added: %s%n", add(int1, int2));
        System.out.printf("Strings Subtracted: %s%n", subtract(int2, int1));
        System.out.printf("Sting 1 is equal to String 2: %b%n", isEqualTo(int1, int2));
        System.out.printf("Sting 1 is not equal to String 2: %b%n", isNotEqualTo(int1, int2));
        System.out.printf("Sting 1 is greater than String 2: %b%n", isGreaterThan(int1, int2));
        System.out.printf("Sting 1 is less than String 2: %b%n", isLessThan(int1, int2));
		System.out.printf("Sting 1 is greater than or equal to String 2: %b%n", isGreaterThanOrEqualTo(int1, int2));
		System.out.printf("Sting 1 zero: %b%n", isZero(int1));




	}
}
