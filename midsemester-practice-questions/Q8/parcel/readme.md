
The given code realises the delivery process of a parcel from a sender in location `A` to a recipient in location `B`.
A successful delivery will sequentially go through the following four status:
* `Ordered` online
* `Registered` in a post office
* `Transferring` via the transport office
* `Delivered` to the designated recipient

Note that there is only `ONE` transport office so that a `singleton` instance is required.
There are three available options for the transport: `Airplane`, `Train`, `Ship` from A to B, where Cost(airplane) > Cost(train) > Cost(ship) for the same parcel:
* `Airplane` can transport a parcel with at maximum `20` (inclusive) weight units in `1` day.
* `Train` can transport a parcel in `3` days and has no limitation on the parcel weights
* `Ship` can transport a parcel in `7` days and has no limitation on the parcel weights

Note that the transport office is benefit-driven and will try to save the cost as much as possible. It will choose a transport based on `weight` and `allowedDays` properties of a parcel:
* `weight`: the weight of the parcel
* `allowedDays`: the maximum allowed days for the parcel to be delivered
* `sender`: the sender of the parcel
* `recipient`: the recipient of the parcel

For example, a parcel has 17 weight units and must be delivered in at most 4 days, then the transport office will choose the train to transport the parcel. If no transports meet the requirements of the parcel, then the parcel will be `Returned` to the sender. Note that the parcel will only be delivered if the recipient is the CORRECT one recorded in the parcel. Otherwise, the parcel will be returned.

Please refer to the test cases in `ParcelTest.java` for more details.

You are expected to complete:
* `transportBy()` and `getInstance()` methods in `TransportOffice.java` file
* `receive()` method in `Recipient.java` file

Upload `TransportOffice.java` and `Recipient.java` to Wattle for marking \[If this was a real exam\]. You are allowed to create helper methods in the required java classes. You are only allowed to implement your code in the designated area between "START YOUR CODE" and "END YOUR CODE". Some test cases are provided to assist your understanding, but it does not guarantee you will get full marks. Remember that we use different test cases to mark your solution. You are free to add your own test cases to increase your confidence that your solution is robust.
