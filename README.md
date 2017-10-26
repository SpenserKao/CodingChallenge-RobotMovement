# CodingChallenge-RobotMovement

## Installation
First, retrieve content. From GitHub, either use _git-clone_ or download zip file.<br/>
Refer to <a href="image/finding-url-or-zip-file.jpg">screenshot</a> to see how to (1) get url for git-cloning or (2) download zip file.

Then execute the command in following syntax to git-clone the content:<br/>
_git clone &lt;url&gt;_, <br/>
currently the url is https://github.com/SpenserKao/CodingChallenge-RobotMovement.git, <br/>
Or use an unzip tool, or the like, to extract downloaded zip file.
  
## Source
Once installed, change into directory _CodingChallenge-RobotMovement_ as working directory.<br/>
From the working directory, Java-based main source files can be found under _src/main/java/codechallenge/robotmovement_.<br/>
Correspondingly, JUnit-based test source files are under _src/test/java/codechallenge/robotmovement_.

## Test
### Unit test
   Usage: _Java -cp &lt;class search path of directories and zip/jar files&gt; &lt;Unit test class&gt;_<br/>
	Three unit test classes have been created: _PositionTest_, _TabletopTest_ and _RobotTest_.<br/>
	Without IDE, such as Eclipse or NetBeans, or building automation tool, such as Maven or Gradle, the simplest way of conducting unit test is going through command line, as examples shown follows:
	<pre>
	   * _java -cp robotmovement_unittest.jar;junit-4.8.2.jar org.junit.runner.JUnitCore codingchallenge.robotmovement.PositionTest_
	   * _java -cp robotmovement_unittest.jar;junit-4.8.2.jar org.junit.runner.JUnitCore codingchallenge.robotmovement.TabletopTest_
	   * _java -cp robotmovement_unittest.jar;junit-4.8.2.jar org.junit.runner.JUnitCore codingchallenge.robotmovement.RobotTest_
	</pre>
  **Note**: the above commands are for Windows environment; for Linux/Unix environment, be sure to replace classpath separator semicolon ';' with colon ':', 

### Intergration test
   Usage: _Java -jar &lt;jar file&gt; &lt;Command File&gt;_<br/>
	 Where, 
	 <pre>
		_&lt;jar file&gt;_ should be __robotmovement.jar__; and <br/>
		_&lt;Command File&gt;_ can find one of following three files for respective scenario:
		   * __movements_err1.txt__ - Error: Unrecognisable command 'LEFTTT'
		   * __movements_err2.txt__ - Error: Unrecognisable facing (direction) input info 'EASTTTT'
		   * __movements_err.txt__ - no anomaly	
	</pre>
  **Note**: by default, configuration file __ioof_robot.properties__ will be retrieved for four boundaries of tabletop. In the absence of the properties file, the boundaries will be defaulted to (5, 0, 5, 0).

