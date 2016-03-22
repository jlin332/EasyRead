# EasyRead
CapitalOne Coding Challenge 2016

EasyRead is a simple android app that allows the user to input a URL link of a news article that they would like to summarize
and get key concepts for the article. 

Currently the app is incomplete due to issue with running the java API with Aylien and Android Studio Runtime. Android Studio does not run JAXB during Runtime and Aylien heavily relies on JAXB to text process. 

In the future, I will be able to solve this issue given more time. I did not decide to use another API because I believe Aylien is a very suitable API for this task. I would just need more experience and time to figure out a solution. The app is set up currently with how the app would be expected to look like when it is fully functional for this article: http://techcrunch.com/2015/04/06/john-oliver-just-changed-the-surveillance-reform-debate/

Many lines of my code are marked with "UNCOMMENT WHEN WORKING." Those lines are used to call the Aylien API and process the text of the article.

##ScreenShots of App
HomePage:
https://cloud.githubusercontent.com/assets/16415839/13936641/7299bad6-ef95-11e5-9505-50137735d8ec.JPG

Article Summarized Page:
https://cloud.githubusercontent.com/assets/16415839/13936786/92101490-ef96-11e5-9e74-20a260bd261b.JPG

## Usuage
Clone this repository using Git with this link https://github.com/jlin332/EasyRead.git

Make Sure you have GIT downloaded: https://git-scm.com/downloads

###Android Studio
1. Import the Project using: **Check Out Project From Version Control
2. Choose GITHUB
3. Enter in the GIT repository link provided above, and Choose which directory to put the project in
4. Click Clone and now you have the Project
5. Run the Project on an emulator such as Nexus 6, if you have no virtual devices set up here is a link on how to do it: https://www.youtube.com/watch?v=O3UuUUXuOu4

###APK
1. Link for Programs that open APK file: http://fileinfo.com/extension/apk

*Prefer the Android Studio method*

## History

Made for CapitalOne Coding Challenge in order to get into Summer Software Engineering Summit.

## Credits

Created by John Lin, Freshamn Year, Georgia Tech Class of 2019
