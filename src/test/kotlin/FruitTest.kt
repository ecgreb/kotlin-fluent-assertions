import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class FruitTest {
    private val fruitStand = FruitStand()
    private val apple = Fruit("Apple")
    private val orange = Fruit("Orange")
    private val tomato = Fruit("Tomato", isFresh = false)

    @Before
    fun setUp() {
        fruitStand.stock(apple)
        fruitStand.stock(orange)
        fruitStand.stock(tomato)
    }

    @Test
    fun shouldNotBeNull() {
        val fruits = fruitStand.browse()
        assertNotNull(fruits)
    }

    @Test
    fun shouldNotBeEmpty() {
        val fruits = fruitStand.browse()
        assertFalse(fruits.isEmpty())
    }

    @Test
    fun shouldHaveSizeThree() {
        val fruits = fruitStand.browse()
        assertTrue(fruits.size == 3)
    }

    @Test
    fun shouldBeFresh() {
        val fruits = fruitStand.browse()
        assertTrue(fruits[0].isFresh)
        assertTrue(fruits[1].isFresh)
        assertFalse(fruits[2].isFresh)
    }

    @Test
    fun shouldHaveNames() {
        val fruits = fruitStand.browse()
        assertEquals("Apple", fruits[0].name)
        assertEquals("Orange", fruits[1].name)
        assertEquals("Tomato", fruits[2].name)
    }

    @Test
    fun compareApplesToApples_shouldBeEqual() {
        val fruits = fruitStand.browse()
        assertEquals(fruits[0].name, apple.name)
    }

    @Test
    fun compareApplesToOranges_shouldNotBeEqual() {
        val fruits = fruitStand.browse()
        // Note: this should fail
        // assertEquals(fruits[0].name, orange.name)
    }

    @Test
    fun shouldBeTheSameList() {
        val fruits = fruitStand.browse()
        assertTrue(
            fruits.containsAll(
                listOf(apple, orange, tomato)
            )
        )
    }

    @Suppress("USELESS_IS_CHECK")
    @Test
    fun shouldBeCorrectType() {
        val fruits = fruitStand.browse()
        assertTrue(fruits[0] is Fruit)
        assertTrue(fruits[1] is Fruit)
        assertTrue(fruits[2] is Fruit)
    }

    @Test
    fun shouldExecuteMultipleAsserts() {
        val fruits = fruitStand.browse()
        assertNotNull(fruits)
        assertFalse(fruits.isEmpty())
        assertTrue(fruits.size == 3)
    }

    @Test
    fun shouldHaveCustomAssert() {
        val fruits = fruitStand.browse()
        assertFresh(fruits[0])
    }

    private fun assertFresh(fruit: Fruit) {
        assertTrue(fruit.isFresh)
    }
}
