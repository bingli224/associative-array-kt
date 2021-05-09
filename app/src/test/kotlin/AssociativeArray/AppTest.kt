/*
 * AssociativeArray
 * 
 * Space: O(n)
 * Time: O(n)
 * 
 * @author  BingLi224 <bingli224@gmail.com>
 * @since   2021-05-09
 */
package AssociativeArray

import kotlin.test.Test
import kotlin.test.assertEquals

class AppTest {
    @Test fun givenAllIn_whenCallsCountMaxPair_thenReturnsAll ( ) {
        val init = intArrayOf (1, 2, 1)
        val expect = 3
        
        assertEquals ( expect, countMaxPair ( init ) )
    }

    @Test fun givenWithNewPair_whenCallsCountMaxPair_thenReturnsNewPair ( ) {
        val init = intArrayOf (0, 1, 2, 2)
        val expect = 3
        
        assertEquals ( expect, countMaxPair ( init ) )
    }

    @Test fun givenWithNewPair2_whenCallsCountMaxPair_thenReturnsNewPair ( ) {
        val init = intArrayOf (1, 2, 3, 2, 2)
        val expect = 4
        
        assertEquals ( expect, countMaxPair ( init ) )
    }

    @Test fun givenWithPairInMiddle_whenCallsCountMaxPair_thenReturnsMaxPairInMiddle ( ) {
        val init = intArrayOf (3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4)
        val expect = 5
        
        assertEquals ( expect, countMaxPair ( init ) )
    }

    @Test fun givenWithPairInMiddle1_whenCallsCountMaxPair_thenReturnsMaxPairInMiddle ( ) {
        val init = intArrayOf (1, 1, 2, 2, 3, 4, 4, 4, 4, 4, 5, 6)
        val expect = 6
        
        assertEquals ( expect, countMaxPair ( init ) )
    }

    @Test fun givenWithPairAtEnd_whenCallsCountMaxPair_thenReturnsMaxPairAtEnd ( ) {
        val init = intArrayOf (1, 1, 2, 2, 3, 4, 4, 4, 4, 5, 5)
        val expect = 6
        
        assertEquals ( expect, countMaxPair ( init ) )
    }
}
