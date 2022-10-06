## Q2 - Design Patterns & Coding Skills (25 marks)

The given code implements a quote calculator that compares the quotes offered by two express companies and gives the best quote
for delivery. The express companies offer quotes for a parcel delivery based on the integer `weight` of the parcel and the integer `distance` from the express companies to the parcels' destinations.

Each express company has a delivery radius, within which the companies offer quotes only based on the `weight` of the parcel. If the distance is greater than the radius, the companies charge additional fees for the distance based on the formula:
`AdditionalDistanceFees = ratePerDistanceUnit * Distance`

The distance between two integer points (x1, y1) and (x2, y2) can be calculated using the Euclidean distance formula:
`Distance = sqrt((x1-x2)^2 + (y1-y2)^2)`
where `sqrt` is square root operation, `^2` is the power of 2.
The express companies charge the distance fees based on the `round-up` distance values if the calculated distance is fractional. For example, if the calculated distance is 3.1, then round it up to 4 as the distance value.

The companies sets several weight intervals and each weight interval has a quote rate. The total quote is the sum of partial quotes of all the intervals, where the partial quote for each interval is proportional to the part of weight falling in that interval. For example, for the following quote scheme:

* 0 < weight <= q1: rate=r1
* q1 < weight <= q2: rate=r2

If the weight falls in the interval of (0, q1], the total quote should be `Q=weight * r1`.
If the weight falls in the interval of (q1, q2], the total quote should be `Q=q1 * r1 + (weight - q1) * r2`:

Here is the quote scheme of the express company A:

* 0 < weight <= 20kg: rate=$1.3
* 20kg < weight <= 40kg: rate=$1.7
* 40kg < weight <= 60kg: rate=$2.4
* weight > 60kg: rate=$3.2

Beyond the radius, the company A charges an extra (ratePerDistanceUnit=$1) for each distance unit.

Here is the quote scheme of the express company B:
Different from A, this company has a constant quote `$46` for weights that are no more than `30kg`. For weights higher than `30kg`, the strategy is the same as that of A, but with different rates and intervals.

* 0 < weight <= 30kg: quote is constant at $46
* 30kg < weight <= 40kg: rate=$1.5
* 40kg < weight <= 50kg: rate=$2.1
* 50kg < weight <= 60kg: rate=$2.9
* weight > 60kg: rate=$3.6

Beyond the radius, the company B charges an extra (ratePerDistanceUnit=$1.1) for each distance unit.

`QuoteCalculator` class has a `bestQuote()` method that compares the quotes of the two express companies and yields the best quote (the lower quote). The methods `calculateQuote()` in `CompanyA.java` and `CompanyB.java` are respectively intended to calculate the quotes of the two companies based on the above quote schemes. Note that if the quotes offered by two companies are equal, always choose the express `companyA`.

Moreover, the express companies have specific prohibited item list and need to perform a safety check on the items in parcels before calculating quotes. You are expected to throw an `IllegalParcelItemException` when there are any items prohibited by the companies.

Please refer to the given test cases in `ParcelTest.java` for more details.

`Please try your best to return a value for the required methods, e.g. 0 or null, to make sure your solutions do compile if you have trouble in providing the solutions. Otherwise, you may be subject to a mark loss due to compile errors.`


* * *
* * *

#### You are expected to complete:
* `calculateQuote()` method in the `CompanyA.java` class
* `calculateQuote()` method in the `CompanyB.java` class
* `bestQuote()` method in the `QuoteCalculator.java` class
* `calculateDistance()` and `safetyCheckOnItems()` in the `ExpressCompany.java` class

#### You are expected to Upload:
* `CompanyA.java`
* `CompanyB.java`
* `QuoteCalculator.java`
* `ExpressCompany.java`

You are allowed to create helper methods in the required java classes. Aside from creating those helper methods, you are only allowed to implement your code in the designated area between "YOUR CODE STARTS HERE" and "YOUR CODE ENDS HERE". Some test cases are provided to assist your understanding, but it does not guarantee you will get full marks. Remember that we use different test cases to mark your solution. You are free to add your own test cases to increase your confidence that your solution is robust.
