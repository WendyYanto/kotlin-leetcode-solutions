class Codec() {
    var tinyUrl = "http://tinyurl.com";
    var counter = 1;
    var cache: MutableMap<String, String> = mutableMapOf()
    // Encodes a URL to a shortened URL.
    fun encode(longUrl: String): String {
        val generatedUrl = tinyUrl + "/" + counter
        cache[generatedUrl] = longUrl
        counter++
        return generatedUrl ?: ""
    }

    // Decodes a shortened URL to its original URL.
    fun decode(shortUrl: String): String {
        return cache[shortUrl] ?: "";
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * var obj = Codec()
 * var url = obj.encode(longUrl)
 * var ans = obj.decode(url)
 */