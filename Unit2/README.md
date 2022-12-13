## Kotlin에서 클래스 및 객체 사용

### 객체지향 프로그래밍(OOP)

- 캡슐화 : 관련된 Property들을 래핑한다. 사용자들은 내부의 Property들의 상호작용을 고려할 필요가 없다.
- 추상화 : 캡슐화의 확장으로 내부 구현 로직을 숨긴다. 
- 상속 : 상위-하위 클래스 관계를 설정하여 다른 클래스의 특성 및 동작을 기반으로 클래스를 빌드한다.
- 다형성 : 여러 객체를 한가지 공통 방식으로 사용한다.

## 연습 : Kotlin 기초

- 모바일 알림
```kotlin
fun main() {
    val morningNotification = 51
    val eveningNotification = 135
    
    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}

fun printNotificationSummary(numberOfMessages: Int) {
    if(numberOfMessages < 100) {
        println("You have $numberOfMessages notifications.")
    } else {
        println("Your phone is blowing up! You have 99+ notifications.")
    }
}
```

- 영화 티켓 가격
```kotlin
fun main() {
    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true

    println("The movie ticket price for a person aged $child is  \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
}

fun ticketPrice(age: Int, isMonday: Boolean): Int {
    return when(age) {
        in 1..12 -> 15
        in 13..60 -> if(isMonday) 25 else 30
        in 61..100 -> {
            20
        }
        else -> -1
    }
}
```

- 온도 변환기
``` kotlin
fun main() {
    printFinalTemperature(
    	27.0,
        "Celsius",
        "Fahrenheit"
    ) { temp ->
        (temp * 9 / 5) + 32
    }
    
    printFinalTemperature(
    	350.0,
        "Kelvin",
        "Celsius"
    ) { temp ->
        temp - 273.15
    }
    
    printFinalTemperature(
    	10.0,
        "Fahrenheit",
        "Kelvin"
    ) { temp ->
        ((temp - 32) * 5 / 9)  + 273.15
    }
}

fun printFinalTemperature(
	initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement))

    
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit")
}
```

- 노래 카탈로그
``` kotlin
fun main() {
    Song(
    	title = "test",
        artist = "test2",
        presentYear = 2022,
        playTimes = 900
    ).printSong()
}

class Song(
	val title: String,
    val artist: String,
    val presentYear: Int,
    val playTimes: Int,
    val isFamous: Boolean = playTimes > 1000
) {
    fun printSong() {
        println("$title, 연주한 $artist, 출시한 $presentYear, 유명한가? $isFamous")
    }
}
```

- 인터넷 프로필
``` kotlin
fun main() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)
    
    amanda.showProfile()
    atiqah.showProfile()
}

class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        println("Name: $name")
        println("Age: $age")
        
        referrer?.let{
            println("Likes to $hobby. Has a referrer named ${it.name}, who likes to ${it.hobby}")
        } ?: run { // 꼭 run을 붙여야 동작함!
            println("Likes to $hobby. Doesn`t have a referrer.")
        }
    }
}
```

- 폴더블 스마트폰
```kotlin
fun main() {
    val phone = FoldablePhone()
    
    phone.defoldingPhone()
    phone.switchOn()
    phone.checkPhoneScreenLight()
}

class FoldablePhone(var isFoldable: Boolean = false) : Phone() {
    fun foldingPhone() {
        isFoldable = true
    }
    
    fun defoldingPhone() {
        isFoldable = false
    }
    
    override fun switchOn() {
        if(!isFoldable) { // 접혀있지 않을 때만, 스위치 온
          	super.switchOn()  
        }
    }
}

open class Phone(var isScreenLightOn: Boolean = false) {
    open fun switchOn() {
        isScreenLightOn = true
    }
    
    fun switchOff() {
        isScreenLightOn = false
    }
    
    fun checkPhoneScreenLight() {
        val phoneScreenLight = if(isScreenLightOn) "on" else "off"
        println("Thre phone screen`s light is $phoneScreenLight.")
    }
} 
```

- 특별 경매
```kotlin
fun main() {
    val winningBid = Bid(5000, "Private Collector")
    
    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")
    println("Item B is sold at ${auctionPrice(null, 3000)}.")
}

class Bid(val amount: Int, val bidder: String)

fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
    return bid?.let { 
        if(it.amount >= minimumPrice) {
           	it.amount 
        } else {
            minimumPrice
        }
    } ?: run {
        minimumPrice
    }
}
```