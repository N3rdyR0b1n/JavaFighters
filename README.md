# Java Fighters Readme:
Notes:
- Misha : Maradenskopf
- Niels : N3rdyR0b1n

Advanced topic 1: written by Misha

Advanced topic 2: written by Niels
# Advanced topic 2 : Jar File Creation (maven)
Our first advanced topic is Maven Configuration tool, which we used to assemble our project into am executable .jar file, which will allow it to be run from any desktop device that has Java installed on it.

## Maven build configuration:
During this research we have learned how to create and configure project using Maven framework, which helped us build an executable .jar file that can be run outside of IDE and on any device that has Java installed. Together with resource files, such as textures and audio files, that are placed outside of .jar file, we can create a user friendly way of running our game for any user.

## Why do we have and archive instead of single executable .jar?
.jar file is an archive that contains executable code and other files that are created during compilation of project. Among these files there also can be resources like images or audio files. Because when our game is running we need to access said resources a lot, accessing them from withing archive would be much harder. For this reason we have located them in folder, from where they can be accessed much easier.

## Sources I used to learn Maven:
https://www.baeldung.com/executable-jar-with-maven#thymeleaf-1
https://www.baeldung.com/maven
https://maven.apache.org/what-is-maven.html


# Advanced topic 2 : Version control tool (git)
For our second advanced topic we decided to use a version control tool both for the sake of learning an advanced subject as well as making the development of the project's code a lot easier. It allowed us to do the following:

## Make changes to the project asynchronously
While i was working on the code for one feature Misha could work on the other. When done we would commit the changes to the main branch. Despite the option for multiple branches in git, we never needed them that much.

## Keep track of features in each commit
All commits made to the project have a small description and note the user who made them so we know what is added and by whom. Allowing us to clearly see who is responsible for implementing which features, this means that we know who to ask for explanation on how or why something works (if it doesn't).

## Easy backups
Because all code was on github, my device and misha's device. We had multiple backups in case data got corrupted. We could also roll back to previous versions in case an update breaks the application. (Which i had to do after messing the project once, resulting in me re-pulling from git)
