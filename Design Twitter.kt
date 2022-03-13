class Twitter() {

    /** Initialize your data structure here. */
    private val tweets = mutableListOf<Pair<Int, Int>>()
    private val followers = mutableMapOf<Int, MutableList<Int>>()
    
    /** Compose a new tweet. */
    fun postTweet(userId: Int, tweetId: Int) {
        tweets.add(userId to tweetId)
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    fun getNewsFeed(userId: Int): List<Int> {
        return tweets.filter { tweet ->
           followers[userId]?.contains(tweet.first) == true || tweet.first == userId
        }.map { tweet ->
            tweet.second
        }.takeLast(10)
         .reversed()
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    fun follow(followerId: Int, followeeId: Int) {
        followers[followerId]?.let { safeFollowers ->
            safeFollowers.add(followeeId)
        } ?: run {
            followers[followerId] = mutableListOf<Int>()
            followers[followerId]?.add(followeeId)
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    fun unfollow(followerId: Int, followeeId: Int) {
        followers[followerId]?.let { safeFollowers ->
            safeFollowers.remove(followeeId)
        }
    }

}

/**
 * Your Twitter object will be instantiated and called as such:
 * var obj = Twitter()
 * obj.postTweet(userId,tweetId)
 * var param_2 = obj.getNewsFeed(userId)
 * obj.follow(followerId,followeeId)
 * obj.unfollow(followerId,followeeId)
 */