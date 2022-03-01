# Gravity Simulator Game

Follow [this](https://www.youtube.com/playlist?list=PL_QPQmz5C6WUF-pOQDsbsKbaBZqXj4qSq) playlist for graphics

Planet motion help: [link](https://www.youtube.com/watch?v=WTLPmUHTPqo). This is python, but the physics is about right

## To Do
1. Create sprites for rockets (png)
    * Accelerating sprite - animation for when rocket is accelerating
    * Decelerating sprite - animation for when rocket is decelerating
    * floating sprite - animation for when rocket is not using fuel
2. Create sprites for planets (png)
3. ~Add above mentioned sprites as image objects to rocket and planet instances~
4. ~Set window background to sky~
5. ~Implement fuel burning~
6. Implement GUI menu to choose between:
    * Scoreboard
    * Game
    * Exit
7. Create different planets and rockets in `PlanetCollection` and `RocketCollection`
8. Do something to update fuel level, points, distance, etc. in playframe
9. Drawing trajectories
10. Zooming/panning

## Scale stuff
* Position of rockets/planets --> AU
* Timestep --> 24 hours
* Scale --> Calculated during draw()
