# Running-Route-Planner
EC601-Team Project<br>
Ganghao Li, Ting Zhang, Hao Zuo<br>
Sprint 1

## Product Definition
### Product Mission
Design an app to help people have the running route depends on their favor options. 

### Target Users:
- The people who like to run but do not know how to plan a route.
- The runner who want to follow others' running route.

### User Stories
- I, the fresh man in running, would like to know which kind of routes is healthy to me. (how long should I run depends on my height and weight).

- I, the man who often takes exercise, would like to customize running routes based on my favor (distance, begin and end location, incline or flat, included park or far away from road)

- I, as a fresh runner, I don't know how long is 5km and I want to figure out a 5 km long running route in the city

- I, as a runner with some healthy problem on knees, I would like the running route to be more solid rather than multiple dangerous downhills and uphills conditions

- I, the fitness coach/professional runner, would like to share my running routes so that can benefit people nearby. It not only will bring more fans with me, but also help people run correctly.

- I, the normal runner, just want mimic friends,  famous people and coach fitness running routes, to get the similar routes as theirs.

### MVP
Minimum Viable Product
- Locate user position -- Google Map API
- Planning Running Route -- Design algorithm to apply the valuable route(or give some options etc), route can be a cycle and using the ranking

Other targets can be considered:
- Mimic friends route 
- Track user running
- Record everyday training
- Give real-time data to the user

### User Interface Design for main user story if required

## Product Survey

### Existing similar products
![MapMyFitness](https://github.com/CarlZuo/Running-Route-Planner/blob/master/Images/MapMyFitness.png)
#### MapMyFitness
##### Advantages:
- Using Google map to track and record users' route with distance, time, altitude and speed.
- Users can store and share their routes with app community members
- The app could recommend the recent routes which shared by community members to the users
- The app could give the feedback to user by analyzing their heart beat rate
##### Disadvantages:
- It doesn't show up famous routes for users to mimic
- It couldn't have multiple choices for users to choose, such as, weight control running with large undulating terrain and fitness running with uniform speed
##### Technologies:
- Google Map API
- Android Studio
- Mongo DB
![RunKeeper](https://github.com/CarlZuo/Running-Route-Planner/blob/master/Images/RunKeeper.png)
#### RunKeeper
##### Advantages:
- Check real-time fitness data such as speed, distance, time and consumed calories with voice prompts
- playing users favourite music when they running
- taking photos of current routes and share them with your friends
- reminder to new plan messages and assign new fitness plan
- followers could see the real-time route when you are running
##### Disadvantages:
- It couldn't see others complete routes
- It couldn't mimic famous route or compete with friends
- It couldn't give the details of route which contains how many mountains or how many easy pathes
##### Technologies:
- Google Map API
- Android Studio
- Mongo DB

### Patent Analysis
- **Integrated journey planner:** A method of providing journey information to a user comprises receiving unique location reference information identifying the start and end locations of the user-defined journey and considering at least some possible predetermined pairs of access points to a transport network of a single mode of transport, the access points being at different locations than the start and end locations.
https://patents.google.com/patent/EP1939802A2/en


## System Design

### Major Components you think you will use
![image](https://github.com/CarlZuo/Running-Route-Planner/blob/master/Images/fit_diagram.jpg)

### Technology Selection and reason behind selection including comparisons

**Tools:** Android Studio <br>
**Language:** Java, XML, JSON <br>
The java language is an object-oriented language and it is useful for App development on Android Studio.<br>
JSON has great advantages in executing the data in database.<br>
**DataBase:** MongoDB <br>
MongoDB is a useful open source database good for student studying and development.<br>
**API:** Google Map API <br>
Google Map API Platform is a useful open source location map platform and we could fetch the location data on it easily.<br>
![UI](https://github.com/CarlZuo/Running-Route-Planner/blob/master/Images/UI.png)
### Any test or verification programs
If we enter the distance into program, I will get the routes whose distance is similar as I entered, on the UI of APP.  

## Administrative

### Project Lead: 
Sprint presentation for the class
Handover to Sprint 2 project lead

### Sprint 2 Project Lead:
Sprint 2 plan and assignments
- Finish the code in basic function which can plan route based on distance.
- Add extra function code which can allow the user to mimic others.
- design test code
# Sprint2

## System Design Progress

![first](https://github.com/CarlZuo/Running-Route-Planner/blob/master/Images/first.jpg)

![second](https://github.com/CarlZuo/Running-Route-Planner/blob/master/Images/second.jpg)

The pictures above show the progress we made in the sprint2. Until now we have finished the implementation of three main activities in the app development: Main Activity which contains the logic data deliver, Preference Activity which contains the input UI and record of the input data, and Google Map Activity which call the Google Map API. Also, we have take a try about the database in another app platform and decided to use the MySQL to store the running data. Currently, we could get the location of the runner and store their input in the preference UI.

### Architecture Progress

![architecture1](https://github.com/CarlZuo/Running-Route-Planner/blob/master/Images/system1.jpg)

![s2](https://github.com/CarlZuo/Running-Route-Planner/blob/master/Images/system2.jpg)

### Component Decision

#### Android Studio App User Interface:
	
Easy to access the location thanks to the Android Mobile;

Can implement several activities and services which could divide input/output, display screen and routing algorithm separately;

#### Google Map API:
	
Functions of locating and calculating the distance;

The library “polyline” provided by Google Map API helps to draw out the route and record the runner’s running track;

#### Database:
	
Since the data record of runners’ route cannot be so large, thus we think MySQL is good and enough to store the log data of running;

## App Download and User Instruction:

https://drive.google.com/drive/folders/1HPkQRUwA1bq0IvojExLg9mb5Fyn7Aaf_?usp=sharing



