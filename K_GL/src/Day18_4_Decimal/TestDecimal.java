package Day18_4_Decimal;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;

public class TestDecimal {
	@Test
	public void testBigInteger(){
		BigInteger bi = new BigInteger("12433241123");
		BigDecimal bd = new BigDecimal("12435.351");
		BigDecimal bd2 = new BigDecimal("11");
		System.out.println(bi);
		//System.out.println(bd.divide(bd2));
		System.out.println(bd.divide(bd2,BigDecimal.ROUND_HALF_UP));
		System.out.println(bd.divide(bd2,15,BigDecimal.ROUND_HALF_UP));
		}

}
