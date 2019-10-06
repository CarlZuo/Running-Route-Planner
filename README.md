# Running-Route-Planner
EC601-Team Project
Sprint 1

## Product Definition
### Product Mission
Design an app to help people design the running route depends on their favor options. 

### Target Users:
- The people who like to run but do not konw how to plan a route.
- The runner who want to follow others' runinng route.

### User Stories
- I, the fresh man in running, would like to know which kind of routes is healthy to me. (how long should I run depends on my height and weight).

- I, the man who often takes exercise, would like to customize running routes based on my favor (distance, begin and end location, incline or flat, included park or far away from road)

- I, as a fresh runner, I don't know how long is 5km and I want to figure out a 5 km long running route in the city

- I, as a runner with some healthy problem on knees, I would like the running route to be more solid rather than multiple dangerous downhills and uphills conditions

- I, the fitness coach/professional runner, would like to share my running routes so that people nearby. It not only will bring more fans with me, but also help people run correctly.

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

**Language:** Java, XML, JSON <br>
**DataBase:** MangoDB <br>
**Tools:** Android Studio <br>
**API:** Google Map API <br>

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

