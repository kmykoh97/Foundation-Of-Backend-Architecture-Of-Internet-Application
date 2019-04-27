# Resources Consumption Of REST Service

## Method

Get the detail of various endpoints using Spring Actuator

## Memory & CPU Usage

### Startup

![alt text](img/1.png)
![alt text](img/2.PNG)

40292573184 bytes ram usage
0% CPU utilised

### Importing Dictionary

![alt text](img/3.PNG)
![alt text](img/4.PNG)

40297500672 bytes ram usage
17% CPU utilised

### After Result

![alt text](img/5.PNG)
![alt text](img/6.PNG)

40296165375 bytes ram usage
19% CPU utilised

### Hooraay! Success

![alt text](img/7.PNG)

## Logical Explanation

- 0% CPU during startup due to Spring Boot doing all the backend in background and stop process automatically when not in use
- Increasing RAM usage when importing dictionary until getting dictionary because dictionary is imported and stored in computer memory as data structure. Data not dumped by system
- Decreasing CPU consumption in the end because Spring Security still running in background but dictionary importing and parsing has completed

## Special Thanks

Ren Rui from School Of Software Engineering, Shanghai Jiao tong University for guiding us throughout the session

## Author's Details

Meng Yit Koh 517030990022