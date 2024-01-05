---------------------------------------------------------
**Prerequisites Configuration Changes**
---------------------------------------------------------

**1) Update Config.properties file**

&nbsp;&nbsp;&nbsp;&nbsp;>>> Go to src/main folder under your project <br />  
&nbsp;&nbsp;&nbsp;&nbsp;>>> Open config.properties file<br />
&nbsp;&nbsp;&nbsp;&nbsp;>>> Update required properties based on your project need<br />
&nbsp;&nbsp;&nbsp;&nbsp;*e.g.* browser, baseURL, username, password etc<br />

**2) Update EmailConfig.properties file**

&nbsp;&nbsp;&nbsp;&nbsp;>>> Go to src/main folder under your project<br />
&nbsp;&nbsp;&nbsp;&nbsp;>>> Open emailConfig.properties file<br />
&nbsp;&nbsp;&nbsp;&nbsp;>>> Update required properties based on your project need <br />
&nbsp;&nbsp;&nbsp;&nbsp;*e.g.* senderEmail, senderPassword, fromEmail, toEmail, emailSubject, projectName, executionReport (executionReport: must contains .html extension)<br />

**PS:** senderPassword should be 16 digit encrypted password which you can get from **GMail >> Security >> Two Factor Authentication >> App Password**<br />

**3) Update JAR Dependencies**<br />
&nbsp;&nbsp;&nbsp;&nbsp;>>> Select Project > Right Click > Select 'Run As' > Maven Clean<br />
&nbsp;&nbsp;&nbsp;&nbsp;>>> Select Project > Right Click > Select 'Maven' > Update Project<br />

---------------------------------------------------------
**Default Java Version**
---------------------------------------------------------
Make sure in your machine JRE11 or later installed and set as Default under **Windows >> Preferences >> Java >> Installed JREs.** as we are using **JRE version 11** to compile few of latest third-party dependencies in our POM.xml <br />

---------------------------------------------------------
**How to run the Project?**
---------------------------------------------------------

**First Approach**:<br />
&nbsp;&nbsp;&nbsp;&nbsp;1) Select the testng.xml file under the project<br />
&nbsp;&nbsp;&nbsp;&nbsp;2) Right click and select option Run As >> TestNG<br />

**Second Approach**:<br />
&nbsp;&nbsp;&nbsp;&nbsp;1) Right click on project<br />
&nbsp;&nbsp;&nbsp;&nbsp;2) Run As >> Run Configuration >> Maven Run >> Create new run <br />
&nbsp;&nbsp;&nbsp;&nbsp;3) Give name as ClearlyRatedSuite<br />
&nbsp;&nbsp;&nbsp;&nbsp;4) Select directory as ClearlyRated Project workspace<br /> 
&nbsp;&nbsp;&nbsp;&nbsp;5) Add goal as clean verify for Maven project >> click on Apply and run Button<br />