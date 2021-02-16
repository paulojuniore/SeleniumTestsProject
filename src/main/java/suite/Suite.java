package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import tests.AccountTest;
import tests.BalanceTest;
import tests.MovementTest;
import tests.RemoveMovementAccountTest;
import tests.ResumeTest;

@RunWith(org.junit.runners.Suite.class)
@SuiteClasses({
	AccountTest.class,
	MovementTest.class,
	RemoveMovementAccountTest.class,
	BalanceTest.class,
	ResumeTest.class
})
public class Suite {

}
