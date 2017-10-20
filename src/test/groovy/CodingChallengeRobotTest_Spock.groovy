package codingchallenge.robotmovement;

import spock.lang.*

/**
 * Copyright 2016 the original author or authors.
 * <h1>The Spock test script for CodingChallenge</h1>
 *
 * @author Spenser Kao (SpenserKao@optusnet.com.au)
 * @version 1.0
 * @since 2017-07-06
 * @see https://github.com/spockframework
 */
class CodingChallengeRobotTest_Spock extends Specification {	
	def @Shared Robot rob	// either static or @Shared will do
	def setupSpec() {

	}
	def cleanupSpec() {	
		rob = null
	}
	
	@Unroll ("Does default Robot constructor output following message? #outputMsg")
	def "test Constructor"() {	
		given: "test Constructor"
			rob = new Robot (new Tabletop(5, 0, 5, 0))
		expect:		
			rob.report() == outputMsg
		where:
			dummy | outputMsg
			'x' | 'Output: 0, 0, NORTH'
	} 
	
	@Unroll ("After command rob.place(3, 3, Facing.SOUTH), is it placed at following localation? #outputMsg")	
	def "test PlaceCommand"() {	
		given: "test PlaceCommand"
			rob = new Robot (new Tabletop(5, 0, 5, 0))
		expect:		
			rob.place(3, 3, Facing.SOUTH)
			rob.report() == outputMsg
		where:
			dummy | outputMsg
			'x' | 'Output: 3, 3, SOUTH'
	} 	
	
	@Unroll ("After command rob.right(), is it placed at following localation? #outputMsg")	
	def "test RightCommand"() {	
		given: "test RightCommand"
			rob = new Robot (new Tabletop(5, 0, 5, 0))
		expect:		
			rob.right()
			rob.report() == outputMsg
		where:
			dummy | outputMsg
			'x' | 'Output: 0, 0, EAST'
	} 	
	
	@Unroll ("After two commands of rob.right(), is it placed at following localation? #outputMsg")	
	def "test RightsCommands"() {	
		given: "test RightsCommands"
			rob = new Robot (new Tabletop(5, 0, 5, 0))
		expect:		
			rob.right()
			rob.right()
			rob.report() == outputMsg
		where:
			dummy | outputMsg
			'x' | 'Output: 0, 0, SOUTH'
	} 
	
	@Unroll ("After two commands of rob.left(), is it placed at following localation? #outputMsg")	
	def "test LeftsCommands"() {	
		given: "test LeftsCommands"
			rob = new Robot (new Tabletop(5, 0, 5, 0))
		expect:		
			rob.left()
			rob.left()
			rob.report() == outputMsg
		where:
			dummy | outputMsg
			'x' | 'Output: 0, 0, SOUTH'
	} 		

	@Unroll ("After command rob.move() from defaul position, is it placed at following localation? #outputMsg")	
	def "test MoveCommand"() {	
		given: "test MoveCommand"
			rob = new Robot (new Tabletop(5, 0, 5, 0))
		expect:		
			rob.move()
			rob.report() == outputMsg
		where:
			dummy | outputMsg
			'x' | 'Output: 0, 1, NORTH'
	} 	
}