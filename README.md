# parker

This app helps to find where the car is parked.<br><br>
Following are the technologies used<br>
-Test framework - TestNG<br>
-Build tool - Gradle<br> 
-Report Generator - ReportNG

## Stories completed

1. Park car at current location
2. Drive to ​“Indoor Stadium”​ and carParking the car.
3. Look for recent parking history.
4. Set your current location to “California” and filter for a parking spot.
5. Disable notifications and carParking car.
6. Verifying car is parked in landscape mode.
7. Once the car is parked, sending the app to the background, once it is active unparking the car.
8. Park car kill and launch the app and verify unpark.

## Features
Capture screenshots on failure<br/>

## Steps to clone and execute the tests
```$xslt
// Clone the repository
$ git clone https://github.com/bhoomikag203/parker
$ cd parker
```
```$xslt
// Start the appium server either in desktop app or from terminal
$ appium
```
Connect your mobile device and enable USB debugging
```$xslt
// Check for devices connected to your system
$ adb devices
// Change the "deviceName" in config.properties to the connected device name
```
```$xslt
// Execute below commands in your project directory
$ gradle build
$ gradle runTests 
```
