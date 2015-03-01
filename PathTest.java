import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;


public class PathTest{
	@Test 
	public void pathWillReturnTrue(){
		String getPathStatus  = Directpath.path("Bangalore","Singapore");
		assertEquals(getPathStatus,"true");
	}
	@Test 
	public void pathWillReturnFalse(){
		String getPathStatus  = Directpath.path("Bangalore","Seoul");
		assertEquals(getPathStatus,"false");
	}
	@Test 
	public void pathWillReturnNocityAsGivenSource(){
		String getPathStatus  = Directpath.path("Mumbai","Seoul");
		assertEquals(getPathStatus,"no source city");
	}
	@Test 
	public void pathWillReturnNocityAsGivenDestination(){
		String getPathStatus  = Directpath.path("Bangalore","Mumbai");
		assertEquals(getPathStatus,"no dst city");
	}
};