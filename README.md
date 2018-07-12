



# Retro Game - _Amazing Snake_

## Team structure and roles 
+ Jiayan Liu u6107041 - team leader, help page code, morale builder
+ Yan Yang u6169130 - Android project building, code building, testing
+ Wei Xing u5656487 - create adapter and slide screen android code as introduction and level page (class of GuideActivity, LevelActivity, WelcomeActivity, VpAdapter), design UML Diagram
+ Zhiyong Sun u6123044 - Android project building, code building, testing

## Game Overview 

The game has three versions of difficulty. 
### Easy mode: 
The moving speed of snake will be faster and faster as step counts increases. 
### Hard mode: 
Snake will slough after a certain time period and its skin will be remaining in the gaming field for a certain amount of time. After snake molting the length of snake will halve. 
### Classes
+ Background - made of little squares of two different colours. 
+ Fruits - will appear on the gaming field randomly and have different colours. Each type of fruit has a special ability to buff the snake(Speed up, Speed down, Avatar, etc.). The fruit will also give a player bonus score. 
+ Snake - has a increasing speed as game steps increasing(The speed has limit). Its length increases if eats a fruit. Game changes to end state if snake hits  walls or its own body or molted skin. Changes direction as input indicates. 
+ Score box - increases as steps increases. It shows the highest score from last player and current changing score. adds a bonus score if a fruit has been eaten. 

## Design Documentation 
+ [Design Summary](designsummary)
+ [UML Diagram](umldiagram)
+ [Testing Summary](testingsummary)

## Minuted Meetings
+ [Meeting 1 - 1/4/2018 - decide team structure and game](meeting1)
+ [Meeting 2 - 5/4/2018 - divide up tasks](meeting2)
+ [Meeting 3 - 15/4/2018 - consider and plan extension aspects](meeting3)
+ [Meeting 4 - 30/4/2018 - review and practice demo](meeting4)
+ [Meeting 5 - 13/5/2018 - Conclusion of all the features of RetroGame](meeting5)
+ [Meeting 6 - 16/5/2018 - refract the code](meeting6)

## Reflection
The build of the structure is the most hard part we accomplished in this assignment. It is significant to have a very thoughtful and logical structure at the beginning or even before starting to build a project like the Snake we have. A good project should always start with a very detailed UML so that we know which part to implement individually and it will also be easier for us to test which part of the program has flaws or bug. On the other hand, the use of decorator and observer is quite important since that we will be able to design the game in a simpler approach, in other words, the bigger your project is the more necessary you would need decorator and observer. 

## Statement of Originality

I JIAYAN LIU declare that everything I have submitted in this
assignment is entirely my own work, with exceptions given below.

I Yan Yang declare that everything I have submitted in this
assignment is entirely my own work, with exceptions given below.

I Wei Xing declare that everything I have submitted in this
assignment is entirely my own work, with exceptions given below.
> 1. the idea and template of *Fragment Adapter*: https://developer.android.com/reference/android/support/v4/view/PagerAdapter
2. usage note of *Adapter*:  https://blog.csdn.net/zhaokaiqiang1992/article/details/22575757
3. the idea and template of *slide screen*: https://www.sitepoint.com/using-viewpager-to-create-a-sliding-screen-ui-in-android/
4. apply **ViewPager** to adapt image : https://developer.android.com/training/animation/screen-slide

I Zhiyong Sun declare that everything I have submitted in this
assignment is entirely my own work, with exceptions given below.

### Inspiration

_add references from where you obtained the idea form the game and ideas about aspects of the game_

### Code
1. the template of the *Adapter* in this assignment is from: https://developer.android.com/reference/android/support/v4/view/PagerAdapter
2. the template of the *slide screen* in this assignment is from: https://www.sitepoint.com/using-viewpager-to-create-a-sliding-screen-ui-in-android/

### Assets 

_this includes images, sounds, etc._
![Screenshot_1526622795](/uploads/d009308cff1499daa71a8ce4811b4022/Screenshot_1526622795.png)

![Screenshot_1526622763](/uploads/04c2690f24c496e824d0fc8a1c6fc1ec/Screenshot_1526622763.png)![Screenshot_1526622754]![Screenshot_1526622715](/uploads/af59137872c38855472c0756201d593d/Screenshot_1526622715.png)
