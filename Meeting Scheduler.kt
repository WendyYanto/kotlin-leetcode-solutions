class Solution {
  fun minAvailableDuration(slots1: Array<IntArray>, slots2: Array<IntArray>, duration: Int): List<Int> {
      var firstSlot = 0
      var secondSlot = 0
      
      val sortedSlots1 = slots1.sortedBy { it[0] }
      val sortedSlots2 = slots2.sortedBy { it[0] }
      
      while (firstSlot < sortedSlots1.size && secondSlot < sortedSlots2.size) {
          val intersection = getIntersection(sortedSlots1[firstSlot], sortedSlots2[secondSlot])
          
          if (intersection.isNotEmpty() && intersection[0] + duration <= intersection[1]) {
              return listOf(intersection[0], intersection[0] + duration)
          } else if (sortedSlots1[firstSlot][1] < sortedSlots2[secondSlot][1]) {
              firstSlot++
          } else {
              secondSlot++
          }
      }
      
      return emptyList()
  }
  
  private fun getIntersection(firstSlot: IntArray, secondSlot: IntArray): List<Int> {
      val smallerSlot: IntArray
      val largerSlot: IntArray
      
      if (firstSlot[0] < secondSlot[0]) {
          smallerSlot = firstSlot
          largerSlot = secondSlot
      } else {
          smallerSlot = secondSlot
          largerSlot = firstSlot
      }
      
      return if (smallerSlot[1] > largerSlot[0]) {
          listOf(largerSlot[0], minOf(largerSlot[1], smallerSlot[1]))
      } else {
          emptyList()
      }
  }
}