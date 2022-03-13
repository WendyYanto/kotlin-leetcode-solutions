class ParkingSystem(private val big: Int, 
                    private val medium: Int, 
                    private val small: Int) {

    private var bigCount = 0
    private var smallCount = 0
    private var mediumCount = 0
    
    fun addCar(carType: Int): Boolean {
        return when (carType) {
            1 -> {
                if (bigCount < big) {
                    bigCount++
                    return true
                } else {
                    return false
                }
            } 
            2 -> {
                if (mediumCount < medium) {
                    mediumCount++
                    return true
                } else {
                    return false
                }
            } 
            else -> {
                if (smallCount < small) {
                    smallCount++
                    return true
                } else {
                    return false
                } 
            }
        }
    }

}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * var obj = ParkingSystem(big, medium, small)
 * var param_1 = obj.addCar(carType)
 */