/*
 *	// Definition for an Interval.
 *	class Interval {
 *		var start:Int = 0
 *		var end:Int = 0
 *	
 *		constructor(_start:Int, _end:Int) {
 *			start = _start
 *			end = _end
 *		}
 *	}
 */

class Solution {
  fun employeeFreeTime(schedule: ArrayList<ArrayList<Interval>>): ArrayList<Interval> {
      val sortedSchedule = schedule.flatMap { it }.sortedBy { it.start }
      
      var start = -1
      var end = -1
      
      var freeIntervals: ArrayList<Interval> = arrayListOf()
      
      for (interval in sortedSchedule) {
          if (start == -1 && end == -1) {
              start = interval.start
              end = interval.end
          } else {
              if (interval.start <= end) {
                  start = minOf(interval.start, start)
                  end = maxOf(interval.end, end)
              } else {
                  freeIntervals.add(Interval(end, interval.start))
                  
                  start = interval.start
                  end = interval.end
              }
          }
      }
      
      return freeIntervals
  }
}