import assertk.Assert
import assertk.assertAll
import assertk.assertThat
import assertk.assertions.*
import org.junit.Before
import org.junit.Test

class AssertKFruitTest {
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
        assertThat(fruits[0]).isDataClassEqualTo(apple)
    }

    @Test
    fun compareApplesToOranges_shouldNotBeEqual() {
        val fruits = fruitStand.browse()
        // Note: this should fail
        // assertThat(fruits[0]).isDataClassEqualTo(orange)
    }

    @Test
    fun shouldBeTheSameList() {
        val fruits = fruitStand.browse()
        assertThat(fruits).containsExactly(apple, orange, tomato)
    }

    @Test
    fun shouldBeCorrectType() {
        val fruits = fruitStand.browse()
        assertThat(fruits[0]).hasClass(Fruit::class)
        assertThat(fruits[1]).hasClass(Fruit::class)
        assertThat(fruits[2]).hasClass(Fruit::class)
    }

    @Test
    fun shouldExecuteMultipleAsserts() {
        val fruits = fruitStand.browse()
        assertAll {
            assertThat(fruits).isNotNull()
            assertThat(fruits).isNotEmpty()
            assertThat(fruits).hasSize(3)
        }
    }

    @Test
    fun shouldHaveCustomAssert() {
        val fruits = fruitStand.browse()
        assertThat(fruits[0]).isFresh()
    }

    private fun Assert<Fruit>.isFresh() {
        prop(Fruit::isFresh).isTrue()
    }
}
