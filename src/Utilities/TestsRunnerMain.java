package Utilities;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeEngines;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;

import org.junit.runner.RunWith;

import Tests.TriviaSanityTest;
import Tests.TriviaFunctionalityTest;
import Tests.TriviaErrorHandlingTest;
import Tests.TriviaBoundaryValuesTest;
import Tests.TriviaIntegrationTest;
import Tests.TriviaCompatibilityTest;

@RunWith(JUnitPlatform.class)
@ExcludeEngines("junit-vintage")
@SelectPackages("FinalProject.SVC")
@SuiteDisplayName("Trivia Automation Testing")
@SelectClasses({ TriviaSanityTest.class,
		TriviaFunctionalityTest.class,
		TriviaBoundaryValuesTest.class,
		TriviaErrorHandlingTest.class,
		TriviaIntegrationTest.class,
		TriviaCompatibilityTest.class,
})
public class TestsRunnerMain {
}