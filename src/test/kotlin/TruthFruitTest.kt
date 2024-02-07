import TruthFruitTest.FruitSubject.Companion.assertThat
import com.google.common.truth.FailureMetadata
import com.google.common.truth.Subject
import com.google.common.truth.Subject.Factory
import com.google.common.truth.Truth.assertAbout
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class TruthFruitTest {
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
        assertThat(fruits[0].name).isEqualTo("Apple")
        assertThat(fruits[1].name).isEqualTo("Orange")
        assertThat(fruits[2].name).isEqualTo("Tomato")
    }

    @Test
    fun compareApplesToApples_shouldBeEqual() {
        val fruits = fruitStand.browse()
        assertThat(fruits[0].name).isEqualTo(apple.name)
    }

    @Test
    fun compareApplesToOranges_shouldNotBeEqual() {
        val fruits = fruitStand.browse()
        // Note: this should fail
        // assertThat(fruits[0].name).isEqualTo(orange.name)
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

    class FruitSubject(
        metadata: FailureMetadata,
        private val actual: Fruit?
    ) : Subject(metadata, actual) {
        fun isFresh() {
            check("isFresh()").that(actual?.isFresh).isTrue()
        }

        companion object {
            @JvmStatic
            fun assertThat(fruit: Fruit?): FruitSubject = assertAbout(fruits()).that(fruit)

            @JvmStatic
            fun fruits() = Factory<FruitSubject, Fruit>(::FruitSubject)
        }
    }
}
