package javaChallenge;

import net.bytebuddy.build.Plugin.Engine.Source.Empty;

public class JavaChallengeDay1 {

	public int coldCoffeeBottles(int initialFullBottle, int noOfExchange) {

		int tempFullBott = initialFullBottle;
		int totaldrinks = initialFullBottle;
		int exFullBottle = 0, emptyBottle = 0;

		while (tempFullBott >= noOfExchange) {

			exFullBottle = (tempFullBott / noOfExchange);
			totaldrinks = totaldrinks + exFullBottle;

			if (tempFullBott % noOfExchange != 0) {

				emptyBottle = (tempFullBott % noOfExchange);

			}

			else {

				emptyBottle = 0;

			}

			tempFullBott = exFullBottle + emptyBottle;
		}
		return totaldrinks;

	}

	public static void main(String[] args) {

		int initialFullBottle = 9;
		int noOfExchange = 3;

		System.out.println("Number of full cold coffee bottles: " + initialFullBottle);
		System.out.println("Number of exchange:" + noOfExchange);

		JavaChallengeDay1 obj = new JavaChallengeDay1();

		System.out.println("Maximum number of cold coffee bottles: " + obj.coldCoffeeBottles(initialFullBottle, noOfExchange));
	}

}
