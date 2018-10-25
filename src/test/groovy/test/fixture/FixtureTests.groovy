package test.fixture

import spock.lang.Specification

class FixtureTests extends Specification {

  static Boolean firstTestPassed = false
  static Boolean setupFlag = false
  static Boolean cleanFlag = false
  static Boolean specFlag = false

  void setup() {
    setupFlag = true
  }

  void setupSpec() {
    specFlag = true
  }

  void cleanup() {
    cleanFlag = true
  }

  void "Setup should work"() {
    when: "fixture has been executed"
    firstTestPassed = true
    then: "setupFlag should be true"
    setupFlag
  }

  void "SetupSpec should work"() {
    when: "setupSpec has been executed"
    firstTestPassed = true
    then: "setupSpec should be true"
    specFlag
  }

  void "Cleanup should work"() {
    when: "cleanup has been executed"
    then: "cleanFlag should be true if not first test"
    firstTestPassed && cleanFlag
    cleanup:
    firstTestPassed = true
  }

  void "Cleanup should work Bis"() {
    when: "cleanup has been executed"
    then: "cleanFlag should be true if not first test"
    firstTestPassed && cleanFlag
    cleanup:
    firstTestPassed = true
  }

}
