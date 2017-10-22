# CodingChallenge-RobotMovement

## Installation
_git clone https://github.com/SpenserKao/CodingChallenge-RobotMovement.git_
  
## Source
Once installed, source files can be found under _src/main/java/codechallenge/robotmovement_.<br/>
Correspondingly, JUnit-based test source files are under _src/test/java/codechallenge/robotmovement_.

## Test
### Unit test
   Usage: _Java -cp &lt;class search path of directories and zip/jar files&gt; &lt;Unit test class &gt;_<br/>
	Three unit test classes have been created: _PositionTest_, _TabletopTest_ and _RobotTest_.<br/>
	The commands to execute the unit tests are as follows:
	<pre>
	      * _java -cp robotmovement_unittest.jar;junit-4.8.2.jar org.junit.runner.JUnitCore codechallenge.robotmovement.PositionTest_
	      * _java -cp robotmovement_unittest.jar;junit-4.8.2.jar org.junit.runner.JUnitCore codechallenge.robotmovement.TabletopTest_
	      * _java -cp robotmovement_unittest.jar;junit-4.8.2.jar org.junit.runner.JUnitCore codechallenge.robotmovement.RobotTest_
  	</pre>
  **Note**: To execute above commands in Linux/Unix environment, you should replace separator ';' with ':' in 

### Intergration test
   Usage: _Java -jar &lt;jar file&gt; &lt;Command File&gt;_<br/>
	 Where, 
	 <pre>
		_&lt;jar file&gt;_ should be __robotmovement.jar__; and
		_&lt;Command File&gt;_ can find one of following three files for respective scenario:
		   * __movements_err1.txt__ - Error: Unrecognisable command 'LEFTTT'
		   * __movements_err2.txt__ - Error: Unrecognisable facing (direction) input info 'EASTTTT'
		   * __movements_err.txt__ - no anomaly	
	</pre>
  **Note**: by default, configuration file __ioof_robot.properties__ will be retrieved for four default boundaries of tabletop.

