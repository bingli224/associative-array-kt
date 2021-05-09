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

class State ( var type: Int, var firstPosition: Int, var lastPosition: Int )

const val MAX_BUCKETS: Int = 2

fun countMaxPair(list: IntArray): Int {
    var max: Int = 0
    var bucketsOrdered = mutableListOf <State> ( )

    for ((idx, type) in list.withIndex ( )) {
        if (bucketsOrdered.size == 0) {
            bucketsOrdered.add (
                State (
                    type,
                    idx,
                    idx
                )
            )
        } else if (bucketsOrdered.size < MAX_BUCKETS + 1) {
            bucketsOrdered.find ({ it.type == type })
                ?. also { state ->
                    state.lastPosition = idx
                } ?: run {
                    bucketsOrdered.add (
                        State (
                            type,
                            idx,
                            idx
                        )
                    )
                }
        } else {
            if (bucketsOrdered.first ( ).type == type || ! bucketsOrdered.any ({ it.type == type })) {
                val keepOld = bucketsOrdered.last ( ).firstPosition - bucketsOrdered.first ( ).firstPosition
                val keepLast = idx - bucketsOrdered.first ( ).lastPosition - 1
                
                if (keepOld < keepLast) {
                    if (max < keepLast) {
                        max = keepLast
                    }
                } else {
                    if (max < keepOld) {
                        max = keepOld
                    }
                }
                
                val newStartingPosition = bucketsOrdered.removeFirst ( ).lastPosition + 1
                for (state in bucketsOrdered) {
                    if (state.firstPosition < newStartingPosition) {
                        state.firstPosition = newStartingPosition
                    }
                }
                bucketsOrdered.add (
                    State (
                        type,
                        idx,
                        idx
                    )
                )
            } else {
                bucketsOrdered.find ({it.type == type})
                    ?.also { state ->
                        state.lastPosition = idx
                    }
            }
        }
    }
    
    val newMax = when (bucketsOrdered.size) {
        0 -> 0
        MAX_BUCKETS + 1 -> {
            val keepOld = bucketsOrdered.last ( ).firstPosition - bucketsOrdered.first ( ).firstPosition
            val keepLast = ( bucketsOrdered.map ({it.lastPosition}).maxOrNull ( )?:0 ) - bucketsOrdered.first ( ).lastPosition
            
            if (keepOld > keepLast)
                keepOld
            else
                keepLast
        }
        else -> ( bucketsOrdered.map ({it.lastPosition}).maxOrNull ( )?:0 ) - bucketsOrdered.first ( ).firstPosition + 1
    }
    
    return if (newMax > max)
        newMax
    else
        max
}
