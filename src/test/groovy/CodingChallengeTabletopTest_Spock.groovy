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
class CodingChallengeTabletopTest_Spock extends Specification {	
	def @Shared Tabletop tt	// either static or @Shared will do
	def setupSpec() {

	}
	def cleanupSpec() {	
		tt = null
	}
	
	@Unroll ("Test Constructor Boundaries")
	def "test Constructor Boundaries"() {	
		when: 
			tt = new Tabletop(5, 0, 5, 0)
		then:		
			tt.getNorthBound() == 5
			tt.getSouthBound() == 0
			tt.getEastBound() == 5
			tt.getWestBound() == 0			
	} 
	
	@Unroll ("Does following point fall inBounds tabletop's boundaries? (#posX, #posY)")
	def "test if points are within tabletop's boundaries"() {	
		given: "test inBounds boundaries"
			tt = new Tabletop(5, 0, 5, 0)
		expect:		
			tt.inBounds(posX, posY) == result
		where:
			posX | posY | result			
			3 | 3 | true
			0 | 0 | true
			0 | 4 | true
			4 | 0 | true
			4 | 4 | true			
	} 	
	
	@Unroll ("Does following point fall outside tabletop's boundaries? (#posX, #posY)")
	def "test if points are outside tabletop's boundaries"() {	
		given: "test outside boundaries"
			tt = new Tabletop(5, 0, 5, 0)
		expect:		
			tt.inBounds(posX, posY) == result
		where:
			posX | posY | result			
			5 | 6 | false
			6 | 5 | false
			-2 | 0 | false
			0 | -2 | false			
	} 	
}