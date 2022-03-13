class Solution {
  fun isPrefixString(s: String, words: Array<String>): Boolean {
      var sentence = ""
      val wordLength = s.length
      
      for (word in words) {
          val sentenceLength = sentence.length
          if (sentenceLength > wordLength) {
              return false
          } 
          sentence += word
          if (sentence == s) {
              return true
          }
      }
      
      return sentence == s
  }
}