---------------------------------------------------------
**Prerequisites Configuration Changes**
---------------------------------------------------------

**1) Update Config.properties file**

&nbsp;&nbsp;&nbsp;&nbsp;>>> Go to src/main folder under your project
&nbsp;&nbsp;&nbsp;&nbsp;>>> Open config.properties file
&nbsp;&nbsp;&nbsp;&nbsp;>>> Update required properties based on your project need
&nbsp;&nbsp;&nbsp;&nbsp;*e.g.* browser, baseURL, username, password etc

**2) Update EmailConfig.properties file**

&nbsp;&nbsp;&nbsp;&nbsp;>>> Go to src/main folder under your project
&nbsp;&nbsp;&nbsp;&nbsp;>>> Open emailConfig.properties file
&nbsp;&nbsp;&nbsp;&nbsp;>>> Update required properties based on your project need 
&nbsp;&nbsp;&nbsp;&nbsp;*e.g.* senderEmail, senderPassword, fromEmail, toEmail, emailSubject, projectName, executionReport (executionReport: must contains .html extension)

**PS:** senderPassword should be 16 digit encrypted password which you can get from **GMail >> Security >> Two Factor Authentication >> App Password**

**3) Update JAR Dependencies**
&nbsp;&nbsp;&nbsp;&nbsp;>>> Select Project > Right Click > Select 'Run As' > Maven Clean
&nbsp;&nbsp;&nbsp;&nbsp;>>> Select Project > Right Click > Select 'Maven' > Update Project

---------------------------------------------------------
**Default Java Version**
---------------------------------------------------------
Make sure in your machine JRE11 or later installed and set as Default under **Windows >> Preferences >> Java >> Installed JREs.** as we are using **JRE version 11** to compile few of latest third-party dependencies in our POM.xml 

---------------------------------------------------------
**How to run the Project?**
---------------------------------------------------------

**First Approach**:
&nbsp;&nbsp;&nbsp;&nbsp;1) Select the testng.xml file under the project
&nbsp;&nbsp;&nbsp;&nbsp;2) Right click and select option Run As >> TestNG

**Second Approach**:
&nbsp;&nbsp;&nbsp;&nbsp;1) Right click on project
&nbsp;&nbsp;&nbsp;&nbsp;2) Run As >> Run Configuration >> Maven Run >> Create new run 
&nbsp;&nbsp;&nbsp;&nbsp;3) Give name as ClearlyRatedSuite
&nbsp;&nbsp;&nbsp;&nbsp;4) Select directory as ClearlyRated Project workspace 
&nbsp;&nbsp;&nbsp;&nbsp;5) Add goal as clean verify for Maven project >> click on Apply and run Button