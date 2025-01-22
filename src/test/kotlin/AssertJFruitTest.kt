import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class AssertJFruitTest {
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
        assertThat(fruits).isNotNull()
    }

    @Test
    fun shouldNotBeEmpty() {
        val fruits = fruitStand.browse()
        assertThat(fruits).isNotEmpty()
    }

    @Test
    fun shouldHaveSizeThree() {
        val fruits = fruitStand.browse()
        assertThat(fruits).hasSize(3)
    }

    @Test
    fun shouldBeFresh() {
        val fruits = fruitStand.browse()
        assertThat(fruits[0].isFresh).isTrue()
        assertThat(fruits[1].isFresh).isTrue()
        assertThat(fruits[2].isFresh).isFalse()
    }

    @Test
    fun shouldHaveNames() {
        val fruits = fruitStand.browse()
        assertThat(fruits)
            .extracting(Fruit::name)
            .containsExactly("Apple", "Orange", "Tomato")
    }

    @Test
    fun compareApplesToApples_shouldBeEqual() {
        val fruits = fruitStand.browse()
        assertThat(fruits[0]).isEqualTo(apple)
    }

    @Test
    fun compareApplesToOranges_shouldNotBeEqual() {
        val fruits = fruitStand.browse()
        // Note: this should fail
        // assertThat(fruits[0]).isEqualTo(orange)
        assertThat(apple).isEqualTo(orange)
    }

    @Test
    fun shouldBeTheSameList() {
        val fruits = fruitStand.browse()
        assertThat(fruits).containsExactly(apple, orange, tomato)
    }

    @Test
    fun shouldBeCorrectType() {
        val fruits = fruitStand.browse()
        assertThat(fruits[0]).isInstanceOf(Fruit::class.java)
        assertThat(fruits[1]).isInstanceOf(Fruit::class.java)
        assertThat(fruits[2]).isInstanceOf(Fruit::class.java)
    }

    @Test
    fun shouldExecuteMultipleAsserts() {
        val fruits = fruitStand.browse()
        assertThat(fruits).apply {
            isNotNull()
            isNotEmpty()
            hasSize(3)
        }
    }

    @Test
    fun shouldHaveCustomAssert() {
        val fruits = fruitStand.browse()
        assertThat(fruits[0]).isFresh()
    }

    private fun Fruit.isFresh() {
        assertThat(this.isFresh).isTrue()
    }
}
