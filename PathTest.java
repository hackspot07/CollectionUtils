import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;


public class PathTest{
	@Test 
	public void pathWillReturnTrue()throws Exception{
		boolean getPathStatus  = Path.path("Bangalore","Singapore");
		assertEquals(getPathStatus,true);
	}
	@Test 
	public void pathWillReturnFalse()throws Exception{
		boolean getPathStatus  = Path.path("Bangalore","Seoul");
		assertEquals(getPathStatus,false);
	}
	@Test 
	public void pathWillReturnNocityAsGivenSource()throws Exception{
		try{
			Path.path("Mumbai","Seoul");
		}catch(Exception e){
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(), "No city Named Mumbai");
		}
	}
	@Test 
	public void pathWillReturnNocityAsGivenDestination()throws Exception{
		try{
			Path.path("Bangalore","Mumbai");
		}catch(Exception e){
			assertEquals(e.getMessage(), "No city Named Mumbai");
		}
	}
	@Test 
	public void pathWillReturntruewForSingaporeToDubai()throws Exception{
		boolean getPathStatus  = Path.path("Singapore","Dubai");
		assertEquals(getPathStatus,true);
	}
	@Test 
	public void pathWillReturntruewForSingaporeToSeoul()throws Exception{
		boolean getPathStatus  = Path.path("Singapore","Seoul");
		assertEquals(getPathStatus,true);
	}
	@Test 
	public void pathWillReturnTrueFromBangaloretoTokyo()throws Exception{
		boolean getPathStatus  = Path.path("Bangalore","Tokyo");
		assertEquals(getPathStatus,"true");
	}
};